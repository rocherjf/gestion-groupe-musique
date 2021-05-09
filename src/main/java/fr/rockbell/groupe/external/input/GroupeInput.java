package fr.rockbell.groupe.external.input;

import java.time.Instant;

import lombok.Data;

@Data
public class GroupeInput {
	
	private String nom;

	private String pays;

	private String biographie;
	
	private Instant date;

}
