package fr.ibformation.projetEcoleFormation.bo;


import java.util.HashSet;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
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
public class Formation {
	@Id
	@GeneratedValue
	private Integer idFormation;
	private String nomDomaine;
	private String nomFormation;
	private String description;
	private Integer prix;
	private String nomThemeFormation;
	
	@ManyToMany(mappedBy = "listeFormations")
	@JsonIgnore
	Set <SousThemeFormation> listeSousThemeFormation = new HashSet<>();
	
	@OneToMany(mappedBy = "formation")
	@JsonManagedReference(value="session-formation")
	@JsonIgnore
	Set <SessionFormation> listeSessionFormation = new HashSet<>();
	
	public Formation(String nomDomaine, String nomFormation, String description, Integer prix,
			String nomThemeFormation) {
		super();
		this.nomDomaine = nomDomaine;
		this.nomFormation = nomFormation;
		this.description = description;
		this.prix = prix;
		this.nomThemeFormation = nomThemeFormation;
	}
	

	public void addSousThemeFormation(SousThemeFormation sousThemeFormation) {
		this.listeSousThemeFormation.add(sousThemeFormation);
		sousThemeFormation.getListeFormations().add(this);
	}
	
	
	public void addSessionFormation(SessionFormation session) {
		this.listeSessionFormation.add(session);
		session.setFormation(this);
	}


	@Override
	public String toString() {
		return "Formation [idFormation=" + idFormation + ", nomDomaine=" + nomDomaine + ", nomFormation=" + nomFormation
				+ ", description=" + description + ", prix=" + prix + ", nomThemeFormation=" + nomThemeFormation + "]";
	}
	
	

}
