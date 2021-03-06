package fr.rockbell.gestion.groupe.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import fr.rockbell.gestion.groupe.dto.AlbumDTO;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Album {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String nom;

	private String genre;

	private String annee;

	private String description;
	private String urlImage;
	
	private long idGroupe;

	
	protected static Album buildFromAlbumDTO(AlbumDTO albumDTO) {
		
		if(albumDTO == null) {
			throw new IllegalStateException(
					"L'album ne peut pas être null");
		}
		
		if (albumDTO.getNom().isEmpty()) {
			throw new IllegalStateException(
					"Le nom de l'album ne peut pas être vide");
		}
		
		var album = new Album();
		album.nom = albumDTO.getNom();
		album.genre = albumDTO.getGenre();
		album.annee = albumDTO.getAnnee();
		album.description = albumDTO.getDescription();
		album.urlImage = albumDTO.getUrlImage();

		return album;

	}

}
