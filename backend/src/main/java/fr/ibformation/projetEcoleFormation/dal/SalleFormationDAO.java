package fr.ibformation.projetEcoleFormation.dal;

import fr.ibformation.projetEcoleFormation.bo.SalleFormation;

import org.springframework.data.repository.CrudRepository;

public interface SalleFormationDAO extends CrudRepository<SalleFormation, Integer> {
}
