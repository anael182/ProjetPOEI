package fr.ibformation.projetEcoleFormation.ihm;

import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.ibformation.projetEcoleFormation.bll.FormationException;
import fr.ibformation.projetEcoleFormation.bll.UtilisateurManager;
import fr.ibformation.projetEcoleFormation.bo.EvaluationSession;
import fr.ibformation.projetEcoleFormation.bo.Formateur;

@Controller
@RequestMapping("/inscription-formateur")
public class InscriptionFormateurController {

	@Autowired
	private UtilisateurManager utilisateurManager;
	
	@GetMapping("/lstFormateurs")
	public String listFormations(Formateur formateur, Model model) {
		model.addAttribute("lstFormateurs", utilisateurManager.getAllFormateur());
		return "lstFormateurs";
	}
	
	@GetMapping("/add")
    public String add(Formateur formateur, Model model) {
        model.addAttribute("lstFormateurs", utilisateurManager.getAllFormateur());
        return "formFormateur";
    }
	
		
	@PostMapping("/valid")
	public String validInscription(@Valid Formateur formateur, BindingResult errors, Model model) throws FormationException {
		if (errors.hasErrors()) {
			return "formFormateur";
		}
		formateur.setStatut("Formateur");
		utilisateurManager.addFormateur(formateur);
		return "connexionFormateur";
	}
	
}
