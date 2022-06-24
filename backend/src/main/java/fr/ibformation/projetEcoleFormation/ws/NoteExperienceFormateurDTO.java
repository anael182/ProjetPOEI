package fr.ibformation.projetEcoleFormation.ws;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;

import fr.ibformation.projetEcoleFormation.bo.EntrepriseClient;
import fr.ibformation.projetEcoleFormation.bo.EvaluationFormateur;
import fr.ibformation.projetEcoleFormation.bo.Formateur;
import fr.ibformation.projetEcoleFormation.bo.Formation;
import fr.ibformation.projetEcoleFormation.bo.SessionFormation;
import fr.ibformation.projetEcoleFormation.bo.Stagiaire;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NoteExperienceFormateurDTO {

	private String nomFormateur;
	private String prenomFormateur;
	private Double noteMoyenne;
	private Integer experienceFormateur;
	
	

	public Formateur toFormateur() {
		Formateur formateur = new Formateur();
		formateur.setNom(this.nomFormateur);
		formateur.setPrenom(this.prenomFormateur);
		return formateur;
	}
	
	public EvaluationFormateur toEvaluationFormateur() {
		EvaluationFormateur evaluationFormateur = new EvaluationFormateur();
		evaluationFormateur.setNoteMoyenneFormateur(this.noteMoyenne);
	
		return evaluationFormateur;
	}
}
