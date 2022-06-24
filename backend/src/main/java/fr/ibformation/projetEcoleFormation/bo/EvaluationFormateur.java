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
public class EvaluationFormateur {
	@Id
	@GeneratedValue
	private Integer idEvalFormateur;
	private Integer notePedagogie;
	private Integer noteMaitriseDomaine;
	private Integer noteDisponibilite;
	private Integer noteReponsesQuestions;
	private Integer noteTechniqueAnimation;
	private Double noteMoyenneFormateur;
	
	@ManyToOne
	@JsonBackReference(value="evaluation-session-formateur")
	private Formateur formateur;
	
	@ManyToOne
	@JsonBackReference(value="formateur-evaluation-stagiaire")
	private Stagiaire stagiaire;
	
	@ManyToOne
	@JsonBackReference(value="evaluation-formateur")
	private SessionFormation sessionFormation;
	
	public EvaluationFormateur(Integer notePedagogie, Integer noteMaitriseDomaine, Integer noteDisponibilite,

			Integer noteReponsesQuestions, Integer noteTechniqueAnimation) {
		super();
		this.notePedagogie = notePedagogie;
		this.noteMaitriseDomaine = noteMaitriseDomaine;
		this.noteDisponibilite = noteDisponibilite;
		this.noteReponsesQuestions = noteReponsesQuestions;
		this.noteTechniqueAnimation = noteTechniqueAnimation;
		this.noteMoyenneFormateur = (double) ((notePedagogie+noteMaitriseDomaine+noteDisponibilite+noteReponsesQuestions+noteTechniqueAnimation)/5);
	}

	@Override
	public String toString() {
		return "EvaluationFormateur [idEvalFormateur=" + idEvalFormateur + ", notePedagogie=" + notePedagogie
				+ ", noteMaitriseDomaine=" + noteMaitriseDomaine + ", noteDisponibilite=" + noteDisponibilite
				+ ", noteReponsesQuestions=" + noteReponsesQuestions + ", noteTechniqueAnimation="
				+ noteTechniqueAnimation + ", noteMoyenneFormateur=" + noteMoyenneFormateur + "]";
	}
	
	
	
	
	
	

}
