package fr.ibformation.projetEcoleFormation.dal;

import fr.ibformation.projetEcoleFormation.bo.SessionFormation;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface SessionFormationDAO extends CrudRepository<SessionFormation, Integer> {
	
	@Query("SELECT session FROM SessionFormation session WHERE session.formateur.idUtilisateur=:id")
	List <SessionFormation> findAllByFormateur(@Param("id")Integer id);
	
}
