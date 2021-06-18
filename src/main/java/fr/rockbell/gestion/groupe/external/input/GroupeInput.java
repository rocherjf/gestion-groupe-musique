package fr.rockbell.gestion.groupe.external.input;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GroupeInput {
	
	private String nom;

	private String pays;

	private String biographie;
	
}
