package fr.ibformation.projetEcoleFormation.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import fr.ibformation.projetEcoleFormation.bo.SousThemeFormation;
@CrossOrigin
@RestController
@RequestMapping("/WS")
public class CrudSousThemeFormationWS {

	@Autowired
	private FormationManager formationManager;
	
	
	@GetMapping("/sous-theme-formation")
	public List<SousThemeFormation> getSousThemeFormations(){
		return formationManager.getListeSousThemesFormation();
	}

	@PostMapping("/sous-theme-formation")
	public SousThemeFormation addSousThemeFormation(@RequestBody SousThemeFormation sousThemeFormation) throws FormationException {
		formationManager.addSousThemeFormation(sousThemeFormation);
		return sousThemeFormation;
	}
	
	
	@PutMapping("/sous-theme-formation")
	public SousThemeFormation modifySousThemeFormation(@RequestBody SousThemeFormation sousThemeFormation) {
		formationManager.modifySousThemeFormation(sousThemeFormation);
		return sousThemeFormation;
	}
	
	@DeleteMapping("/sous-theme-formation/{id}")
	public void deleteSousThemeFormationById(@PathVariable("id") Integer id) throws FormationException {
		formationManager.deleteSousThemeFormationById(id);
	}
	
}
