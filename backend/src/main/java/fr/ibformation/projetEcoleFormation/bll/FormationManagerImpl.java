package fr.ibformation.projetEcoleFormation.bll;


import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import fr.ibformation.projetEcoleFormation.bo.Stagiaire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.ibformation.projetEcoleFormation.bo.Formation;
import fr.ibformation.projetEcoleFormation.bo.SessionFormation;
import fr.ibformation.projetEcoleFormation.bo.SousThemeFormation;
import fr.ibformation.projetEcoleFormation.dal.FormationDAO;
import fr.ibformation.projetEcoleFormation.dal.SessionFormationDAO;
import fr.ibformation.projetEcoleFormation.dal.SousThemeFormationDAO;

@Service
public class FormationManagerImpl implements FormationManager {

	@Autowired
	private FormationDAO formationDAO;
	@Autowired
	private SousThemeFormationDAO sousThemeFormationDAO;
	@Autowired
	private SessionFormationDAO sessionFormationDAO;


	
	@Override
	@Transactional
	public void addFormation(Formation formation) throws FormationException {
		// CT002 : pas de doublon(nom/prenom)
		for(Formation formationCourante : formationDAO.findAll()) {
			if(formationCourante.getNomFormation().equals(formation.getNomFormation())){
				throw new FormationException(formationCourante.getNomFormation()+" est déjà présente");
			}
		}
		formationDAO.save(formation);
	}
	@Override
	public List<Formation> getListeFormations() {
		return (List<Formation>) formationDAO.findAll();
	}
	@Override
	@Transactional
	public void modifyFormation(Formation formation) {
		formationDAO.save(formation);

	}
	@Override
	@Transactional
	public void deleteFormationById(Integer idFormation)  throws FormationException {
		Formation formation = formationDAO.findById(idFormation)
				.orElseThrow(() -> new FormationException("Formation Inexistante"));

		for (SessionFormation session : formation.getListeSessionFormation()) {
			deleteSessionFormationById(session.getIdSession());
		}
		formation.getListeSessionFormation().clear();

		//https://stackoverflow.com/a/38302308
		for (SousThemeFormation sousTheme : formation.getListeSousThemeFormation()) {
			sousTheme.getListeFormations().remove(formation);
		}

		formation.getListeSousThemeFormation().clear();


		formationDAO.save(formation);

		formationDAO.deleteById(idFormation);

	}
	@Override
	public Formation getFormationById(Integer idFormation) {
		return formationDAO.findById(idFormation).orElse(null);
	}
	@Override
	@Transactional
	public void addSousThemeFormation(SousThemeFormation... sousThemesFormation) throws FormationException {
		for (SousThemeFormation sousThemeFormation : sousThemesFormation) {

			for(SousThemeFormation sousThemeCourante : sousThemeFormationDAO.findAll()) {
				if(sousThemeCourante.getNomSousTheme().equals(sousThemeFormation.getNomSousTheme())){
					throw new FormationException(sousThemeFormation.getNomSousTheme()+" est déjà présent");
				}
			}
			sousThemeFormationDAO.save(sousThemeFormation);
		}
	}
	@Override
	@Transactional
	public void addSousThemeToFormation(Formation formation, SousThemeFormation... sousThemesFormation) {
		for (SousThemeFormation sousThemeFormation : sousThemesFormation) {
			formation.addSousThemeFormation(sousThemeFormation);
		}
		formationDAO.save(formation);
	}

	@Override
	public List<SousThemeFormation> getListeSousThemesFormation() {
		return (List<SousThemeFormation>) sousThemeFormationDAO.findAll();
	}

	@Override
	@Transactional
	public void modifySousThemeFormation(SousThemeFormation sousThemeFormation) {
		sousThemeFormationDAO.save(sousThemeFormation);

	}
	@Override
	@Transactional
	public void deleteSousThemeFormationById(Integer idSousThemeFormation) throws FormationException {
		sousThemeFormationDAO.findById(idSousThemeFormation)
				.orElseThrow(() -> new FormationException("Sous-Theme Formation Inexistant"));
		sousThemeFormationDAO.deleteById(idSousThemeFormation);

	}

