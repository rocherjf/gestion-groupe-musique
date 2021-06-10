package fr.rockbell.gestion.groupe.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.rockbell.gestion.groupe.dto.GroupeDTO;
import fr.rockbell.gestion.groupe.external.input.AlbumInput;
import fr.rockbell.gestion.groupe.external.input.ConcertInput;
import fr.rockbell.gestion.groupe.external.input.GroupeInput;
import fr.rockbell.gestion.groupe.external.output.GroupeOutput;
import fr.rockbell.gestion.groupe.mapper.MapperDTO;
import fr.rockbell.gestion.groupe.service.GroupeService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/groupes")
@RequiredArgsConstructor
public class GroupeController {
	
	private final GroupeService groupeService;
	
	private final MapperDTO groupeDTOMapper;
	
	@GetMapping
	public List<GroupeOutput> recupererTousLesGroupes() {
		List<GroupeDTO> groupes = groupeService.recupererTousLesGroupes();
		return groupeDTOMapper.fromGroupeDTOToGroupeOutput(groupes);
	}
	
	@GetMapping("/{id}")
	public GroupeOutput recupererGroupeViaSonId(@PathVariable(name = "id") long id) {
		GroupeDTO groupe = groupeService.recupererGroupeByID(id);
		return groupeDTOMapper.fromGroupeDTOToGroupeOutput(groupe);
	}
	
	@PostMapping
	public GroupeOutput creerGroupe(@RequestBody GroupeInput groupeACreer) {
		GroupeDTO groupe = groupeService.creerGroupe(groupeDTOMapper.fromGroupeInputToGroupeDTO(groupeACreer));
		return groupeDTOMapper.fromGroupeDTOToGroupeOutput(groupe);
	}
	
	
	@PostMapping("/{id}/albums")
	public GroupeOutput ajouterAlbumGroupe(@PathVariable(name = "id") long idGroupe, @RequestBody AlbumInput album) {
		GroupeDTO groupe = groupeService.ajouterUnAlbumAUnGroupe(idGroupe,groupeDTOMapper.fromAlbumInputToAlbumDTO(album));
		return groupeDTOMapper.fromGroupeDTOToGroupeOutput(groupe);
	}
	
	@PostMapping("/{id}/concerts")
	public GroupeOutput ajouterConcertGroupe(@PathVariable(name = "id") long idGroupe, @RequestBody ConcertInput concert) {
		GroupeDTO groupe = groupeService.ajouterUnConcertAUnGroupe(idGroupe,groupeDTOMapper.fromConcertInputToConcertDTO(concert));
		return groupeDTOMapper.fromGroupeDTOToGroupeOutput(groupe); 
	}
	
}
