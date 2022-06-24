package fr.ibformation.projetEcoleFormation.ihm;

import java.time.LocalDate;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.ibformation.projetEcoleFormation.bll.FormationManager;
import fr.ibformation.projetEcoleFormation.bll.UtilisateurManager;
import fr.ibformation.projetEcoleFormation.bo.EvaluationFormateur;
import fr.ibformation.projetEcoleFormation.bo.EvaluationSession;
import fr.ibformation.projetEcoleFormation.bo.Formateur;
import fr.ibformation.projetEcoleFormation.bo.SessionFormation;
import fr.ibformation.projetEcoleFormation.bo.Stagiaire;
import fr.ibformation.projetEcoleFormation.ws.EvaluationDTO;
import fr.ibformation.projetEcoleFormation.ws.NoteExperienceFormateurDTO;
import fr.ibformation.projetEcoleFormation.ws.SessionDTO;

@Controller
@RequestMapping("/admin")
public class AdminFormationController {

	@Autowired
	private UtilisateurManager utilisateurManager;
	@Autowired
	private FormationManager formationManager;

	@GetMapping("/note-experience-formateur")
	public String listNoteExpFormateur(Model model) {
		
		List <NoteExperienceFormateurDTO> noteExpFormateurs = new ArrayList<>();
		
		
		for (Formateur formateur : utilisateurManager.getAllFormateur()) {
			NoteExperienceFormateurDTO sessionoteExpFormateurDTO = new NoteExperienceFormateurDTO();
			sessionoteExpFormateurDTO.setNomFormateur(formateur.getNom());
			sessionoteExpFormateurDTO.setPrenomFormateur(formateur.getPrenom());
			Integer id = formateur.getIdUtilisateur();
			
			Double noteMoyenneGlobal = utilisateurManager.getNoteMoyenneGlobalFormateur(id);
			sessionoteExpFormateurDTO.setNoteMoyenne(noteMoyenneGlobal);
			
			Integer expFormateur = formationManager.getExperienceGlobalFormateur(id);
			sessionoteExpFormateurDTO.setExperienceFormateur(expFormateur);
			
			noteExpFormateurs.add(sessionoteExpFormateurDTO);
			
		}
		
		model.addAttribute("noteExpFormateurs", noteExpFormateurs);
		
		return "lstNoteExpFormateur";
	}
	
	@GetMapping("/mes-taches")
	public String listMesTaches(Model model) {
	
		List <EvaluationDTO> evalSessions = new ArrayList<>();
		
		List <EvaluationDTO> evalFormateurs = new ArrayList<>();
		
		List <EvaluationDTO> annulationFormateurs = new ArrayList<>();
		
		for (EvaluationSession evalSession : utilisateurManager.getListeEvaluationSessionMauvaiseNote()) {
			
			EvaluationDTO evaluationDTO = new EvaluationDTO();
			evaluationDTO.setIdSession(evalSession.getSessionFormation().getIdSession());
			evaluationDTO.setIdEvalSession(evalSession.getIdEvalSession());
			evaluationDTO.setNoteAccueil(evalSession.getNoteAccueil());
			evaluationDTO.setNoteEnvironnement(evalSession.getNoteEnvironnement());
			evaluationDTO.setNoteContenuFormation(evalSession.getNoteContenuFormation());
			evaluationDTO.setNom(evalSession.getStagiaire().getNom());
			evaluationDTO.setPrenom(evalSession.getStagiaire().getPrenom());
			evalSessions.add(evaluationDTO);
			}
		
for (EvaluationFormateur evalFormateur : utilisateurManager.getListeEvaluationFormateurMauvaiseNote()) {
			
			EvaluationDTO evaluationDTO2 = new EvaluationDTO();
			evaluationDTO2.setIdSession(evalFormateur.getSessionFormation().getIdSession());
			evaluationDTO2.setIdEvalSession(evalFormateur.getIdEvalFormateur());
			evaluationDTO2.setNotePedagogie(evalFormateur.getNotePedagogie());
			evaluationDTO2.setNoteMaitriseDomaine(evalFormateur.getNoteMaitriseDomaine());
			evaluationDTO2.setNoteDisponibilite(evalFormateur.getNoteDisponibilite());
			evaluationDTO2.setNoteReponsesQuestions(evalFormateur.getNoteReponsesQuestions());
			evaluationDTO2.setNoteTechniqueAnimation(evalFormateur.getNoteTechniqueAnimation());
			evaluationDTO2.setNom(evalFormateur.getStagiaire().getNom());
			evaluationDTO2.setPrenom(evalFormateur.getStagiaire().getPrenom());
			evaluationDTO2.setNomFormateur(evalFormateur.getFormateur().getNom());
			evaluationDTO2.setPrenomFormateur(evalFormateur.getFormateur().getPrenom());
			evalFormateurs.add(evaluationDTO2);
			}

for (SessionFormation session : formationManager.getListeFormateurAnnulationApresLimite()) {
	
	EvaluationDTO evaluationDTO3 = new EvaluationDTO();
	evaluationDTO3.setIdSession(session.getIdSession());
	evaluationDTO3.setNom(session.getFormateur().getNom());;
	evaluationDTO3.setPrenom(session.getFormateur().getPrenom());
	annulationFormateurs.add(evaluationDTO3);
	}

        model.addAttribute("formateurAnnulationApresLimite", annulationFormateurs);
		model.addAttribute("sessionsAAnnuler", formationManager.getListeSessionsAAnnuler());
		model.addAttribute("evaluationFormateurMauvaiseNote", evalFormateurs);
		model.addAttribute("evaluationSessionMauvaiseNote", evalSessions);
		return "lstTachesAdmin";
	}
	
	@GetMapping("/liste-des-sessions")
	public String listSessions(Model model) {

		List <SessionDTO> sessions = new ArrayList<>();

		for (SessionFormation session : formationManager.getListeSessionsFormation()) {
			
				SessionDTO sessionDTO = new SessionDTO();
				sessionDTO.setIdSession(session.getIdSession());
				sessionDTO.setDateDebut(session.getDateDebut());
				sessionDTO.setDateFin(session.getDateFin());
				sessionDTO.setTypeFormation(session.getTypeFormation());

				if (session.getFormation() != null) {
					sessionDTO.setNomFormation(session.getFormation().getNomFormation());
				} else {
					sessionDTO.setNomFormation("N/A");
				}
				sessions.add(sessionDTO);
			}

	model.addAttribute("sessions", sessions);
	
	return "lstSessionsAdmin";
}
	
	////////////////////////////////////////////////////////////
	///// Données de test
	
	Stagiaire getStagiaire() {
		Stagiaire stagiaire;

		stagiaire = utilisateurManager.getAllStagiaire().get(0);
		
		return stagiaire;
	}
	
}