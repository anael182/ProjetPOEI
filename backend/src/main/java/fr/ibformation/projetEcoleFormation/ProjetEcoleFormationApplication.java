package fr.ibformation.projetEcoleFormation;

import java.time.LocalDate;

import javax.transaction.Transactional;

import fr.ibformation.projetEcoleFormation.bll.UtilisateurManager;
import fr.ibformation.projetEcoleFormation.bo.*;
import fr.ibformation.projetEcoleFormation.ihm.UserSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import fr.ibformation.projetEcoleFormation.bll.LieuFormationManager;

import fr.ibformation.projetEcoleFormation.bll.FormationManager;

import fr.ibformation.projetEcoleFormation.dal.CentreFormationDAO;
import fr.ibformation.projetEcoleFormation.dal.EntrepriseClientDAO;
import fr.ibformation.projetEcoleFormation.dal.EvaluationFormateurDAO;
import fr.ibformation.projetEcoleFormation.dal.EvaluationSessionDAO;
import fr.ibformation.projetEcoleFormation.dal.FormateurDAO;
import fr.ibformation.projetEcoleFormation.dal.FormationDAO;
import fr.ibformation.projetEcoleFormation.dal.SalleFormationDAO;
import fr.ibformation.projetEcoleFormation.dal.SessionFormationDAO;
import fr.ibformation.projetEcoleFormation.dal.SousThemeFormationDAO;
import fr.ibformation.projetEcoleFormation.dal.StagiaireDAO;
import org.springframework.web.context.annotation.ApplicationScope;

@SpringBootApplication
public class ProjetEcoleFormationApplication implements CommandLineRunner {
	@Autowired
	StagiaireDAO stagiaireDAO;
	@Autowired
	FormateurDAO formateurDAO;
	@Autowired
	EntrepriseClientDAO entrepriseClientDAO;
	@Autowired
	EvaluationSessionDAO evaluationSessionDAO;
	@Autowired
	EvaluationFormateurDAO evaluationFormateurDAO;
	@Autowired
	CentreFormationDAO centreFormationDAO;
	@Autowired
	SalleFormationDAO salleFormationDAO;
	@Autowired
	FormationDAO formationDAO;
	@Autowired
	SousThemeFormationDAO sousThemeFormationDAO;
	@Autowired
	SessionFormationDAO sessionFormationDAO;

	
//================== BLL Manager ================
	
	@Autowired
	LieuFormationManager lieuManager;
	

	@Autowired
	UtilisateurManager utilisateurManager;


	@Autowired
	private FormationManager formationManager;

//================== Session Manager ================


	public static void main(String[] args) {
		SpringApplication.run(ProjetEcoleFormationApplication.class, args);
		
	}

