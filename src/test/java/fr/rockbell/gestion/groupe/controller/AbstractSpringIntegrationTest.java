package fr.rockbell.gestion.groupe.controller;

import java.time.Duration;

import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.hateoas.config.HypermediaWebTestClientConfigurer;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.jdbc.JdbcTestUtils;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringJUnitConfig // @ExtendWith(SpringExtension.class) + @ContextConfiguration
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
abstract class AbstractSpringIntegrationTest {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired 
	HypermediaWebTestClientConfigurer configurer;

	@LocalServerPort
	int randomServerPort;

	protected WebTestClient webClient;

	@BeforeEach
	void setUp() {
		
	  
		  // Create a WebTestClient by binding to the controller and applying the hypermedia configurer.
		  //WebTestClient client = WebTestClient.bindToApplicationContext(context).build().mutateWith(configurer);

		webClient = WebTestClient
				.bindToServer()
				.responseTimeout(Duration.ofSeconds(100)) // Utile lorsqu'on prend les tests en debugs, à commenter sinon
				.baseUrl("http://localhost:" + randomServerPort)
				.build()
				.mutateWith(configurer);
	}

	@BeforeEach
	void resetState() {
		cleanAllDatabases();
	}

	void cleanAllDatabases() {
		JdbcTestUtils.deleteFromTables(jdbcTemplate, "ALBUM ", "GROUPE", "CONCERT");
		jdbcTemplate.update("ALTER TABLE ALBUM ALTER COLUMN id RESTART WITH 1");
		jdbcTemplate.update("ALTER TABLE GROUPE ALTER COLUMN id RESTART WITH 1");
		jdbcTemplate.update("ALTER TABLE CONCERT ALTER COLUMN id RESTART WITH 1");
	}

}
