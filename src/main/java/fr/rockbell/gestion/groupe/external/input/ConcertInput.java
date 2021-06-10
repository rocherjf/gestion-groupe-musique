package fr.rockbell.gestion.groupe.external.input;

import java.time.Instant;

import lombok.Data;

@Data
public class ConcertInput {
	
	private String ville;
	
	private String nomDeLaSalle;
	
	private Instant date;
	
	private String refExterne;

}
