package fr.ibformation.projetEcoleFormation.dal;

import fr.ibformation.projetEcoleFormation.bo.Stagiaire;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface StagiaireDAO extends CrudRepository<Stagiaire, Integer> {

    @Query("SELECT s FROM Stagiaire s where s.mail= ?1")
    Stagiaire findStagiaireByEmail(@Param("stagiaire") String mail);

}
