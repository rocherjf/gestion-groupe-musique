package fr.rockbell.groupe.dto;

import java.util.List;

import fr.rockbell.groupe.entity.Album;
import fr.rockbell.groupe.entity.Concert;
import lombok.Data;

@Data
public class GroupeDTO {
	
	private long id;

	private String nom;

	private String pays;

	private String biographie;

	private List<Album> albums;
	
	private List<Concert> concerts;

}
