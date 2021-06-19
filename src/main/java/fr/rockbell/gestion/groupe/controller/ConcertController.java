package fr.rockbell.gestion.groupe.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.hateoas.CollectionModel;
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

	@GetMapping(produces = {"application/hal+json"})
	public CollectionModel<ConcertOutput> recupererTousLesConcertsDUnGroupe(
			@RequestParam(required = false) Long idGroupe) {

		var linkSelfRef = linkTo(methodOn(ConcertController.class).recupererTousLesConcertsDUnGroupe(idGroupe))
				.withSelfRel();

		if (idGroupe == null) {
			return CollectionModel.of(
					groupeDTOMapper.fromConcertDTOToConcertOutput(concertService.recupererTousLesConcerts()),
					linkSelfRef);
		} else {
			return CollectionModel.of(groupeDTOMapper.fromConcertDTOToConcertOutput(
					concertService.recupererTousLesConcertsDunGroupe(idGroupe.longValue())),
					linkSelfRef);
		}

	}

	@GetMapping(path = "/{id}", produces = {"application/hal+json"})
	public ConcertOutput recupererConcertViaSonId(@PathVariable(name = "id") long id) {
		return groupeDTOMapper.fromConcertDTOToConcertOutput(concertService.recupererUnConcertViaSonId(id));

	}
}
