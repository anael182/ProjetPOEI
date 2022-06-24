package fr.ibformation.projetEcoleFormation.bo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;


import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class SousThemeFormation {
	@Id
	@GeneratedValue
	private Integer idSousTheme;
	private String nomSousTheme;
	
	@ManyToMany
	@JsonBackReference(value="soustheme-formation")
	private Set <Formation> listeFormations = new HashSet<>();

	public SousThemeFormation(String nomSousTheme) {
		super();
		this.nomSousTheme = nomSousTheme;
	}
	
	public void addFormation(Formation formation) {
		this.listeFormations.add(formation);
		formation.getListeSousThemeFormation().add(this);
	}

	@Override
	public String toString() {
		return "SousThemeFormation [idSousTheme=" + idSousTheme + ", nomSousTheme=" + nomSousTheme+"]";
	}
	
		
}
