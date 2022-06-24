package fr.ibformation.projetEcoleFormation.dal;

import fr.ibformation.projetEcoleFormation.bo.Formation;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface FormationDAO extends CrudRepository<Formation, Integer> {
//	
//	@Query("DELETE sousTheme FROM sous_theme_formation_liste_formations sousTheme WHERE sousTheme.id=?1")
//	public void deleteSousThemeByIdFormation(Integer id);
}
