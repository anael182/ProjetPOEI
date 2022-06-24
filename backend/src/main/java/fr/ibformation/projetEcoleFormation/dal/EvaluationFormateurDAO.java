package fr.ibformation.projetEcoleFormation.dal;

import fr.ibformation.projetEcoleFormation.bo.EvaluationFormateur;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface EvaluationFormateurDAO extends CrudRepository<EvaluationFormateur, Integer> {
	
	@Query("SELECT evalF FROM EvaluationFormateur evalF WHERE evalF.formateur.idUtilisateur=:id")
	List <EvaluationFormateur> findAllByFormateur(@Param("id")Integer id);
}
