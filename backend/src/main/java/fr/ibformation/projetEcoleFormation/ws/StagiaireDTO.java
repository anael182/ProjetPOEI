package fr.ibformation.projetEcoleFormation.ws;

import javax.validation.constraints.NotBlank;

import fr.ibformation.projetEcoleFormation.bo.EntrepriseClient;
import fr.ibformation.projetEcoleFormation.bo.Stagiaire;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StagiaireDTO {

	@NotBlank(message = "Champs Nom vide")
	private String nom;
	@NotBlank(message = "Champs Prénom vide")
	private String prenom;
	@NotBlank(message =  "Champs Mail vide")
	private String mail;
	@NotBlank(message =  "Champs Mot de Passe vide")
	private String mdp;
	@NotBlank(message =  "Champs Adresse vide")
	private String adresse;
	@NotBlank(message =  "Champs Code Postal vide")
	private String codePostal;
	@NotBlank(message =  "Champs Ville vide")
	private String ville;
	private String statut;
	@NotBlank(message =  "Champs Nom Entreprise vide")
	private String nomEntreprise;
	@NotBlank(message =  "Champs Adresse Entreprise vide")
	private String adresseEntreprise;
	@NotBlank(message =  "Champs Code Postal Entreprise vide")
	private String codePostalEntreprise;
	@NotBlank(message =  "Champs Ville Entreprise vide")
	private String villeEntreprise;
	
	public StagiaireDTO(Stagiaire stagiaire) {
		this.nom = stagiaire.getNom();
		this.prenom = stagiaire.getPrenom();
		this.mail = stagiaire.getMail();
		this.mdp = stagiaire.getMdp();
		this.adresse = stagiaire.getAdresse();
		this.codePostal = stagiaire.getCodePostal();
		this.ville = stagiaire.getVille();
		this.statut = stagiaire.getStatut();
		this.nomEntreprise = stagiaire.getEntreprise().getNomEntreprise();
		this.adresseEntreprise = stagiaire.getEntreprise().getAdresse();
		this.codePostalEntreprise = stagiaire.getEntreprise().getCodePostal();
		this.villeEntreprise = stagiaire.getEntreprise().getVille();
	}
	
	public Stagiaire toStagiaire() {
		Stagiaire stagiaire = new Stagiaire();
		stagiaire.setNom(this.nom);
		stagiaire.setPrenom(this.prenom);
		stagiaire.setMail(this.mail);
		stagiaire.setMdp(this.mdp);
		stagiaire.setAdresse(this.adresse);
		stagiaire.setCodePostal(this.codePostal);
		stagiaire.setVille(this.ville);
		stagiaire.setStatut(this.statut);
		return stagiaire;
	}
	
	public EntrepriseClient toEntreprise() {
		EntrepriseClient entreprise = new EntrepriseClient();
		entreprise.setNomEntreprise(this.nomEntreprise);
		entreprise.setAdresse(this.adresseEntreprise);
		entreprise.setCodePostal(this.codePostalEntreprise);
		entreprise.setVille(this.villeEntreprise);
		return entreprise;
	}
	
}
