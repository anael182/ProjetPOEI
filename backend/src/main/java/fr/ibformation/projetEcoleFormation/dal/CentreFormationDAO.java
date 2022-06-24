package fr.ibformation.projetEcoleFormation.dal;

import fr.ibformation.projetEcoleFormation.bo.CentreFormation;

import org.springframework.data.repository.CrudRepository;

public interface CentreFormationDAO extends CrudRepository<CentreFormation, Integer> {
}
