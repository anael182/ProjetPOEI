package fr.ibformation.projetEcoleFormation.bll;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import fr.ibformation.projetEcoleFormation.bo.Formation;
import fr.ibformation.projetEcoleFormation.bo.SessionFormation;
import fr.ibformation.projetEcoleFormation.bo.SousThemeFormation;

@SpringBootTest
public class FormationManagerTests {
	@Autowired
	private FormationManager formationManager;
	

	@Test
	@Transactional
	void addFormationTest() throws FormationException {
		Formation formation = new Formation("InformatiqueManag", "Apprendre le developpement JAVA test", "description", 1040, "Langages de développement");
		formationManager.addFormation(formation);
		assertNotNull(formation.getIdFormation());
	}
	
	@Test
	@Transactional
	void modifyFormationTest() {
		Formation formation = new Formation("InformatiqueManag", "Apprendre le developpement JAVA", "description", 1040, "Langages de développement");
		formation.setNomDomaine("Info");
		formationManager.modifyFormation(formation);
		assertNotNull(formation.getNomDomaine());
	}

	
	@Test
	@Transactional
	void deleteFormationTest() throws FormationException {
		Formation formation = new Formation("InformatiqueManag", "Apprendre le developpement JAVA test", "description", 1040, "Langages de développement");
		formationManager.addFormation(formation);
		Integer idFormation = formation.getIdFormation();
		formationManager.deleteFormationById(idFormation);
		assertNull(formationManager.getFormationById(formation.getIdFormation()));
	}
	
	
	@Test
	@Transactional
	void getListeFormationTest() throws FormationException {
		Formation formation = new Formation("Informatique", "Apprendre le developpement JAVA test", "description", 1040, "Langages de développement");
		Formation formation2 = new Formation("Informatique", "Apprendre le developpement PYTHON test", "description", 1040, "Langages de développement");
		formationManager.addFormation(formation);
		formationManager.addFormation(formation2);
		assertNotEquals(formationManager.getListeFormations().size(), 0);
	}
	
	
	@Test
	@Transactional
	void getFormationByIdTest() throws FormationException {
		Formation formation = new Formation("Informatique", "Apprendre le developpement JAVA TEST", "description", 1040, "Langages de développement");
		formationManager.addFormation(formation);
		
		Formation formationFromBdd = formationManager.getFormationById(formation.getIdFormation());
		assertNotNull(formation.getIdFormation());
		assertEquals(formation.getNomFormation(), formationFromBdd.getNomFormation());
	}
	
	
	@Test
	@Transactional
	void addSessionFormationTest() {
		SessionFormation sessionFormation = new SessionFormation(LocalDate.of(2022,05,10), LocalDate.of(2022,05,15), "inter-entreprise", true, true, true, false, false, false, false, false);
		formationManager.addSessionFormation(sessionFormation);
		assertNotNull(sessionFormation.getIdSession());
	}
	
	@Test
	@Transactional
	void modifySessionFormationTest() {
		SessionFormation sessionFormation = new SessionFormation(LocalDate.of(2022,05,10), LocalDate.of(2022,05,15), "inter-entreprise", true, true, true, false, false, false, false, false);
		sessionFormation.setDateFin(LocalDate.of(2022, 10, 20));
		formationManager.modifySessionFormation(sessionFormation);
		assertNotNull(sessionFormation.getDateFin());
	}

	
	@Test
	@Transactional
	void deleteSessionFormationTest() throws FormationException {
		SessionFormation sessionFormation  = new SessionFormation(LocalDate.of(2022,05,10), LocalDate.of(2022,05,15), "inter-entreprise", true, true, true, false, false, false, false, false);
		formationManager.addSessionFormation(sessionFormation);
		Integer idSessionFormation = sessionFormation.getIdSession();
		formationManager.deleteSessionFormationById(idSessionFormation);
		assertNull(formationManager.getFormationById(sessionFormation.getIdSession()));
	}
	
	
	@Test
	@Transactional
	void getListeSessionFormationTest() {
		SessionFormation sessionFormation = new SessionFormation(LocalDate.of(2022,05,10), LocalDate.of(2022,05,15), "inter-entreprise", true, true, true, false, false, false, false, false);
		SessionFormation sessionFormation2 = new SessionFormation(LocalDate.of(2022,06,10), LocalDate.of(2022,06,15), "intra-entreprise", true, true, true, false, false, false, false, false);
		formationManager.addSessionFormation(sessionFormation);
		formationManager.addSessionFormation(sessionFormation2);
		assertNotEquals(formationManager.getListeSessionsFormation().size(), 0);
	}
	
	@Test
	@Transactional
	void getSessionFormationByIdTest() {
		SessionFormation sessionFormation = new SessionFormation(LocalDate.of(2022,05,10), LocalDate.of(2022,05,15), "inter-entreprise", true, true, true, false, false, false, false, false);
		formationManager.addSessionFormation(sessionFormation);
		
		SessionFormation sessionFormationFromBdd = formationManager.getSessionFormationById(sessionFormation.getIdSession());
		assertEquals(sessionFormation.getDateFin(), sessionFormationFromBdd.getDateFin());
	}
	
	@Test
	@Transactional
	void addSousThemeFormationTest() throws FormationException {
		SousThemeFormation sousThemeFormation = new SousThemeFormation("JAVA-TEST");
		formationManager.addSousThemeFormation(sousThemeFormation);
		assertNotNull(sousThemeFormation.getIdSousTheme());
	}
	
	
	
	@Test
	@Transactional
	void addSousThemeToFormation() {
		Formation formation = new Formation("Informatique", "Apprendre le developpement JAVA", "description", 1040, "Langages de développement");
		SousThemeFormation sousThemeFormation = new SousThemeFormation("JAVA-TEST");
		formationManager.addSousThemeToFormation(formation, sousThemeFormation);
		assertTrue(formation.getListeSousThemeFormation().size() >0);
	}
	
	
	@Test
	@Transactional
	void modifySousThemeFormationTest() {
		SousThemeFormation sousThemeFormation = new SousThemeFormation("JAVA");
		sousThemeFormation.setNomSousTheme("Javascript");
		formationManager.modifySousThemeFormation(sousThemeFormation);
		assertNotNull(sousThemeFormation.getNomSousTheme());
	}
	
	
	@Test
	@Transactional
	void deleteSousThemeFormationTest() throws FormationException {
		SousThemeFormation sousThemeFormation = new SousThemeFormation("JAVA-TEST");
		formationManager.addSousThemeFormation(sousThemeFormation);
		Integer idSousThemeFormation = sousThemeFormation.getIdSousTheme();
		formationManager.deleteSousThemeFormationById(idSousThemeFormation);
		assertNull(formationManager.getFormationById(sousThemeFormation.getIdSousTheme()));
	}
	
	
	@Test
	@Transactional
	void getListeSousThemeFormationTest() throws FormationException {
		SousThemeFormation sousThemeFormation = new SousThemeFormation("JAVA-TEST");
		SousThemeFormation sousThemeFormation2 = new SousThemeFormation("HTML TEST");
		formationManager.addSousThemeFormation(sousThemeFormation);
		formationManager.addSousThemeFormation(sousThemeFormation2);
		assertNotEquals(formationManager.getListeSousThemesFormation().size(),0);
	}
	
	
}
