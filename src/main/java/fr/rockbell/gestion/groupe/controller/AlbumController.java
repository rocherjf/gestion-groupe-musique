package fr.rockbell.gestion.groupe.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.hateoas.CollectionModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.rockbell.gestion.groupe.external.output.AlbumOutput;
import fr.rockbell.gestion.groupe.mapper.MapperDTO;
import fr.rockbell.gestion.groupe.service.AlbumService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/albums")
@RequiredArgsConstructor
public class AlbumController {
	
	
	private final AlbumService albumService;
	
	private final MapperDTO groupeDTOMapper;
	
	
	@GetMapping(produces = { "application/hal+json" })
	public CollectionModel<AlbumOutput> recupererTousLesAlbumsDUnGroupe(@RequestParam(required = false) Long idGroupe){
		
		if(idGroupe == null) {
			var linkSelfRef = linkTo(AlbumController.class).withSelfRel(); 
			return CollectionModel.of(groupeDTOMapper.fromAlbumDTOToAlbumOutput(albumService.recupererTousLesAlbums()), linkSelfRef);
		}else {
			var linkSelfRef = linkTo(methodOn(AlbumController.class).recupererTousLesAlbumsDUnGroupe(idGroupe)).withSelfRel(); 
			return CollectionModel.of(groupeDTOMapper.fromAlbumDTOToAlbumOutput(albumService.recupererTousLesAlbumsDunGroupe(idGroupe.longValue())), linkSelfRef);
		}
		
	}
	
	
	@GetMapping(path = "/{id}", produces = { "application/hal+json" })
	public AlbumOutput recupererAlbumViaSonId(@PathVariable(name = "id") long id) {
		return groupeDTOMapper.fromAlbumDTOToAlbumOutput(albumService.recupererUnAlbumViaSonId(id));
		
	}
}
