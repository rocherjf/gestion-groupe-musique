package fr.rockbell.groupe.external.output;

import java.time.Instant;

import lombok.Data;

@Data
public class ConcertOutput  {

	private String ville;

	private String nomDeLaSalle;

	private Instant date;

	private String refExterne;

}
