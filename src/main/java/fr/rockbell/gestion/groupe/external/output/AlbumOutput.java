package fr.rockbell.gestion.groupe.external.output;

import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Relation(collectionRelation = "albums")
public class AlbumOutput extends RepresentationModel<GroupeOutput> {
	
	private String nom;
	
	private String genre;
	
	private String annee;
	
	private String description;
	
	private String urlImage;

}
