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
import fr.ibformation.projetEcoleFormation.bo.Formation;
import fr.ibformation.projetEcoleFormation.bo.SessionFormation;
import fr.ibformation.projetEcoleFormation.bo.Stagiaire;
import fr.ibformation.projetEcoleFormation.ws.SessionDTO;

@Controller
@RequestMapping("/espace-client")
public class EspaceClientController {

	@Autowired
	private UtilisateurManager utilisateurManager;
	@Autowired
	private FormationManager formationManager;

	@GetMapping("/mes-sessions")
	public String listSession(Model model) {

		List <SessionDTO> sessions = new ArrayList<>();
		Stagiaire stagiaire = getStagiaire();

		for (SessionFormation session : formationManager.getListeSessionsFormation()) {
			
			
			if (session.getListeStagiaires().contains(stagiaire)) {
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

				LocalDate now = LocalDate.now();
				LocalDate sessionFini = session.getDateFin();

				int compareValue = now.compareTo(sessionFini);

				if (compareValue >= 0) {
					sessionDTO.setEstEvaluable(true);
				} else if (compareValue < 0) {
					sessionDTO.setEstEvaluable(false);
				}
			}
		}

		model.addAttribute("sessions", sessions);

		model.addAttribute("listeSessionStagiaire", formationManager.getListeSessionsFormation());

		return "lstSessionStagiaire";
	}



	////////////////////////////////////////////////////////////
	///// Données de test

	Stagiaire getStagiaire() {
		Stagiaire stagiaire;

		stagiaire = utilisateurManager.getAllStagiaire().get(0);

		return stagiaire;
	}

}