package fr.ibformation.projetEcoleFormation.ihm;

import fr.ibformation.projetEcoleFormation.bll.UtilisateurManager;
import fr.ibformation.projetEcoleFormation.bo.Formateur;
import fr.ibformation.projetEcoleFormation.bo.Stagiaire;
import fr.ibformation.projetEcoleFormation.bo.Utilisateur;
import fr.ibformation.projetEcoleFormation.dal.FormateurDAO;
import fr.ibformation.projetEcoleFormation.dal.StagiaireDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.annotation.SessionScope;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Objects;


@Controller
@RequestMapping("/login")
public class ConnexionController {
    @Autowired
    UtilisateurManager manager;

    @Autowired
    StagiaireDAO stagiaireDAO;

    @Autowired
    FormateurDAO formateurDAO;

    @Autowired
    private UserSession user;


    @GetMapping("/formateur")
    public String get(Formateur formateur, Model model) {
        model.addAttribute("lstFormateurs", manager.getAllFormateur());
        return "connexionFormateur";
    }

    @PostMapping("/formateur-login")
    public String valid(@Valid Formateur formateur, BindingResult errors, Model model) {
        if (errors.hasErrors()) {
            return "connexionFormateur";
        }
        Formateur checkUserMailExist = formateurDAO.findFormateurByEmail(formateur.getMail());
        if (checkUserMailExist != null && checkUserMailExist.getMdp().equals(formateur.getMdp())) {
            return "redirect:http://localhost:4200/page-accueil";
        }
        return "connexionFormateur";
    }

    @GetMapping("/stagiaire")
    public String get(Stagiaire stagiaire, Model model) {
        model.addAttribute("lstStagiaires", manager.getAllStagiaire());
        return "connexionStagiaire";
    }

    @PostMapping("/stagiaire-login")
    public String valid(@Valid Stagiaire stagiaire, BindingResult errors) {
        if (errors.hasErrors()) {
            return "connexionStagiaire";
        }
        Stagiaire checkUserMailExist = stagiaireDAO.findStagiaireByEmail(stagiaire.getMail());
        // TODO: 09/05/2022 Ajouter un chiffrage du mdp en BDD et une verification de la correspondance du mdp à l'authentification
        if (checkUserMailExist != null && checkUserMailExist.getMdp().equals(stagiaire.getMdp())) {
            checkUserMailExist.setMdp("hidden");
            user.setUtilisateur(checkUserMailExist);
            return "redirect:http://localhost:4200/page-accueil";
        }
        return "connexionStagiaire";
    }
}

