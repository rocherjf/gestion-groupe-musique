package fr.rockbell.gestion.groupe.external.output;

import java.time.Instant;

import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Relation(collectionRelation = "concerts")
public class ConcertOutput extends RepresentationModel<GroupeOutput> {

	private String ville;

	private String nomDeLaSalle;

	private Instant date;

	private String refExterne;

}
