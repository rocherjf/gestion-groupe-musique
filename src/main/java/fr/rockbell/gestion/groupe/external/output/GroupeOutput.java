package fr.rockbell.gestion.groupe.external.output;

import java.util.List;

import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Relation(collectionRelation = "groupes")
public class GroupeOutput extends RepresentationModel<GroupeOutput>{
	
	private long id;
	
	private String nom;

	private String pays;

	private String biographie;
	
	private List<AlbumOutput> albums;
	
	private List<ConcertOutput> concerts;

}
