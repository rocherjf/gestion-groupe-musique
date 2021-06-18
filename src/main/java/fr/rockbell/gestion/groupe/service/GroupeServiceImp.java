package fr.rockbell.gestion.groupe.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import fr.rockbell.gestion.groupe.dto.AlbumDTO;
import fr.rockbell.gestion.groupe.dto.ConcertDTO;
import fr.rockbell.gestion.groupe.dto.GroupeDTO;
import fr.rockbell.gestion.groupe.entity.Groupe;
import fr.rockbell.gestion.groupe.mapper.MapperDTO;
import fr.rockbell.gestion.groupe.repository.GroupeRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GroupeServiceImp implements GroupeService {

	private final GroupeRepository groupeRepository;
	private final MapperDTO groupeMapper;

	@Override
	public List<GroupeDTO> recupererTousLesGroupes() {
		return groupeMapper.fromGroupeToGroupeDTO(groupeRepository.findAll());
	}

	@Override
	public GroupeDTO recupererGroupeByID(long id) {
		return groupeMapper.fromGroupeToGroupeDTO(groupeRepository.findById(id).orElseThrow(NoSuchElementException::new));
	}

	@Override
	public GroupeDTO creerGroupe(GroupeDTO groupe) {

		var groupeACreer = groupeRepository.save(Groupe.buildfromDTO(groupe));
		return groupeMapper.fromGroupeToGroupeDTO(groupeRepository.findById(groupeACreer.getId()).orElseThrow(NoSuchElementException::new));
	}

	@Override
	public GroupeDTO ajouterUnAlbumAUnGroupe(long idGroupe, AlbumDTO album) {

		var groupe = groupeRepository.findById(idGroupe).orElseThrow(NoSuchElementException::new);
		groupe.ajouterAlbum(album);
		return groupeMapper.fromGroupeToGroupeDTO(groupeRepository.save(groupe));
	}

	@Override
	public GroupeDTO ajouterUnConcertAUnGroupe(long idGroupe,
			ConcertDTO concert) {

		var groupe = groupeRepository.findById(idGroupe).orElseThrow(NoSuchElementException::new);
		groupe.ajouterConcert(concert);
		return groupeMapper.fromGroupeToGroupeDTO(groupeRepository.save(groupe));
	}

	@Override
	public List<ConcertDTO> recupererTousLesConcertsPourUnGroupe(long idGroupe) {
		var groupe = groupeRepository.findById(idGroupe).orElseThrow();
		return groupeMapper.fromConcertToConcertDTO(groupe.getConcerts());
	}

	@Override
	public GroupeDTO mettreAJourLeGroupe(long idGroupe, GroupeDTO groupe) {
		
		if(!groupeRepository.existsById(idGroupe)) {
			throw new UnsupportedOperationException("Le groupe n'existe pas. Pour créer un groupe utiliser la méthode POST");
		}

		groupe.setId(idGroupe);
		var groupeACreer = groupeRepository.save(Groupe.buildfromDTO(groupe));
		
		return groupeMapper.fromGroupeToGroupeDTO(groupeRepository.findById(groupeACreer.getId()).orElseThrow());
	}
	
	@Override
	public void supprimerGroupe(long idGroupe) {
		groupeRepository.deleteById(idGroupe);
	}

}
