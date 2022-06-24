package fr.ibformation.projetEcoleFormation.ws;

import fr.ibformation.projetEcoleFormation.bll.FormationException;
import fr.ibformation.projetEcoleFormation.bll.UtilisateurManager;
import fr.ibformation.projetEcoleFormation.bll.UtilisateurManagerException;
import fr.ibformation.projetEcoleFormation.bo.Formateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/WS")
public class CrudFormateurWS {
    @Autowired
    private UtilisateurManager manager;

    @GetMapping("/formateur")
    public List<Formateur> getFormateurs(){
        return manager.getAllFormateur();
    }

    @GetMapping("/formateur/{id}")
    public Formateur getFormateurById(@PathVariable("id") Integer id){
        return manager.getFormateurById(id);
    }


    @PostMapping("/formateur")
    public Formateur addFormateur(@RequestBody Formateur formateur) throws FormationException {
        manager.addFormateur(formateur);
        return formateur;
    }

    @PutMapping("/formateur")
    public Formateur modifyFormateur(@RequestBody Formateur formateur) {
        manager.modifyFormateur(formateur);
        return formateur;
    }

    @DeleteMapping("/formateur")
    public Formateur deleteFormateur(@RequestBody Formateur formateur) throws UtilisateurManagerException {
        manager.deleteFormateur(formateur);
        return formateur;
    }

    @DeleteMapping("/formateur/{id}")
    public void deleteFormateurById(@PathVariable("id") Integer id) throws UtilisateurManagerException {
        manager.deleteFormateurById(id);
    }
}
