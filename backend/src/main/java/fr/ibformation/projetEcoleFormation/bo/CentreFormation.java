package fr.ibformation.projetEcoleFormation.bo;

import java.util.HashSet;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class CentreFormation {
	@Id
	@GeneratedValue
	private Integer idCentreFormation;
	private String nom;
	private String adresse;
	private String codePostal;
	private String ville;
	
	@OneToMany(mappedBy = "centreFormation")
	@JsonManagedReference(value="salle-centre")
	private Set <SalleFormation> listeSalleFormation = new HashSet<>();
	

	public CentreFormation(String nom, String adresse, String codePostal, String ville) {
		super();
		this.nom = nom;
		this.adresse = adresse;
		this.codePostal = codePostal;
		this.ville = ville;
	}

	public void addSalleFormation(SalleFormation salle) {
		this.listeSalleFormation.add(salle);
		salle.setCentreFormation(this);
	}

	@Override
	public String toString() {
		return "CentreFormation [idCentreFormation=" + idCentreFormation + ", nom=" + nom + ", adresse=" + adresse
				+ ", codePostal=" + codePostal + ", ville=" + ville + "]";
	}
	

}
