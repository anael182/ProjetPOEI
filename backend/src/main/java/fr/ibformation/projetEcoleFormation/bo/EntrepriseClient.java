package fr.ibformation.projetEcoleFormation.bo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class EntrepriseClient {
	@Id
	@GeneratedValue
	private Integer idEntrepriseClient;
	private String nomEntreprise;
	private String adresse;
	private String codePostal;
	private String ville;
	
	@OneToMany(mappedBy = "entreprise")
	@JsonManagedReference
	@JsonIgnore
	private Set <Stagiaire> listeStagiaires = new HashSet<>();
	
	@OneToMany(mappedBy = "entreprise")
	@JsonManagedReference
	@JsonIgnore
	private Set <SessionFormation> listeSessionsFormation = new HashSet<>();
	
	public EntrepriseClient(String nomEntreprise, String adresse, String codePostal, String ville) {
		super();
		this.nomEntreprise = nomEntreprise;
		this.adresse = adresse;
		this.codePostal = codePostal;
		this.ville = ville;
	}
	
	public void addStagiaire(Stagiaire stagiaire) {
		this.listeStagiaires.add(stagiaire);
		stagiaire.setEntreprise(this);
	}
	
	public void addSessionFormation(SessionFormation session) {
		this.listeSessionsFormation.add(session);
		session.setEntreprise(this);
	}
	
	@Override
	public String toString() {
		return "EntrepriseClient [idEntrepriseClient=" + idEntrepriseClient + ", nomEntreprise=" + nomEntreprise
				+ ", adresse=" + adresse + ", codePostal=" + codePostal + ", ville=" + ville + "]";
	}
	
	

}
