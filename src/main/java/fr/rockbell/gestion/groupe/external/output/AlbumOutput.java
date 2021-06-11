package fr.rockbell.gestion.groupe.external.output;

import org.springframework.hateoas.RepresentationModel;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class AlbumOutput extends RepresentationModel<GroupeOutput> {
	
	private String nom;
	
	private String genre;
	
	private String annee;
	
	private String description;
	
	private String urlImage;

}
