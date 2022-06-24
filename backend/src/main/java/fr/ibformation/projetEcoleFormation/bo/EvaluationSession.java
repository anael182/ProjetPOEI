package fr.ibformation.projetEcoleFormation.bo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class EvaluationSession {
	@Id
	@GeneratedValue
	private Integer idEvalSession;
	private Integer noteAccueil;
	private Integer noteEnvironnement;
	private Integer noteContenuFormation;
	private String niveauSatisfaction;
	private Boolean recommandationFormation;
	private Boolean autresProjetsFormations;
	
	@ManyToOne
	@JsonBackReference(value="evaluation-session-stagiaire")
	private Stagiaire stagiaire;
	
	@ManyToOne
	@JsonBackReference(value="evaluation-session")
	private SessionFormation sessionFormation;
	
	public EvaluationSession(Integer noteAccueil, Integer noteEnvironnement,
			Integer noteContenuFormation, String niveauSatisfaction, Boolean recommandationFormation,
			Boolean autresProjetsFormations) {
		super();
		this.noteAccueil = noteAccueil;
		this.noteEnvironnement = noteEnvironnement;
		this.noteContenuFormation = noteContenuFormation;
		this.niveauSatisfaction = niveauSatisfaction;
		this.recommandationFormation = recommandationFormation;
		this.autresProjetsFormations = autresProjetsFormations;
	}

	@Override
	public String toString() {
		return "EvaluationSession [idEvalSession=" + idEvalSession + ", noteAccueil=" + noteAccueil
				+ ", noteEnvironnement=" + noteEnvironnement + ", noteContenuFormation=" + noteContenuFormation
				+ ", niveauSatisfaction=" + niveauSatisfaction + ", recommandationFormation=" + recommandationFormation
				+ ", autresProjetsFormations=" + autresProjetsFormations + ", stagiaire=" + stagiaire + "]";
	}

	
}
