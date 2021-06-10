package fr.rockbell.gestion.groupe.service;

import java.util.List;

import fr.rockbell.gestion.groupe.dto.AlbumDTO;

public interface AlbumService {
	
	List<AlbumDTO> recupererTousLesAlbums();
	
	List<AlbumDTO> recupererTousLesAlbumsDunGroupe(long idGroupe);
	
	
	AlbumDTO recupererUnAlbumViaSonId(long idAlbum);
	
}
