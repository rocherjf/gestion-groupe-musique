package fr.rockbell.groupe.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import fr.rockbell.groupe.dto.AlbumDTO;
import fr.rockbell.groupe.dto.ConcertDTO;
import fr.rockbell.groupe.dto.GroupeDTO;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Groupe {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String nom;

	private String pays;

	private String biographie;

	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="idArtiste", referencedColumnName="id")
	private List<Album> albums;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="idArtiste", referencedColumnName="id")
	private List<Concert> concerts;
	
	
	public static Groupe buildfromDTO(GroupeDTO groupeACreer) {
		
		if(groupeACreer.getNom().isEmpty()) {
			throw new IllegalStateException("Le nom du groupe ne peut pas être vide");
		}
		Groupe groupe = new Groupe();
		groupe.nom = groupeACreer.getNom();
		groupe.pays = groupeACreer.getPays();
		groupe.biographie = groupeACreer.getBiographie();
		
		return groupe;
		
	}
	
	public Groupe ajouterAlbum(AlbumDTO albumAAjouter) {
		
		this.albums.add(Album.buildFromAlbumDTO(albumAAjouter));
		
		return this;
		
	}
	
	public Groupe ajouterConcert(ConcertDTO concertAAjouter) {
		
		this.concerts.add(Concert.buildFromConcertDTO(concertAAjouter));
		
		return this;
		
	}

}
