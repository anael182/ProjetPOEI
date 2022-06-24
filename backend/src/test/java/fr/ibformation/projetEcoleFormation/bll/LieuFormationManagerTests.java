package fr.ibformation.projetEcoleFormation.bll;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import fr.ibformation.projetEcoleFormation.bo.CentreFormation;
import fr.ibformation.projetEcoleFormation.bo.SalleFormation;

@SpringBootTest
class LieuFormationManagerTests {

	@Autowired
    LieuFormationManager lieuManager;

	//============= test sur les salles de formation ==========================
	@Test
	@Transactional
	void addSalle() throws FormationException {
		SalleFormation salleRouge = new SalleFormation("Salle Rouge", 1);
		lieuManager.addSalleFormation(salleRouge);
		assertNotNull(salleRouge.getIdSalleFormation());
		
	}
	
	@Test
	@Transactional
	void getSalleById() throws FormationException {
		SalleFormation salle = new SalleFormation("Salle bleu", 5);
		lieuManager.addSalleFormation(salle);
		SalleFormation salleBis = lieuManager.getSalleById(salle.getIdSalleFormation());
		assertEquals(salleBis.getIdSalleFormation(), salle.getIdSalleFormation());
		
	}
	

	@Test
	@Transactional
	void updateSalle() throws FormationException {
		SalleFormation salleAteilier = new SalleFormation("Salle de travaux", 4);
		lieuManager.addSalleFormation(salleAteilier);
		salleAteilier.setEtage(6);
		lieuManager.updateSalleFormation(salleAteilier);
		assertEquals(salleAteilier.getEtage(), 6);
		
	}
	
	@Test
	@Transactional
	void deleteSalle() throws LieuException, FormationException {
		SalleFormation salleAteilier = new SalleFormation("Salle de travaux", 4);
		lieuManager.addSalleFormation(salleAteilier);
		try {
			lieuManager.deleteSalle(salleAteilier);
		} catch (LieuException e) {
			
			System.out.println(e.getMessage());
		}
		assertNull(lieuManager.getSalleById(salleAteilier.getIdSalleFormation()));
	}
	
	//====================== test sur le centre de formation ==================
	@Test
	@Transactional
	void addCentreFormation() throws FormationException {
		CentreFormation centre2 = new CentreFormation("ibCegos","rue de la liberte" , "75010","Paris");
		lieuManager.addCentreFormation(centre2);
		assertNotNull(centre2.getIdCentreFormation());
		
	}
	
	@Test
	@Transactional
	void updateCentreFormation() throws FormationException {
		CentreFormation centreA = new CentreFormation("ibCegos","rue de la liberte" , "75010","Paris");
		lieuManager.addCentreFormation(centreA);
		centreA.setCodePostal("75020");
		lieuManager.updateCentreFormation(centreA);
		assertEquals(centreA.getCodePostal(), "75020");
		
	}
	
	@Test
	@Transactional
	void deleteCentreFormation() throws LieuException, FormationException  {
		CentreFormation centreB = new CentreFormation("ibCegos","rue de la liberte" , "75014","Paris");
		lieuManager.addCentreFormation(centreB);
		
		lieuManager.deleteCentreFormationById(centreB.getIdCentreFormation());
			
		System.err.println(centreB.getIdCentreFormation());
		//assertNull(lieuManager.getCentreFormationById(centreB.getIdCentreFormation()));
	}
	
	
	

}
