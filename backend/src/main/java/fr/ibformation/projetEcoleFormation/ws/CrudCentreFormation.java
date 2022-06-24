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
import fr.ibformation.projetEcoleFormation.bll.LieuException;
import fr.ibformation.projetEcoleFormation.bll.LieuFormationManager;
import fr.ibformation.projetEcoleFormation.bo.CentreFormation;

@CrossOrigin
@RestController
@RequestMapping("/WS")
public class CrudCentreFormation {
	@Autowired
	private LieuFormationManager manager;
	
	@GetMapping("/centreFormation")
	public List<CentreFormation> getAllCentreFormation(){
		return manager.getAllCentreFormation();
		
	}
	
	@GetMapping("/centreFormation/{id}")
	public CentreFormation getCentreFormationById(@PathVariable("id") Integer id) {
		return manager.getCentreFormationById(id);
		
	}
	
	@PostMapping("/centreFormation")
	public CentreFormation addCentreFormation(@RequestBody CentreFormation centre ) throws FormationException {
		 manager.addCentreFormation(centre);
		 return centre;
		
	}
	
	@PutMapping("/centreFormation")
	public CentreFormation modifayCentreFormation(@RequestBody CentreFormation centre ) {
		manager.updateCentreFormation(centre);
		return centre;
		
	}
	
	@DeleteMapping("/centreFormation/{id}")
	public void deleteCentreFormation(@PathVariable("id") Integer id) throws LieuException {
		
		manager.deleteCentreFormationById(id);
	}

}
