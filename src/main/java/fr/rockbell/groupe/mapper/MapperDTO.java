package fr.rockbell.groupe.mapper;

import java.util.List;

import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;

import fr.rockbell.groupe.controller.GroupeController;
import fr.rockbell.groupe.dto.AlbumDTO;
import fr.rockbell.groupe.dto.ConcertDTO;
import fr.rockbell.groupe.dto.GroupeDTO;
import fr.rockbell.groupe.entity.Album;
import fr.rockbell.groupe.entity.Concert;
import fr.rockbell.groupe.entity.Groupe;
import fr.rockbell.groupe.external.input.AlbumInput;
import fr.rockbell.groupe.external.input.ConcertInput;
import fr.rockbell.groupe.external.input.GroupeInput;
import fr.rockbell.groupe.external.output.AlbumOutput;
import fr.rockbell.groupe.external.output.ConcertOutput;
import fr.rockbell.groupe.external.output.GroupeOutput;

@Mapper
public interface MapperDTO {

	// External entities (Input) -> DTO
	@Mapping(target = "albums", ignore = true)
	@Mapping(target = "concerts", ignore = true)
	@Mapping(target = "id", ignore = true)
	public GroupeDTO fromGroupeInputToGroupeDTO(GroupeInput groupe);

	public List<GroupeDTO> fromGroupeInputToGroupeDTO(List<GroupeInput> groupe);

	@Mapping(target = "id", ignore = true)
	public AlbumDTO fromAlbumInputToAlbumDTO(AlbumInput album);
	public List<AlbumDTO> fromAlbumInputToAlbumDTO(List<AlbumInput> album);

	@Mapping(target = "id", ignore = true)
	public ConcertDTO fromConcertInputToConcertDTO(ConcertInput concert);
	public List<ConcertDTO> fromConcertInputToConcertDTO(List<ConcertInput> concert);

	// Entity -> DTO
	public GroupeDTO fromGroupeToGroupeDTO(Groupe groupe);
	public List<GroupeDTO> fromGroupeToGroupeDTO(List<Groupe> groupe);

	public AlbumDTO fromAlbumToAlbumDTO(Album album);
	public List<AlbumDTO> fromAlbumToAlbumDTO(List<Album> album);

	public ConcertDTO fromConcertToConcertDTO(Concert concert);
	public List<ConcertDTO> fromConcertToConcertDTO(List<Concert> concert);

	// DTO -> External entities
	public GroupeOutput fromGroupeDTOToGroupeOutput(GroupeDTO groupe);
	public List<GroupeOutput> fromGroupeDTOToGroupeOutput(List<GroupeDTO> groupe);

	public AlbumOutput fromAlbumDTOToAlbumOutput(AlbumDTO album);
	public List<AlbumOutput> fromAlbumDTOToAlbumOutput(List<AlbumDTO> album);

	public ConcertOutput fromConcertDTOToConcertOutput(ConcertDTO concert);
	public List<ConcertOutput> fromConcertDTOToConcertOutput(List<ConcertDTO> concert);

	@AfterMapping
	public default void addLinks(GroupeDTO groupe, @MappingTarget GroupeOutput groupeOutput) {
		groupeOutput.add(WebMvcLinkBuilder.linkTo(GroupeController.class).slash(groupe.getId()).withSelfRel());
		groupeOutput.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(GroupeController.class).getAllGroupe()).withRel("allGroupes"));
	}
	
}
