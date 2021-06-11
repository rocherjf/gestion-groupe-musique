package fr.rockbell.gestion.groupe.controller;

import java.util.List;

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
	
	
	@GetMapping
	public List<AlbumOutput> recupererTousLesAlbumsDUnGroupe(@RequestParam(required = false) Long idGroupe){

		if(idGroupe == null) {
			return groupeDTOMapper.fromAlbumDTOToAlbumOutput(albumService.recupererTousLesAlbums());
		}else {
			return groupeDTOMapper.fromAlbumDTOToAlbumOutput(albumService.recupererTousLesAlbumsDunGroupe(idGroupe.longValue()));
		}
		
	}
	
	
	@GetMapping("/{id}")
	public AlbumOutput recupererAlbumViaSonId(@PathVariable(name = "id") long id) {
		return groupeDTOMapper.fromAlbumDTOToAlbumOutput(albumService.recupererUnAlbumViaSonId(id));
		
	}
}
