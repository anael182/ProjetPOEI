package fr.ibformation.projetEcoleFormation.ws;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;

import fr.ibformation.projetEcoleFormation.bo.EntrepriseClient;
import fr.ibformation.projetEcoleFormation.bo.Formation;
import fr.ibformation.projetEcoleFormation.bo.SessionFormation;
import fr.ibformation.projetEcoleFormation.bo.Stagiaire;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SessionDTO {

	@NotBlank(message =  "Champs Nom Formation vide")
	private String nomFormation;
	
	@NotBlank(message =  "Champs ID Session vide")
	private Integer idSession;
	@NotBlank(message =  "Champs Date de début vide")
	private LocalDate dateDebut;
	@NotBlank(message =  "Champs Date de fin vide")
	private LocalDate dateFin;
	@NotBlank(message =  "Champs Type de formation vide")
	private String typeFormation;
	@NotBlank
	private Boolean estEvaluable;
	
	

	public Formation toFormation() {
		Formation formation = new Formation();
		formation.setNomFormation(this.nomFormation);
		return formation;
	}
	
	public SessionFormation toSessionFormation() {
		SessionFormation sessionFormation = new SessionFormation();
		sessionFormation.setIdSession(this.idSession);
		sessionFormation.setDateDebut(this.dateDebut);
		sessionFormation.setDateFin(this.dateFin);
		sessionFormation.setTypeFormation(this.typeFormation);
		return sessionFormation;
	}
}
