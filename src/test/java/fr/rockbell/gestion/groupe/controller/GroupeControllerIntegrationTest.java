package fr.rockbell.gestion.groupe.controller;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.core.TypeReferences;
import org.springframework.test.web.reactive.server.EntityExchangeResult;
import org.springframework.web.reactive.function.BodyInserters;

import fr.rockbell.gestion.groupe.external.input.GroupeInput;
import fr.rockbell.gestion.groupe.external.output.GroupeOutput;

class GroupeControllerIntegrationTest extends AbstractSpringIntegrationTest {

	private GroupeInput violetCold = new GroupeInput("Violet Cold", "Azerbaïdjan", "Also Known As Emin Guliyev");
	private GroupeInput riseOfTheNorthStar = new GroupeInput("Rise Of The NortStar", "France",
			"Formed in 2008, Paris, Île-de-France, France");
	private GroupeInput theGreatOldOnes = new GroupeInput("The Great Old Ones", "France",
			"Formed in 2009, Bordeaux, Nouvelle-Aquitaine, France");

	@Test
	void scenarioCreationGroupesSimples() {

		List<GroupeOutput> groupesCrees = new ArrayList<>();
		// Etape 0 : Aucun groupe ne doit être présent en BDD (vérif supp DB)
		testRecuperationDeTousLesGroupes_doitContenirLaListeFournie(groupesCrees);

		// Etape 1 : Création d'un groupe et vérification qu'il contient bien
		// les données fournies
		GroupeOutput premierGroupeCree = testCreationGroupe_doitCreerUnGroupe(violetCold);
		groupesCrees.add(premierGroupeCree);

		// Etape 2 : Récupération de ce groupe via son id et vérification qu'il
		// correspond bien au groupe obtenu précédement
		testRecuperationGroupeViaSonId_doitCorrespondreAuGroupeFourni(premierGroupeCree);

		// Etape 3 : Récupération de tous les groupes (il ne devrait y en avoir
		// qu'un)
		testRecuperationDeTousLesGroupes_doitContenirLaListeFournie(groupesCrees);

		// Etape 4 : Création d'un groupe et vérification qu'il contient bien
		// les données fournies
		GroupeOutput deuxiemeGroupeCree = testCreationGroupe_doitCreerUnGroupe(riseOfTheNorthStar);
		groupesCrees.add(deuxiemeGroupeCree);

		// Etape 5 : Récupération de ce groupe via son id et vérification qu'il
		// correspond bien au groupe obtenu précédement
		testRecuperationGroupeViaSonId_doitCorrespondreAuGroupeFourni(deuxiemeGroupeCree);

		// Etape 6 : vérifier la présence des groupes crées
		testRecuperationDeTousLesGroupes_doitContenirLaListeFournie(groupesCrees);

		// Etape 7 : Création d'un groupe et vérification qu'il contient bien
		// les données fournies
		GroupeOutput troisiemeGroupeCree = testCreationGroupe_doitCreerUnGroupe(theGreatOldOnes);
		groupesCrees.add(troisiemeGroupeCree);

		// Etape 8 : Récupération de ce groupe via son id et vérification qu'il
		// correspond bien au groupe obtenu précédement
		testRecuperationGroupeViaSonId_doitCorrespondreAuGroupeFourni(troisiemeGroupeCree);

		// Etape 9 : vérifier la présence des groupes crées
		testRecuperationDeTousLesGroupes_doitContenirLaListeFournie(groupesCrees);

	}

	private void testRecuperationDeTousLesGroupes_doitContenirLaListeFournie(List<GroupeOutput> groupesCrees) {

		webClient
		.get()
		.uri("/groupes")
		.exchange()
		.expectStatus().isOk()
		.expectBody(new TypeReferences.CollectionModelType<GroupeOutput>(){})
		.consumeWith(result -> {
			CollectionModel<GroupeOutput> collectionGroupes = result.getResponseBody();
			assertThat(collectionGroupes.getContent()).hasSize(groupesCrees.size());
			assertThat(collectionGroupes.getContent().containsAll(groupesCrees));
		});
		
		
	}

	private void testRecuperationGroupeViaSonId_doitCorrespondreAuGroupeFourni(GroupeOutput groupeCree) {

		webClient
				.get()
				.uri("/groupes/" + groupeCree.getId())
				.exchange()
				.expectStatus().isOk()
				.expectBody(GroupeOutput.class)
				.consumeWith(result -> {
					GroupeOutput groupeCreePrecedement = result.getResponseBody();
					assertThat(groupeCreePrecedement).isEqualTo(groupeCree);
				});

	}

	private GroupeOutput testCreationGroupe_doitCreerUnGroupe(GroupeInput groupeACreer) {

		EntityExchangeResult<GroupeOutput> result = webClient.post()
				.uri("/groupes")
				.body(BodyInserters.fromValue(groupeACreer))
				.exchange()
				.expectStatus().isOk()
				.expectBody(GroupeOutput.class)
				.returnResult();

		GroupeOutput groupeCree = result.getResponseBody();

		assertThat(groupeCree.getNom()).isEqualTo(groupeACreer.getNom());
		assertThat(groupeCree.getPays()).isEqualTo(groupeACreer.getPays());
		assertThat(groupeCree.getBiographie()).isEqualTo(groupeACreer.getBiographie());
		
		return groupeCree;
	}

}