	@Override
	@Transactional
	public void addSessionFormation(SessionFormation sessionFormation) {
		sessionFormationDAO.save(sessionFormation);

	}


	@Override
	public List<SessionFormation> getListeSessionsFormation() {
		return (List<SessionFormation>) sessionFormationDAO.findAll();
	}
	@Override
	@Transactional
	public void modifySessionFormation(SessionFormation sessionFormation) {
		sessionFormationDAO.save(sessionFormation);

	}

	
	@Override
	@Transactional
	public void deleteSessionFormationById(Integer idSessionFormation) throws FormationException {
		
		SessionFormation session = sessionFormationDAO.findById(idSessionFormation)
				.orElseThrow(() -> new FormationException("SessionFormation Inexistant"));

		sessionFormationDAO.delete(session);
		
		//		SessionFormation session = sessionFormationDAO.findById(idSessionFormation)
		//				.orElseThrow(() -> new FormationException("SessionFormation Inexistant"));
		//		//on doit supprimer le lien entre stagiaire et sessionFormation
		//		//https://stackoverflow.com/a/38302308
		//		for (Stagiaire stagiaire : session.getListeStagiaires()) {
		//			stagiaire.getListeSessionFormation().remove(session);
		//		}
		//        session.getListeStagiaires().clear();
		//		
		//        session.getFormation().getListeSessionFormation().remove(session);
		//        session.setFormation(null);
		//        
		//    	for (EvaluationSession evalSession : session.getListeEvalSession()) {
		//    		evalSession.setSessionFormation(null);
		//    		evalSessionDao.save(evalSession);
		//    		evalSessionDao.delete(evalSession);
		//    		
		//    	}
		//      	session.getListeEvalSession().clear();
		//
		//      	
		//    	for (EvaluationFormateur evalFormateur : session.getListeEvalFormateur()) {
		//    		evalFormateur.setSessionFormation(null);
		//		}
		//    	session.getListeEvalFormateur().clear();
		//    	
		//    	
		//    	sessionFormationDAO.save(session);
		//    	sessionFormationDAO.deleteById(session.getIdSession());

	}


	@Override
	public SessionFormation getSessionFormationById(Integer idSessionFormation) {
		return sessionFormationDAO.findById(idSessionFormation).orElse(null);
	}
	@Override
	public Integer getExperienceGlobalFormateur(Integer idFormateur) {
		Integer jour = 0; 
		for (SessionFormation session : sessionFormationDAO.findAllByFormateur(idFormateur)) {

			jour = (int) ChronoUnit.DAYS.between(session.getDateDebut(), session.getDateFin());
			jour++;
		}
		return jour;
	}


	@Override
	public List<SessionFormation> getListeSessionsAAnnuler() {
		List <SessionFormation> sessions = (List<SessionFormation>) sessionFormationDAO.findAll();
		List <SessionFormation> sessionsAnnuler = new ArrayList<>();
		for (SessionFormation session : sessions) {
			if (session.getListeStagiaires().size() <= 3) {
				sessionsAnnuler.add(session);
			}
		}
		return sessionsAnnuler;
	}
	@Override
	public List<SessionFormation> getListeFormateurAnnulationApresLimite() {
		Integer jour = 0; 
		List<SessionFormation> listeSessions = (List<SessionFormation>) sessionFormationDAO.findAll();
		List<SessionFormation> listeSessionAnnulationApresLimite = new ArrayList<>();
		for (SessionFormation session : listeSessions) {
			if (session.getDateAnnulation() == null) {
				continue;
			}
			jour = (int) ChronoUnit.DAYS.between(session.getDateAnnulation(), session.getDateDebut());
			if (jour <15) {
				listeSessionAnnulationApresLimite.add(session);
			}
		}return listeSessionAnnulationApresLimite;
	}

	@Override
	public void addStagiaireToSession(SessionFormation session, Stagiaire... stagiaire) {
		for (Stagiaire stagiaires : stagiaire) {
			session.addStagiaire(stagiaires);
		}
		sessionFormationDAO.save(session);
	}

}
