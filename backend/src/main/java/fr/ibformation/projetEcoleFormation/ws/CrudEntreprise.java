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
import fr.ibformation.projetEcoleFormation.bo.EntrepriseClient;
@CrossOrigin
@RestController
@RequestMapping("/WS")
public class CrudEntreprise {
	@Autowired
	private LieuFormationManager manager;
	
	@GetMapping("/entreprise")
	public List<EntrepriseClient> getAllEntreprise(){
		return manager.getAllEntreprise();
		
	}
	
	@GetMapping("/entreprise/{id}")
	public EntrepriseClient getEntrepriseClientById(@PathVariable("id") Integer id) {
		return manager.getEntrepriseById(id);
	}
	
	@PostMapping("/entreprise")
	public EntrepriseClient addEntrepriseClient(@RequestBody EntrepriseClient entreprise ) throws FormationException {
		 manager.addEntreprise(entreprise);
		 return entreprise;
		
	}
	
	@PutMapping("/entreprise")
	public EntrepriseClient modifayEntrepriseClient(@RequestBody EntrepriseClient entreprise ) {
		manager.updateEntreprise(entreprise);
		return entreprise;
		
	}
	
	@DeleteMapping("/entreprise/{id}")
	public void deleteEntrepriseClient(@PathVariable("id") Integer id) throws LieuException {
		
		manager.deleteEntrepriseById(id);
	}

}
