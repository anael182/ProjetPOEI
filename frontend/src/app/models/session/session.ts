import { Entreprise } from "../entreprise/entreprise";
import { Formation } from "../formation";
import { Stagiaire } from "../stagiaire/stagiaire";

export class Session {
    public idSession: number;
    public dateDebut : Date;
    public dateFin : Date;
    public typeFormation : string;
    public salleInstallee : boolean;
	public formateurConfirme : boolean;
	public supportImprime : boolean;
	public convocationEnvoyee : boolean;
	public planningMisAjour : boolean;
	public listePresenceImprimee : boolean;
	public ticketRepasImprime : boolean;
	public formulaireEvalGenere : boolean;
    public formation: any;
    public salleFormation : any;
    public formateur : any;
    public entreprise : Entreprise;
    public listeStagiaires : Stagiaire[];
    public evalSession: any;
    
    constructor(  idSession: number,dateDebut : Date,dateFin : Date,typeFormation : string,salleInstallee : boolean,formateurConfirme : boolean,
         supportImprime : boolean,convocationEnvoyee : boolean,planningMisAjour : boolean,listePresenceImprimee : boolean,ticketRepasImprime : boolean,
         formulaireEvalGenere : boolean,formation: any,salleFormation : any,formateur : any,entreprise : Entreprise,listeStagiaires : Stagiaire[],evalSession: any){
        this.idSession=idSession;
        this.dateDebut=dateDebut;
        this.dateFin=dateFin;
        this.typeFormation=typeFormation;
        this.salleInstallee=salleInstallee
        this.formateurConfirme=formateurConfirme;
        this.supportImprime=supportImprime;
        this.convocationEnvoyee=convocationEnvoyee;
        this.planningMisAjour=planningMisAjour;
        this.listePresenceImprimee=listePresenceImprimee;
        this.ticketRepasImprime=ticketRepasImprime;
        this.formulaireEvalGenere=formulaireEvalGenere;
        this.formation=formation;
        this.salleFormation=salleFormation;
        this.formateur=formateur;
        this.entreprise=entreprise;
        this.listeStagiaires=listeStagiaires;
        this.evalSession=evalSession;

    }
}
