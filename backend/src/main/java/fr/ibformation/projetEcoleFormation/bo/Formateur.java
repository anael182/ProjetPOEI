package fr.ibformation.projetEcoleFormation.bo;

import java.util.HashSet;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Formateur extends Utilisateur {
	//@NotBlank(message="Veuillez saisir une adresse")
	private String adresse;
	//@NotBlank(message="Veuillez saisir un code postal")
	//@Size(min = 5, max = 5)
	private String codePostal;
	//@NotBlank(message="Veuillez saisir un mot de passe")
	private String ville;
	
	
	@OneToMany(mappedBy = "formateur", cascade= CascadeType.ALL)
	@JsonManagedReference(value="evaluation-session-formateur")
	@JsonIgnore
	private Set <EvaluationFormateur> listeEvalFormateur = new HashSet<>();
	
	@OneToMany(mappedBy = "formateur", cascade= CascadeType.ALL)
	@JsonManagedReference(value="session-formation-formateur")
	@JsonIgnore
	private Set <SessionFormation> listeSessionFormation = new HashSet<>();
	
	public Formateur(String nom, String prenom, String mail, String mdp, String statut, String adresse, String codePostal, String ville) {
		super( nom,  prenom,  mail,  mdp,  statut);
		this.adresse = adresse;
		this.codePostal = codePostal;
		this.ville = ville;
	}
	
	public void addEvalFormateur(EvaluationFormateur evalFormateur) {
		this.listeEvalFormateur.add(evalFormateur);
		evalFormateur.setFormateur(this);
	}
	
	public void addSessionFormation(SessionFormation session) {
		this.listeSessionFormation.add(session);
		session.setFormateur(this);
	}
	
	@Override
	public String toString() {
		return "Formateur [adresse=" + adresse + ", codePostal=" + codePostal
				+ ", ville=" + ville + "]";
	}
	
	
	

}
