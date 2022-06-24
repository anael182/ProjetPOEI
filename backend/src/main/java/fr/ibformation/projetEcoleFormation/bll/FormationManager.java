package fr.ibformation.projetEcoleFormation.bll;

import java.util.List;

import fr.ibformation.projetEcoleFormation.bo.*;

public interface FormationManager {
	public void addFormation(Formation formation) throws FormationException;
	public List<Formation> getListeFormations();
	public void modifyFormation(Formation formation);
	public void deleteFormationById(Integer idFormation) throws FormationException;
	public Formation getFormationById(Integer idFormation);
	
	
	public void addSousThemeFormation(SousThemeFormation... sousThemesFormation) throws FormationException;
	public void addSousThemeToFormation(Formation formation, SousThemeFormation... sousThemesFormation);
	public List<SousThemeFormation> getListeSousThemesFormation();
	public void modifySousThemeFormation(SousThemeFormation sousThemeFormation);
	public void deleteSousThemeFormationById(Integer idSousThemeFormation) throws FormationException;
	
	
	public void addSessionFormation(SessionFormation sessionFormation);
	public List<SessionFormation> getListeSessionsFormation();
	public void modifySessionFormation(SessionFormation sessionFormation);
	public void deleteSessionFormationById(Integer idSessionFormation) throws FormationException;
	public SessionFormation getSessionFormationById(Integer idSessionFormation);
	
	
	public Integer getExperienceGlobalFormateur(Integer idFormateur);
	public List<SessionFormation> getListeSessionsAAnnuler();
	public List<SessionFormation>  getListeFormateurAnnulationApresLimite();

	void addStagiaireToSession(SessionFormation session, Stagiaire... stagiaire);
}
