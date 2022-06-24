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
import fr.ibformation.projetEcoleFormation.bll.LieuFormationManager;
import fr.ibformation.projetEcoleFormation.bll.UtilisateurManager;
import fr.ibformation.projetEcoleFormation.bo.EntrepriseClient;
import fr.ibformation.projetEcoleFormation.bo.Stagiaire;
import fr.ibformation.projetEcoleFormation.ws.StagiaireDTO;

@Controller
@RequestMapping("/inscription-stagiaire")
public class InscriptionStagiaireController {

	@Autowired
	private UtilisateurManager utilisateurManager;
	
	@Autowired
	private LieuFormationManager lieuFormationManager;
	
	@GetMapping("/lstStagiaires")
	public String listStagiaires(Stagiaire stagiaire, Model model) {
		model.addAttribute("lstStagiaires", utilisateurManager.getAllStagiaire());
		return "lstStagiaires";
	}
	
	@GetMapping("/add")
    public String add(StagiaireDTO stagiaireDTO, Model model) {
        model.addAttribute("lstStagiaires", utilisateurManager.getAllStagiaire());
        return "formStagiaire";
    }
	
		
	@PostMapping("/valid")
	public String validInscription(@Valid StagiaireDTO stagiaireDTO, BindingResult errors, Model model) throws FormationException {
		if (errors.hasErrors()) {
			return "formStagiaire";
		}
		stagiaireDTO.setStatut("Stagiaire");
		Stagiaire s = stagiaireDTO.toStagiaire();
		EntrepriseClient e = stagiaireDTO.toEntreprise();
		utilisateurManager.addStagiaire(s);
		lieuFormationManager.addEntreprise(e);
		return "connexionStagiaire";
	}

}