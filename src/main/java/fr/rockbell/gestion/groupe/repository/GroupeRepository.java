package fr.rockbell.gestion.groupe.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.rockbell.gestion.groupe.entity.Groupe;

public interface GroupeRepository extends JpaRepository<Groupe, Long> {

}
