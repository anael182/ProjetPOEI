package fr.ibformation.projetEcoleFormation.ws;

import fr.ibformation.projetEcoleFormation.bll.UtilisateurManager;
import fr.ibformation.projetEcoleFormation.bll.UtilisateurManagerException;
import fr.ibformation.projetEcoleFormation.bo.EvaluationFormateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/WS")
public class CrudEvaluationFormateurWS {
    @Autowired
    private UtilisateurManager manager;

    @GetMapping("/evaluation-formateur")
    public List<EvaluationFormateur> getEvaluationsFormateur(){
        return manager.getAllEvaluationFormateur();
    }

    @GetMapping("/evaluation-formateur/{id}")
    public EvaluationFormateur getEvaluationFormateurById(@PathVariable("id") Integer id){
        return manager.getEvaluationFormateurById(id);
    }


    @PostMapping("/evaluation-formateur")
    public EvaluationFormateur addEvaluationFormateur(@RequestBody EvaluationFormateur evaluation) {
        manager.addEvaluationFormateur(evaluation);
        return evaluation;
    }

    @DeleteMapping("/evaluation-formateur")
    public EvaluationFormateur deleteEvaluationFormateur(@RequestBody EvaluationFormateur evaluation) throws UtilisateurManagerException {
        manager.deleteEvaluationFormateur(evaluation);
        return evaluation;
    }

    @DeleteMapping("/evaluation-formateur/{id}")
    public void deleteEvaluationFormateurById(@PathVariable("id") Integer id) throws UtilisateurManagerException {
        manager.deleteEvaluationFormateurById(id);
    }
}
