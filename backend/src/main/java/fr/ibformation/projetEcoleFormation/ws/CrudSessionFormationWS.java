package fr.ibformation.projetEcoleFormation.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.ibformation.projetEcoleFormation.bll.FormationException;
import fr.ibformation.projetEcoleFormation.bll.FormationManager;
import fr.ibformation.projetEcoleFormation.bo.Formation;
import fr.ibformation.projetEcoleFormation.bo.SessionFormation;
import fr.ibformation.projetEcoleFormation.bo.SousThemeFormation;
@CrossOrigin
@RestController
@RequestMapping("/WS")
public class CrudSessionFormationWS {

	@Autowired
	private FormationManager formationManager;
	
	
	@GetMapping("/session-formation")
	public List<SessionFormation> getSessionFormations(){
		return formationManager.getListeSessionsFormation();
	}
	
	@GetMapping("/session-formation/{id}")
	public SessionFormation getSessionFormationById(@PathVariable("id") Integer id) {
		return formationManager.getSessionFormationById(id);
	}
	
	
	@PostMapping("/session-formation")
	public SessionFormation addSessionFormation(@RequestBody SessionFormation sessionFormation) {
		formationManager.addSessionFormation(sessionFormation);
		return sessionFormation;
	}
	
	@PutMapping("/session-formation")
	public SessionFormation modifySessionFormation(@RequestBody SessionFormation sessionFormation) {
		formationManager.modifySessionFormation(sessionFormation);
		return sessionFormation;
	}
	
	@DeleteMapping("/session-formation/{id}")
	public void deleteSessionFormationById(@PathVariable("id") Integer id) throws FormationException {
		formationManager.deleteSessionFormationById(id);
	}
	
}
