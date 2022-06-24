package fr.ibformation.projetEcoleFormation.ws;

import fr.ibformation.projetEcoleFormation.bll.UtilisateurManager;
import fr.ibformation.projetEcoleFormation.bll.UtilisateurManagerException;
import fr.ibformation.projetEcoleFormation.bo.EvaluationSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/WS")
public class CrudEvaluationSessionWS {
    @Autowired
    private UtilisateurManager manager;

    @GetMapping("/evaluation-session")
    public List<EvaluationSession> getEvaluationsSession(){
        return manager.getAllEvaluationSession();
    }

    @GetMapping("/evaluation-session/{id}")
    public EvaluationSession getEvaluationSessionById(@PathVariable("id") Integer id){
        return manager.getEvaluationSessionById(id);
    }


    @PostMapping("/evaluation-session")
    public EvaluationSession addEvaluationSession(@RequestBody EvaluationSession evaluation) {
        manager.addEvaluationSession(evaluation);
        return evaluation;
    }

    @DeleteMapping("/evaluation-session")
    public EvaluationSession deleteEvaluationSession(@RequestBody EvaluationSession evaluation) throws UtilisateurManagerException {
        manager.deleteEvaluationSession(evaluation);
        return evaluation;
    }

    @DeleteMapping("/evaluation-session/{id}")
    public void deleteEvaluationSessionById(@PathVariable("id") Integer id) throws UtilisateurManagerException {
        manager.deleteEvaluationSessionById(id);
    }
}
