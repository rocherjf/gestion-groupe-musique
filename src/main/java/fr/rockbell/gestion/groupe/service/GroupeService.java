package fr.rockbell.gestion.groupe.service;

import java.util.List;

import fr.rockbell.gestion.groupe.dto.AlbumDTO;
import fr.rockbell.gestion.groupe.dto.ConcertDTO;
import fr.rockbell.gestion.groupe.dto.GroupeDTO;

public interface GroupeService {
	
	List<GroupeDTO> recupererTousLesGroupes();
	
	GroupeDTO recupererGroupeByID(long id);
	
	GroupeDTO creerGroupe(GroupeDTO groupe);
	
	
	GroupeDTO ajouterUnAlbumAUnGroupe(long idGroupe, AlbumDTO album);
	
	GroupeDTO ajouterUnConcertAUnGroupe(long idGroupe, ConcertDTO concert);
	
	
	List<ConcertDTO> recupererTousLesConcertsPourUnGroupe(long idGroupe);
	
}
