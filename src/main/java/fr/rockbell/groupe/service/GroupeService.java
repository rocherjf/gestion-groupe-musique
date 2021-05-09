package fr.rockbell.groupe.service;

import java.util.List;

import fr.rockbell.groupe.dto.AlbumDTO;
import fr.rockbell.groupe.dto.ConcertDTO;
import fr.rockbell.groupe.dto.GroupeDTO;

public interface GroupeService {
	
	List<GroupeDTO> getAllGroupes();
	
	GroupeDTO getGroupeByID(long id);
	
	GroupeDTO createGroupe(GroupeDTO groupe);
	
	
	GroupeDTO ajouterUnAlbumAUnGroupe(long idGroupe, AlbumDTO album);
	
	GroupeDTO ajouterUnConcertAUnGroupe(long idGroupe, ConcertDTO concert);
	
}