	@Bean
	@ApplicationScope
	// Pas en SessionScope par manque de temps pour le mettre en place
	public UserSession connectedUser() {
		return new UserSession();
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@Override
	@Transactional
	public void run(String... args) throws Exception {

		// Création Admin
		Stagiaire admin = new Stagiaire("admin","admin","admin@admin.fr","admin","admin","5 rue des admin","00000","AdminVille");
		utilisateurManager.addStagiaire(admin);
		
		//===================== Celine ==============================
		
		EntrepriseClient entrepriseManag = new EntrepriseClient("DANONE","6 rue de la bergerie","66000","Perpignan");
		entrepriseClientDAO.save(entrepriseManag);
		Stagiaire stagiaireManag = new Stagiaire("DUPONT","Jean","dupont.jean@gmail.com","fdsfdsf","Stagiaire","5 rue fdsfsd","31000","Toulouse");
		Stagiaire stagiaire3 = new Stagiaire("NAIM","Yael","naim.yael@gmail.com","fdsfdsf","Stagiaire","5 rue fdsfsd","31000","Toulouse");
		Formateur formateurManag = new Formateur("HENRI","Pierre","henri.pierre@gmail.com","fdsfdsf","Formateur","5 rue fdsfsd","31000","Toulouse");
		Formateur formateur3 = new Formateur("CHICOT","Alix","chicot.alix@gmail.com","fdsfdsf","Formateur","5 rue fdsfsd","31000","Toulouse");
		SalleFormation salle = new SalleFormation("Seine", 3);
		SalleFormation salle3 = new SalleFormation("Loire", 2);
		CentreFormation centre3 = new CentreFormation("IT Training Lyon","25 avenue du Soleil" , "69000","Lyon");
		lieuManager.addCentreFormation(centre3);
		lieuManager.addSalleFormation(salle);
		lieuManager.addSalleFormation(salle3);
		centre3.addSalleFormation(salle3);
		centre3.addSalleFormation(salle);
		
		utilisateurManager.addStagiaire(stagiaireManag);
		utilisateurManager.addStagiaire(stagiaire3);
	    utilisateurManager.addFormateur(formateurManag);
	    utilisateurManager.addFormateur(formateur3);
		
		
		Formation formation3 = new Formation ("Informatique", "Apprendre le developpement JAVASCRIPT", "Les bases de la programmation Javascript", 1040, "Langages de développement");
		formationManager.addFormation(formation3);
		
		// CRUD Session Formation ///
		
		/// ==== Create =====
		SessionFormation sessionManag = new SessionFormation(LocalDate.of(2022,05,01), LocalDate.of(2022,05,9), "intra-entreprise", true, true, true, false, false, false, false, false);
		sessionManag.setEntreprise(entrepriseManag);
		sessionManag.addStagiaire(stagiaireManag);
		sessionManag.setFormateur(formateurManag);
		salle.addSessionFormation(sessionManag);
		sessionManag.setSalleFormation(salle);
		sessionManag.setFormation(formation3);
	    sessionManag.setDateAnnulation(LocalDate.of(2022,05,9));

		formationManager.addSessionFormation(sessionManag);
		
		SessionFormation sessionManag2 = new SessionFormation(LocalDate.of(2022,03,10), LocalDate.of(2022,05,15), "inter-entreprise", true, true, true, false, false, false, false, false);
		sessionManag2.setEntreprise(entrepriseManag);
		sessionManag2.addStagiaire(stagiaire3);
		sessionManag2.setFormateur(formateur3);
		salle3.addSessionFormation(sessionManag2);
		sessionManag2.setSalleFormation(salle3);
		sessionManag2.setFormation(formation3);
		formationManager.addSessionFormation(sessionManag2);
		
		
		EvaluationSession evalS = new EvaluationSession(2,2,3,"satisfait",true, true);
		EvaluationFormateur evalF = new EvaluationFormateur(2,3,4,5,3);
		utilisateurManager.addEvaluationFormateur(evalF);
		utilisateurManager.addEvaluationSession(evalS);
		evalF.setStagiaire(stagiaireManag);
		evalF.setSessionFormation(sessionManag);
		sessionManag.addEvalFormateur(evalF);
		sessionManag.addEvalSession(evalS);
		evalF.setFormateur(formateurManag);
		evalS.setSessionFormation(sessionManag);
		evalS.setStagiaire(stagiaireManag);
		formationManager.modifySessionFormation(sessionManag);
		
		Integer idSession = sessionManag.getIdSession();
		
		
		EvaluationSession evalS2 = new EvaluationSession(5,5,5,"très satisfait",true, true);
		EvaluationFormateur evalF2 = new EvaluationFormateur(5,5,4,5,5);
		utilisateurManager.addEvaluationFormateur(evalF2);
		utilisateurManager.addEvaluationSession(evalS2);
		evalF2.setStagiaire(stagiaire3);
		evalF2.setSessionFormation(sessionManag2);
		sessionManag2.addEvalFormateur(evalF2);
		sessionManag2.addEvalSession(evalS2);
		evalF2.setFormateur(formateur3);
		evalS2.setSessionFormation(sessionManag2);
		evalS2.setStagiaire(stagiaire3);
		formationManager.modifySessionFormation(sessionManag2);
		
		/// ==== Modify =====
		sessionManag2.setDateFin(LocalDate.of(2022, 10, 20));
		formationManager.modifySessionFormation(sessionManag2);
		
		
		/// ==== Liste =====
		formationManager.getListeSessionsFormation().forEach(System.out::println);
		
		formationManager.getSessionFormationById(idSession);
		
		/// ==== Delete =====
	
       //formationManager.deleteSessionFormationById(idSession);
		
		
		
		
		// CRUD Sous-Theme Formation ///
		SousThemeFormation sousTheme1Manag = new SousThemeFormation("JAVA");
		SousThemeFormation sousTheme2Manag = new SousThemeFormation("HTML");
		SousThemeFormation sousTheme3Manag = new SousThemeFormation("CSS");
		
		/// ==== Create =====
		formationManager.addSousThemeFormation(sousTheme1Manag, sousTheme2Manag, sousTheme3Manag);
		
		/// ==== Modify =====
		sousTheme2Manag.setNomSousTheme("Javascript");
		formationManager.modifySousThemeFormation(sousTheme2Manag);
		
		
		/// ==== Liste =====
		formationManager.getListeSousThemesFormation().forEach(System.out::println);
		
		
		
		/// ==== Delete =====
//		Integer idSousTheme = sousTheme1Manag.getIdSousTheme();
//		formationManager.deleteSousThemeFormationById(idSousTheme);
//		
		
		
		// CRUD Formation ///
		

		Formation formation1 = new Formation ("Informatique", "Apprendre le developpement JAVA", "Les bases de la programmation Java EE", 1040, "Langages de développement");
		Formation formation2 = new Formation ("Informatique", "Apprendre le developpement PYTHON", "Les bases de la programmation Python", 1040, "Langages de développement");
		Formation formation4 = new Formation ("Informatique", "Apprendre le developpement C++", "Les bases de la programmation C++", 1199, "Langages de développement");
		Formation formation5 = new Formation ("Informatique", "Apprendre le developpement GO", "Les bases de la programmation GO", 1249, "Langages de développement");
		Formation formation6 = new Formation ("Informatique", "Apprendre le developpement RUST", "Les bases de la programmation Rust", 1259, "Langages de développement");
		Formation formation7 = new Formation ("Informatique", "Apprendre le developpement C", "Les bases de la programmation C", 1239, "Langages de développement");
		Formation formation8 = new Formation ("Informatique", "Apprendre le developpement C#", "Les bases de la programmation C#", 999, "Langages de développement");


		/// ==== Create =====
		formationManager.addFormation(formation1);
		formationManager.addFormation(formation2);
		formationManager.addFormation(formation4);
		formationManager.addFormation(formation5);
		formationManager.addFormation(formation6);
		formationManager.addFormation(formation7);
		formationManager.addFormation(formation8);




		formationManager.addSousThemeToFormation(formation1, sousTheme1Manag, sousTheme2Manag, sousTheme3Manag);
		
		/// ==== Modify =====
		formation1.setNomFormation("Parcourir le JAVA");
		formationManager.modifyFormation(formation1);
		
		/// ==== Liste =====
		formationManager.getListeFormations().forEach(System.out::println);
		
		Integer idFormation = formation1.getIdFormation();
		formationManager.getFormationById(idFormation);
		
		/// ==== Delete =====
		
//		Integer idFormation2 = formation2.getIdFormation();
//		formationManager.deleteFormationById(idFormation2);
		
		formation1.addSessionFormation(sessionManag2);
		formationManager.modifySessionFormation(sessionManag2);
		
		
		
		//===================== Anael ==================================

		Stagiaire s1 = new Stagiaire("LARUE","Benoit","larue.benoit@gmail.com","mdpmdp","Stagiaire","6 rue du coq","31000","Toulouse");
		EvaluationSession e1 = new EvaluationSession(5,5,5,"satisfait",true,true);
		e1.setSessionFormation(sessionManag2);
		utilisateurManager.addEvaluationSession(e1);
		utilisateurManager.addEvaluationSessionToStagiaire(s1,e1);
		System.out.println("--------------------------------------");
		System.out.println("--------------------------------------");

		//===================== Karim ======================================
		
		/**
		 * CRUD Salle de formation
		 */
		
		SalleFormation salle1 = new SalleFormation("Rhone", 3);
		SalleFormation salle2 = new SalleFormation("Garonne", 1);
		//=== Create =========
		lieuManager.addSalleFormation(salle1);
		lieuManager.addSalleFormation(salle2);
		//======== Update =====
		salle1.setEtage(4);
		lieuManager.updateSalleFormation(salle1);
		//======= Read all ======
		lieuManager.getAllSalle().forEach(System.out::println);
		//====== Read by ID =========
		Integer id = salle1.getIdSalleFormation();
		System.out.println("salle par id "+lieuManager.getSalleById(id));
		// === Delete =========
//		lieuManager.deleteSalle(salleVerte);
		
		//lieuManager.deleteSalle(salleVerte); //test de delete un élément qui n'existe pas 
		
		/**
		 * CRUD Centre de formation 
		 */
		
		CentreFormation centre1 = new CentreFormation("IT Training Nanterre","5 rue de la defense" , "92742","Nanterre");
		CentreFormation centre2 = new CentreFormation("IT Training Paris","10 rue de la liberte" , "75010","Paris");
		//=== Create =========
		lieuManager.addCentreFormation(centre2);
		centre2.addSalleFormation(salle1);
		lieuManager.addCentreFormation(centre1);
		
		
		//======== Update ==================
		centre2.setCodePostal("75018");
		lieuManager.updateCentreFormation(centre2);
		// =========== get all =============
		lieuManager.getAllCentreFormation().forEach(System.out::println);
		// ========== get by ID ============
		Integer id1 = centre1.getIdCentreFormation();
		System.out.println("Centre de formation par ID "+lieuManager.getCentreFormationById(id1)); 
		//========= delete by ID ===========
//		lieuManager.deleteCentreFormationById(id1);
		//lieuManager.deleteCentreFormationById(id1); //test element n'existe pas
		
		/**
		 * CRUD Entreprise
		 */
		
		EntrepriseClient entrepriseOne = new EntrepriseClient("SOGETI", "Boulevard des entreprises", "92130", "issy les moulineaux");
		EntrepriseClient entrepriseTwo = new EntrepriseClient("MICROSOFT", "Boulevard des entreprises", "90001", "californie");
		//======== Create ======================
		lieuManager.addEntreprise(entrepriseOne);
		lieuManager.addEntreprise(entrepriseTwo);
		//======== Update ======================
		entrepriseOne.setNomEntreprise("CAPGEMINI");
		lieuManager.updateEntreprise(entrepriseOne);
		//======== get all ======================
		lieuManager.getAllEntreprise().forEach(System.out::println);
		//======== get by id ====================
		Integer idEntreprise = entrepriseOne.getIdEntrepriseClient();
		System.out.println("Entreprise par ID "+lieuManager.getEntrepriseById(idEntreprise));
		//======== delete by ID =================
//		lieuManager.deleteEntrepriseById(idEntreprise);
		
		
		
	
		//===================== test BO DAL (BDD) =================================================
		Stagiaire stagiaire1 = new Stagiaire("DUPONT","Jean","dupont@gmail.com","fdsfdsf","Stagiaire","5 rue de la vie","31000","Toulouse");
		Formateur formateur1 = new Formateur("MARIN","Pierre","marin@gmail.com","fdsfdsf","Formateur","5 rue du bonheur","31000","Toulouse");
		stagiaireDAO.save(stagiaire1);
		formateurDAO.save(formateur1);
		EntrepriseClient entreprise1 = new EntrepriseClient("NESTLE","6 rue de la bergerie","66000","Perpignan");
		entreprise1.addStagiaire(stagiaire1);
		System.out.println(stagiaire1.getEntreprise());
		entrepriseClientDAO.save(entreprise1);
		System.out.println(entreprise1.getListeStagiaires());

		entreprise1.getListeStagiaires().forEach(stagiaire -> stagiaire.setMail("toto@yopmail.fr"));
	
		
		
		EvaluationSession evalSession1 = new EvaluationSession(2,2,3,"satisfait",true, true);
		evalSession1.setStagiaire(stagiaire1);
		evalSession1.setSessionFormation(sessionManag);
	    evaluationSessionDAO.save(evalSession1);

	    
		EvaluationFormateur evalForm1 = new EvaluationFormateur(2,3,4,5,3);
		evalForm1.setFormateur(formateur1);
		evalForm1.setSessionFormation(sessionManag2);
		evaluationFormateurDAO.save(evalForm1);
		
		
	    formateur1.addEvalFormateur(evalForm1);
	    formateurDAO.save(formateur1);
	    
		stagiaire1.addEvalFormateur(evalForm1);
		stagiaire1.addEvalSession(evalSession1);
		stagiaireDAO.save(stagiaire1);
		

		SessionFormation session1 = new SessionFormation(LocalDate.of(2022,01,10), LocalDate.of(2022,05,15), "intra-entreprise", true, true, true, false, false, false, false, false);
		session1.setEntreprise(entreprise1);
		session1.addStagiaire(stagiaire1);
		sessionFormationDAO.save(session1);
		
		formateur1.addSessionFormation(session1);
	    formateurDAO.save(formateur1);
	    
		SalleFormation salleForm1 = new SalleFormation ("Seine", 1);
		salleForm1.addSessionFormation(session1);
		salleFormationDAO.save(salleForm1);
		
		
		CentreFormation centreForm1 = new CentreFormation ("IT Training Paris", "15 rue de Paris", "75000", "PARIS");
		centreForm1.addSalleFormation(salleForm1);
		centreFormationDAO.save(centreForm1);
		
		SousThemeFormation sousTheme1 = new SousThemeFormation("JAVA");
		SousThemeFormation sousTheme2 = new SousThemeFormation("HTML");
		SousThemeFormation sousTheme3 = new SousThemeFormation("CSS");
		
		
		entreprise1.addSessionFormation(session1);
		entrepriseClientDAO.save(entreprise1);
		
		Formation formation1bis = new Formation ("Informatique", "Apprendre le developpement JAVA", "Les bases de la programmation Java EE", 1040, "Langages de développement");
		formation1bis.addSousThemeFormation(sousTheme1);
		formation1bis.addSousThemeFormation(sousTheme2);
		formation1bis.addSousThemeFormation(sousTheme3);
		formation1bis.addSessionFormation(session1);
		formationDAO.save(formation1bis);
		
		
		sousTheme1.addFormation(formation1bis);
		sousThemeFormationDAO.save(sousTheme1);
		sousThemeFormationDAO.save(sousTheme2);
		sousThemeFormationDAO.save(sousTheme3);
		
		System.out.println(formation1bis.getListeSousThemeFormation());

	}
	
}
