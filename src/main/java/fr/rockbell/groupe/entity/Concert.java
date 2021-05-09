package fr.rockbell.groupe.entity;

import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import fr.rockbell.groupe.dto.ConcertDTO;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Concert {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;
	
	private String ville;
	
	private String nomDeLaSalle;
	
	private String refExterne;
	
	private Instant date;
	
	
	
	protected static Concert buildFromConcertDTO(ConcertDTO concertDTO) {
		
		if(concertDTO == null) {
			throw new IllegalStateException(
					"L'album ne peut pas être null");
		}
		
		if (concertDTO.getNomDeLaSalle().isEmpty()) {
			throw new IllegalStateException(
					"Le nom de la salle ne peut pas être vide");
		}
		
		if (concertDTO.getDate()== null) {
			throw new IllegalStateException(
					"La date du concert ne peut pas être null");
		}
		
		Concert concert = new Concert();
		concert.date = concertDTO.getDate();
		concert.nomDeLaSalle = concertDTO.getNomDeLaSalle();
		concert.refExterne = concertDTO.getRefExterne();
		concert.ville = concertDTO.getVille();

		return concert;

	}

}
