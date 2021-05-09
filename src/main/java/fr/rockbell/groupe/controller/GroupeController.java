package fr.rockbell.groupe.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.rockbell.groupe.dto.GroupeDTO;
import fr.rockbell.groupe.external.input.AlbumInput;
import fr.rockbell.groupe.external.input.ConcertInput;
import fr.rockbell.groupe.external.input.GroupeInput;
import fr.rockbell.groupe.external.output.GroupeOutput;
import fr.rockbell.groupe.mapper.MapperDTO;
import fr.rockbell.groupe.service.GroupeService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/groupes")
@RequiredArgsConstructor
public class GroupeController {
	
	private final GroupeService groupeService;
	
	private final MapperDTO groupeDTOMapper;
	
	@GetMapping
	public List<GroupeOutput> getAllGroupe() {
		List<GroupeDTO> groupes = groupeService.getAllGroupes();
		return groupeDTOMapper.fromGroupeDTOToGroupeOutput(groupes);
	}
	
	@GetMapping("/{id}")
	public GroupeOutput getGroupeById(@PathVariable(name = "id") long id) {
		GroupeDTO groupe = groupeService.getGroupeByID(id);
		return groupeDTOMapper.fromGroupeDTOToGroupeOutput(groupe);
	}
	
	@PostMapping
	public GroupeOutput createGroupe(@RequestBody GroupeInput groupeACreer) {
		GroupeDTO groupe = groupeService.createGroupe(groupeDTOMapper.fromGroupeInputToGroupeDTO(groupeACreer));
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
