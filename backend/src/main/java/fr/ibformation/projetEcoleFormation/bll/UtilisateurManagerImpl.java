package fr.ibformation.projetEcoleFormation.bll;

import fr.ibformation.projetEcoleFormation.bo.*;
import fr.ibformation.projetEcoleFormation.dal.EvaluationFormateurDAO;
import fr.ibformation.projetEcoleFormation.dal.EvaluationSessionDAO;
import fr.ibformation.projetEcoleFormation.dal.FormateurDAO;
import fr.ibformation.projetEcoleFormation.dal.SessionFormationDAO;
import fr.ibformation.projetEcoleFormation.dal.StagiaireDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class UtilisateurManagerImpl implements UtilisateurManager {
	@Autowired
	FormateurDAO formateurDAO;
	@Autowired
	StagiaireDAO stagiaireDAO;
	@Autowired
	EvaluationSessionDAO evaluationSessionDAO;
	@Autowired
	EvaluationFormateurDAO evaluationFormateurDAO;
	@Autowired
	SessionFormationDAO sessionFormationDAO;

	@Override
	@Transactional
	public void addStagiaire(Stagiaire stagiaire) throws FormationException {
		//stagiaire.setMdp(String.valueOf(stagiaire.getMdp().hashCode()));

		for(Stagiaire stagiaireCourant : stagiaireDAO.findAll()) {
			if(stagiaireCourant.getNom().equals(stagiaire.getNom()) && stagiaireCourant.getMail().equals(stagiaire.getMail())){
				throw new FormationException(stagiaireCourant.getNom()+" est déjà présent");
			}
		}

        // TODO: 09/05/2022 Ajouter un chiffrage du mdp en BDD
        stagiaireDAO.save(stagiaire);
    }


	@Override
	@Transactional
	public void deleteStagiaire(Stagiaire stagiaire) throws UtilisateurManagerException {
		stagiaireDAO.findById(stagiaire.getIdUtilisateur())
		.orElseThrow(()->new UtilisateurManagerException("Stagiaire introuvable"));
		stagiaireDAO.delete(stagiaire);
	}

	@Override
	@Transactional
	public void modifyStagiaire(Stagiaire stagiaire){
		stagiaireDAO.save(stagiaire);

	}

	@Override
	public List<Stagiaire> getAllStagiaire() {
		return (List<Stagiaire>) stagiaireDAO.findAll();
	}

	@Override
	@Transactional
	public void deleteStagiaireById(Integer id) throws UtilisateurManagerException {
		Stagiaire stagiaire = stagiaireDAO.findById(id)
				.orElseThrow(()->new UtilisateurManagerException("Stagiaire introuvable"));
		for(SessionFormation session : stagiaire.getListeSessionFormation()) {
			session.getListeStagiaires().remove(stagiaire);
		}
		stagiaire.getListeSessionFormation().clear();

		for(EvaluationSession evalSession : stagiaire.getListeEvalSession()) {
			evalSession.setStagiaire(null);
		}
		for(EvaluationFormateur evalFormateur : stagiaire.getListeEvalFormateur()) {
			evalFormateur.setStagiaire(null);
		}


		stagiaireDAO.save(stagiaire);
		stagiaireDAO.deleteById(id);
	}

	@Override
	public Stagiaire getStagiaireById(Integer id) {

		return stagiaireDAO.findById(id).orElse(null);
	}



	@Override
	@Transactional
	public void addFormateur(Formateur formateur) throws FormationException {
		//formateur.setMdp(String.valueOf(formateur.getMdp().hashCode()));

		for(Formateur formateurCourant : formateurDAO.findAll()) {
			if(formateurCourant.getNom().equals(formateur.getNom()) && formateurCourant.getMail().equals(formateur.getMail())){
				throw new FormationException(formateurCourant.getNom()+" est déjà présent");
			}
		}

        // TODO: 09/05/2022 Ajouter un chiffrage du mdp en BDD
        formateurDAO.save(formateur);
    }


	@Override
	@Transactional
	public void deleteFormateur(Formateur formateur) throws UtilisateurManagerException {
		formateurDAO.findById(formateur.getIdUtilisateur())
		.orElseThrow(()->new UtilisateurManagerException("Formateur introuvable"));
		formateurDAO.delete(formateur);
	}

	@Override
	@Transactional
	public void modifyFormateur(Formateur formateur) {
		formateurDAO.save(formateur);
	}

	@Override
	@Transactional
	public void deleteFormateurById(Integer id) throws UtilisateurManagerException {
		formateurDAO.findById(id)
		.orElseThrow(()->new UtilisateurManagerException("Formateur introuvable"));
		formateurDAO.deleteById(id);
	}

	@Override
	public Formateur getFormateurById(Integer id) {
		return formateurDAO.findById(id).orElse(null);
	}

	@Override
	public List<Formateur> getAllFormateur() {
		return (List<Formateur>) formateurDAO.findAll();
	}

	@Override
	@Transactional
	public void addEvaluationSession(EvaluationSession evaluationSession) {
		evaluationSessionDAO.save(evaluationSession);
	}

	@Override
	@Transactional
	public void deleteEvaluationSession(EvaluationSession evaluationSession) throws UtilisateurManagerException {
		evaluationSessionDAO.findById(evaluationSession.getIdEvalSession())
		.orElseThrow(()->new UtilisateurManagerException("Stagiaire introuvable"));
		evaluationSessionDAO.delete(evaluationSession);
	}

	@Override
	@Transactional
	public void modifyEvaluationSession(EvaluationSession evaluationSession) {
		evaluationSessionDAO.save(evaluationSession);
	}

	@Override
	@Transactional
	public void deleteEvaluationSessionById(Integer id) throws UtilisateurManagerException {
		evaluationSessionDAO.findById(id)
		.orElseThrow(()->new UtilisateurManagerException("Evaluation de session introuvable"));
		evaluationSessionDAO.deleteById(id);
	}

	@Override
	public EvaluationSession getEvaluationSessionById(Integer id) {
		return evaluationSessionDAO.findById(id).orElse(null);
	}

	@Override
	public List<EvaluationSession> getAllEvaluationSession() {
		return (List<EvaluationSession>) evaluationSessionDAO.findAll();
	}

	@Override
	public void addEvaluationSessionToStagiaire(Stagiaire stagiaire, EvaluationSession... evaluationSession) {
		for (EvaluationSession eval : evaluationSession) {
			stagiaire.addEvalSession(eval);
		}
		stagiaireDAO.save(stagiaire);
	}

	@Override
	public void addEvaluationFormateurToStagiaire(Stagiaire stagiaire, EvaluationFormateur... evaluationFormateur) {
		for (EvaluationFormateur eval : evaluationFormateur) {
			stagiaire.addEvalFormateur(eval);
		}
		stagiaireDAO.save(stagiaire);
	}



	@Override
	@Transactional
	public void addEvaluationFormateur(EvaluationFormateur evaluationSession) {
		evaluationFormateurDAO.save(evaluationSession);
	}

	@Override
	@Transactional
	public void deleteEvaluationFormateur(EvaluationFormateur evaluationFormateur) throws UtilisateurManagerException {
		evaluationFormateurDAO.findById(evaluationFormateur.getIdEvalFormateur())
		.orElseThrow(()->new UtilisateurManagerException("Evaluation formateur introuvable"));
		evaluationFormateurDAO.delete(evaluationFormateur);
	}

	@Override
	@Transactional
	public void modifyEvaluationFormateur(EvaluationFormateur evaluationFormateur) {
		evaluationFormateurDAO.save(evaluationFormateur);
	}


    @Override
    @Transactional
    public void deleteEvaluationFormateurById(Integer id) throws UtilisateurManagerException {
        evaluationFormateurDAO.findById(id)
                .orElseThrow(()->new UtilisateurManagerException("Evaluation formateur introuvable"));
        evaluationFormateurDAO.deleteById(id);
    }


	@Override
	public EvaluationFormateur getEvaluationFormateurById(Integer id) {
		return evaluationFormateurDAO.findById(id).orElse(null);
	}

	@Override
	public List<EvaluationFormateur> getAllEvaluationFormateur() {
		return (List<EvaluationFormateur>) evaluationFormateurDAO.findAll();
	}

	@Override
	public Double getNoteMoyenneGlobalFormateur(Integer idFormateur) {
		Double sommeNote = 0.0; 
		for (EvaluationFormateur evalFormateur : evaluationFormateurDAO.findAllByFormateur(idFormateur)) {
			sommeNote += evalFormateur.getNoteMoyenneFormateur();
		}

		Double moyenne = sommeNote/(evaluationFormateurDAO.findAllByFormateur(idFormateur).size());
		return moyenne;
	}

	@Override
	public List<EvaluationFormateur> getListeEvaluationFormateurMauvaiseNote() {
		List<EvaluationFormateur> listeEvalFormateur = (List<EvaluationFormateur>) evaluationFormateurDAO.findAll();
		List<EvaluationFormateur> listeEvalFormateurMauvaiseNote = new ArrayList<>();
		for (EvaluationFormateur evalFormateur : listeEvalFormateur) {
			if ((evalFormateur.getNoteDisponibilite() < 3) || (evalFormateur.getNoteMaitriseDomaine() < 3) || (evalFormateur.getNotePedagogie() < 3) || (evalFormateur.getNoteReponsesQuestions() <3) || (evalFormateur.getNoteTechniqueAnimation() <3)) {
				listeEvalFormateurMauvaiseNote.add(evalFormateur);
			}
		}
		return listeEvalFormateurMauvaiseNote;
	}

	@Override
	public List<EvaluationSession> getListeEvaluationSessionMauvaiseNote() {
		List<EvaluationSession> listeEvalSession = (List<EvaluationSession>) evaluationSessionDAO.findAll();
		List<EvaluationSession> listeEvalSessionMauvaiseNote = new ArrayList<>();
		for (EvaluationSession evalSession : listeEvalSession) {
			if ((evalSession.getNoteAccueil() <3 || evalSession.getNoteEnvironnement() <3 || evalSession.getNoteContenuFormation() <3)) {
				listeEvalSessionMauvaiseNote.add(evalSession);
			}
		}
		return listeEvalSessionMauvaiseNote;
	}

}
