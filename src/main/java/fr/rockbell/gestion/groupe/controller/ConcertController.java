package fr.rockbell.gestion.groupe.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.rockbell.gestion.groupe.external.output.ConcertOutput;
import fr.rockbell.gestion.groupe.mapper.MapperDTO;
import fr.rockbell.gestion.groupe.service.ConcertService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/concerts")
@RequiredArgsConstructor
public class ConcertController {
	
	
	private final ConcertService concertService;
	
	private final MapperDTO groupeDTOMapper;
	
	
	@GetMapping
	public List<ConcertOutput> recupererTousLesConcertsDUnGroupe(@RequestParam Long idGroupe){

		if(idGroupe == null) {
			return groupeDTOMapper.fromConcertDTOToConcertOutput(concertService.recupererTousLesConcerts());
		}else {
			return groupeDTOMapper.fromConcertDTOToConcertOutput(concertService.recupererTousLesConcertsDunGroupe(idGroupe.longValue()));
		}
		
	}
	
	
	@GetMapping("/{id}")
	public ConcertOutput recupererConcertViaSonId(@PathVariable(name = "id") long id) {
		return groupeDTOMapper.fromConcertDTOToConcertOutput(concertService.recupererUnConcertViaSonId(id));
		
	}
}
