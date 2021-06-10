package fr.rockbell.gestion.groupe.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.rockbell.gestion.groupe.entity.Album;

public interface AlbumRepository extends JpaRepository<Album, Long> {
	
	List<Album> findByIdGroupe(long idGroupe);

}
