export class Formateur {
    public idUtilisateur: number;
    public nom : string;
    public prenom : string;
    public mail : string;
    public mdp : string;
    public statut : string;
    public adresse : string;
    public codePostal : string;
    public ville : string;
    public listeEvalFormateur : any[];
    public listeSessionFormation: any[];
  
    

    constructor(idUtilisateur: number,nom: string, prenom:string,mail:string, mdp:string, statut:string,adresse: string, codePostal:string,
        ville:string,listeEvalFormateur: any[],listeSessionFormation: any[]){
        this.idUtilisateur=idUtilisateur;
        this.nom=nom;
        this.prenom=prenom;
        this.mail=mail;
        this.mdp=mdp;
        this.statut=statut;
        this.adresse=adresse;
        this.codePostal=codePostal;
        this.ville=ville;
        this.listeEvalFormateur=listeEvalFormateur;
        this.listeSessionFormation = listeSessionFormation;

    }
}
