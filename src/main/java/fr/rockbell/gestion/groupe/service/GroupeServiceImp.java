package fr.rockbell.gestion.groupe.service;

import java.util.List;

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
		return groupeMapper.fromGroupeToGroupeDTO(groupeRepository.findById(id).orElseThrow());
	}

	@Override
	public GroupeDTO creerGroupe(GroupeDTO groupe) {

		var groupeACreer = groupeRepository.save(Groupe.buildfromDTO(groupe));
		return groupeMapper.fromGroupeToGroupeDTO(groupeRepository.findById(groupeACreer.getId()).orElseThrow());
	}

	@Override
	public GroupeDTO ajouterUnAlbumAUnGroupe(long idGroupe, AlbumDTO album) {

		var groupe = groupeRepository.findById(idGroupe).orElseThrow();
		groupe.ajouterAlbum(album);
		return groupeMapper.fromGroupeToGroupeDTO(groupeRepository.save(groupe));
	}

	@Override
	public GroupeDTO ajouterUnConcertAUnGroupe(long idGroupe,
			ConcertDTO concert) {

		var groupe = groupeRepository.findById(idGroupe).orElseThrow();
		groupe.ajouterConcert(concert);
		return groupeMapper.fromGroupeToGroupeDTO(groupeRepository.save(groupe));
	}

	@Override
	public List<ConcertDTO> recupererTousLesConcertsPourUnGroupe(long idGroupe) {
		var groupe = groupeRepository.findById(idGroupe).orElseThrow();
		return groupeMapper.fromConcertToConcertDTO(groupe.getConcerts());
	}

}
