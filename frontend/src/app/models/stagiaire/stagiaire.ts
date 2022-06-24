import { Entreprise } from "../entreprise/entreprise";

export class Stagiaire {
    public idUtilisateur: number;
    public nom : string;
    public prenom : string;
    public mail : string;
    public mdp : string;
    public statut : string;
    public adresse : string;
    public codePostal : string;
    public ville : string;
    public entreprise : Entreprise;
    public listeEvalSession : any[];
    public listeEvalFormateur: any[];
    public listeSessionFormation: any[];
    

    constructor(idUtilisateur: number,nom: string, prenom:string,mail:string, mdp:string, statut:string,adresse: string, codePostal:string,
        ville:string,entreprise:Entreprise,listeEvalSession: any[], listeEvalFormateur: any[],listeSessionFormation: any[]){
        this.idUtilisateur=idUtilisateur;
        this.nom=nom;
        this.prenom=prenom;
        this.mail=mail;
        this.mdp=mdp;
        this.statut=statut;
        this.adresse=adresse;
        this.codePostal=codePostal;
        this.ville=ville;
        this.entreprise=entreprise
        this.listeEvalSession=listeEvalSession;
        this.listeEvalFormateur=listeEvalFormateur;
        this.listeSessionFormation = listeSessionFormation;

    }
}
