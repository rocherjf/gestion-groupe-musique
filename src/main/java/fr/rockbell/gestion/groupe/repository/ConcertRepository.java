package fr.rockbell.gestion.groupe.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.rockbell.gestion.groupe.entity.Concert;

public interface ConcertRepository extends JpaRepository<Concert, Long> {
	
	List<Concert> findByIdGroupe(long idGroupe);

}
