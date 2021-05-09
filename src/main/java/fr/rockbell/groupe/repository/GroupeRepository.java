package fr.rockbell.groupe.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.rockbell.groupe.entity.Groupe;

public interface GroupeRepository extends JpaRepository<Groupe, Long> {

}
