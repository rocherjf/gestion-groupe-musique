package fr.rockbell.gestion.groupe.dto;

import java.time.Instant;

import lombok.Data;

@Data
public class ConcertDTO {

	private String id;
	
	private String ville;
	
	private String nomDeLaSalle;
	
	private String refExterne;
	
	private Instant date;
	
	private long idGroupe;
	
	
}
