package fr.rockbell.gestion.groupe.service;

import java.util.List;

import fr.rockbell.gestion.groupe.dto.ConcertDTO;

public interface ConcertService {
	
	List<ConcertDTO> recupererTousLesConcerts();
	
	List<ConcertDTO> recupererTousLesConcertsDunGroupe(long idGroupe);
	
	
	ConcertDTO recupererUnConcertViaSonId(long idConcert);
	
}
