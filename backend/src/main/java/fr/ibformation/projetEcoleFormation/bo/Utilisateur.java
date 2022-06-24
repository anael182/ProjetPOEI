package fr.ibformation.projetEcoleFormation.bo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.web.context.annotation.SessionScope;

@Entity
@Data
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)

public abstract class Utilisateur {
	@Id
	@GeneratedValue
	private Integer idUtilisateur;
	//@NotBlank(message="Veuillez saisir un nom")
	private String nom;
	//@NotBlank(message="Veuillez saisir un prénom")
	private String prenom;
	//@NotBlank(message="Veuillez une adresse mail")
	private String mail;
	//@NotBlank(message="Veuillez saisir un mot de passe")
	//@Size(min=6, max=30)
	private String mdp;
	private String statut;
		
	
	public Utilisateur(String nom, String prenom, String mail, String mdp, String statut) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.mail = mail;
		this.mdp = mdp;
		this.statut = statut;
	}
	@Override
	public String toString() {
		return "Utilisateur [idUtilisateur=" + idUtilisateur + ", nom=" + nom + ", prenom=" + prenom + ", mail=" + mail
				+ ", mdp=" + mdp + ", statut=" + statut + "]";
	}
	
	
	
	
	
	

}
