package fr.ibformation.projetEcoleFormation.dal;

import fr.ibformation.projetEcoleFormation.bo.EvaluationSession;
import org.springframework.data.repository.CrudRepository;

public interface EvaluationSessionDAO extends CrudRepository<EvaluationSession, Integer> {
}
