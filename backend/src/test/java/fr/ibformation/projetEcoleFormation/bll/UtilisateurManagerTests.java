package fr.ibformation.projetEcoleFormation.bll;

import fr.ibformation.projetEcoleFormation.bo.EvaluationFormateur;
import fr.ibformation.projetEcoleFormation.bo.EvaluationSession;
import fr.ibformation.projetEcoleFormation.bo.Formateur;
import fr.ibformation.projetEcoleFormation.bo.Stagiaire;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UtilisateurManagerTests {

    // ------------------------- Tests CRUD Stagiaire -------------------------
    @Autowired
    private UtilisateurManager manager;

    @Test
    @Transactional
    void addStagiaire() throws FormationException {
        Stagiaire s1 = new Stagiaire("test","letest","test@gmail.com","mdp2","Stagiaire","4 rue du test","31000","Toulouse");
        manager.addStagiaire(s1);
        assertNotNull(s1.getIdUtilisateur());
    }

    @Test
    @Transactional
    void deleteStagiaire() throws UtilisateurManagerException, FormationException {
        Stagiaire s1 = new Stagiaire("test","letest","test@gmail.com","mdp2","Stagiaire","4 rue du test","31000","Toulouse");
        manager.addStagiaire(s1);
        manager.deleteStagiaire(s1);
        assertNotEquals(null, s1);
    }

    @Test
    @Transactional
    void modifyStagiaire() throws FormationException {
        Stagiaire s1 = new Stagiaire("test","letest","test@gmail.com","mdp2","Stagiaire","4 rue du test","31000","Toulouse");
        manager.addStagiaire(s1);
        s1.setCodePostal("11000");
        manager.addStagiaire(s1);
        assertEquals(s1.getCodePostal(), "11000");
    }

    @Test
    void getAllStagiaire() throws FormationException {
        Stagiaire s1 = new Stagiaire("Larue","Benoit","fdsfds@gmail.com","mdp","Stagiaire","6 rue du coq","31000","Toulouse");
        Stagiaire s2 = new Stagiaire("Mouse","Mickey","ezezez@gmail.com","mdp1","Stagiaire","5 rue du coq","31000","Toulouse");
        Stagiaire s3 = new Stagiaire("Larue","Michelle","aaa@gmail.com","mdp2","Stagiaire","4 rue du coq","31000","Toulouse");
        manager.addStagiaire(s1);
        manager.addStagiaire(s2);
        manager.addStagiaire(s3);
        assertNotNull(manager.getAllStagiaire());
    }

    @Test
    @Transactional
    void deleteStagiaireById() throws UtilisateurManagerException, FormationException {
        Stagiaire s1 = new Stagiaire("Larue","Benoit","fdsfds@gmail.com","mdp","Stagiaire","6 rue du coq","31000","Toulouse");
        Stagiaire s2 = new Stagiaire("Mouse","Mickey","ezezez@gmail.com","mdp1","Stagiaire","5 rue du coq","31000","Toulouse");
        Stagiaire s3 = new Stagiaire("Larue","Michelle","aaa@gmail.com","mdp2","Stagiaire","4 rue du coq","31000","Toulouse");
        manager.addStagiaire(s1);
        manager.addStagiaire(s2);
        manager.addStagiaire(s3);
        manager.deleteStagiaireById(s2.getIdUtilisateur());
        assertNull(manager.getStagiaireById(s2.getIdUtilisateur()));
    }

    // ------------------------- Tests CRUD Formateur ------------------------------------

    @Test
    @Transactional
    void addFormateur() throws FormationException {
        Formateur f1 = new Formateur("test","letest","test@gmail.com","mdp2","Formateur","4 rue du test","31000","Toulouse");
        manager.addFormateur(f1);
        assertNotNull(f1.getPrenom());
    }

    @Test
    @Transactional
    void deleteFormateur() throws UtilisateurManagerException, FormationException {
        Formateur f1 = new Formateur("test","letest","test@gmail.com","mdp2","Stagiaire","4 rue du test","31000","Toulouse");
        manager.addFormateur(f1);
        manager.deleteFormateur(f1);
        assertNotEquals(null, f1);
    }

    @Test
    @Transactional
    void modifyFormateur() throws FormationException {
        Formateur f1 = new Formateur("test","letest","test@gmail.com","mdp2","Stagiaire","4 rue du test","31000","Toulouse");
        manager.addFormateur(f1);
        f1.setCodePostal("11000");
        manager.addFormateur(f1);
        assertEquals(f1.getCodePostal(), "11000");
    }

    @Test
    void getAllFormateur() throws FormationException {
        Formateur f1 = new Formateur("Larue","Benoit","fdsfds@gmail.com","mdp","Stagiaire","6 rue du coq","31000","Toulouse");
        Formateur f2 = new Formateur("Mouse","Mickey","ezezez@gmail.com","mdp1","Stagiaire","5 rue du coq","31000","Toulouse");
        Formateur f3 = new Formateur("Larue","Michelle","aaa@gmail.com","mdp2","Stagiaire","4 rue du coq","31000","Toulouse");
        manager.addFormateur(f1);
        manager.addFormateur(f2);
        manager.addFormateur(f3);
        assertNotEquals(0,manager.getAllFormateur().size());
    }

    @Test
    @Transactional
    void deleteFormateurById() throws UtilisateurManagerException, FormationException {
        Formateur f1 = new Formateur("Larue","Benoit","fdsfds@gmail.com","mdp","Stagiaire","6 rue du coq","31000","Toulouse");
        Formateur f2 = new Formateur("Mouse","Mickey","ezezez@gmail.com","mdp1","Stagiaire","5 rue du coq","31000","Toulouse");
        Formateur f3 = new Formateur("Larue","Michelle","aaa@gmail.com","mdp2","Stagiaire","4 rue du coq","31000","Toulouse");
        manager.addFormateur(f1);
        manager.addFormateur(f2);
        manager.addFormateur(f3);
        manager.deleteFormateur(f2);
        assertNull(manager.getStagiaireById(f2.getIdUtilisateur()));
    }

    // ------------------------- Tests CRUD Evaluation Session ---------------------------
    @Test
    @Transactional
    void addEvaluationSession() {
        EvaluationSession e1 = new EvaluationSession(5,5,5,"satisfait",true,true);
        manager.addEvaluationSession(e1);
        assertEquals(5, e1.getNoteContenuFormation());
    }


    @Test
    @Transactional
    void addEvaluationSessionToStagiaire() {
        Stagiaire s1 = new Stagiaire("Larue","Benoit","fdsfds@gmail.com","mdp","Stagiaire","6 rue du coq","31000","Toulouse");
        EvaluationSession e1 = new EvaluationSession(5,5,5,"satisfait",true,true);
        manager.addEvaluationSessionToStagiaire(s1,e1);
        assertNotNull(s1.getListeEvalSession());

    }

    @Test
    @Transactional
    void deleteEvaluationSession() throws UtilisateurManagerException {
        EvaluationSession e1 = new EvaluationSession(5,4,5,"satisfait",true,true);
        manager.addEvaluationSession(e1);
        manager.deleteEvaluationSession(e1);
        assertNull(manager.getEvaluationSessionById(e1.getIdEvalSession()));
    }



    // ------------------------- Tests CRUD Evaluation Formateur -------------------------
    @Test
    @Transactional
    void addEvaluationFormateur() {
        EvaluationFormateur ef1 = new EvaluationFormateur(5, 4, 3, 4, 4);
        manager.addEvaluationFormateur(ef1);
        assertNotNull(ef1.getIdEvalFormateur());
    }
}
