package fr.ibformation.projetEcoleFormation.ws;

import java.util.List;

import fr.ibformation.projetEcoleFormation.bll.UtilisateurManager;
import fr.ibformation.projetEcoleFormation.bo.SessionFormation;
import fr.ibformation.projetEcoleFormation.bo.Stagiaire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import fr.ibformation.projetEcoleFormation.bll.FormationException;
import fr.ibformation.projetEcoleFormation.bll.FormationManager;
import fr.ibformation.projetEcoleFormation.bo.Formation;

import javax.transaction.Transactional;

@CrossOrigin
@RestController
@RequestMapping("/WS")
public class CrudFormationWS {

	@Autowired
	private FormationManager formationManager;
	@Autowired
	private UtilisateurManager utilisateurManager;
	
	
	@GetMapping("/formation")
	public List<Formation> getFormations(){
		return formationManager.getListeFormations();
	}
	
	@GetMapping("/formation/{id}")
	public Formation getFormationById(@PathVariable("id") Integer id){
		return formationManager.getFormationById(id);
	}
	
	@PostMapping("/formation")
	public Formation addFormation(@RequestBody Formation formation) throws FormationException {
		formationManager.addFormation(formation);
		return formation;
	}
	
	@PutMapping("/formation")
	public Formation modifyFormation(@RequestBody Formation formation) {
		formationManager.modifyFormation(formation);
		return formation;
	}
	
	@DeleteMapping("/formation/{id}")
	public List<Formation> deleteFormationById(@PathVariable("id") Integer id) throws FormationException {
//		Formation formation = formationManager.getFormationById(id);
//		List <SousThemeFormation> sousThemes = formationManager.getListeSousThemesFormation();
//		if (sousThemes.size() >0) {
//			System.out.println(formation.getListeSousThemeFormation().size());
//			for (SousThemeFormation sousTheme : sousThemes) {
//					sousThemes.remove(sousTheme);
//			}
//			
//		//formationManager.modifyFormation(formation);
//		}
		formationManager.deleteFormationById(id);
		return formationManager.getListeFormations();
	}
	
//	@DeleteMapping ("/formation/{id}")
//		public void deleteSousThemeByIdFormation(@PathVariable("id") Integer id) throws FormationException {
//		formationManager.deleteSousThemeFormationById(id);
//	}

	@PostMapping("/stagiaire-to-session/{id1}/{id2}")
	@Transactional
	@ResponseBody
	public SessionFormation addStagiaireToSessionByIds(@PathVariable("id1") Integer idSession, @PathVariable("id2") Integer idStagiaire){
		Stagiaire stagiaire = utilisateurManager.getStagiaireById(idStagiaire);
		SessionFormation sessionFormation = formationManager.getSessionFormationById(idSession);
		stagiaire.addSessionFormation(sessionFormation);
		return sessionFormation;
	}
	
}
