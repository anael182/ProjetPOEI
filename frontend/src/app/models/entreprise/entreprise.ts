import { Stagiaire } from "../stagiaire/stagiaire";

export class Entreprise {
    public idEntrepriseClient: number;
    public nomEntreprise : string;
    public adresse : string;
    public codePostal : string;
    public ville : string;
    public listeStagiaires : Stagiaire[];
    public listeSessionFormation: any[];
    

    constructor(idEntrepriseClient: number,nomEntreprise: string, adresse: string, codePostal:string,
        ville:string,listeStagiaires : Stagiaire[],listeSessionFormation: any[]){
        this.idEntrepriseClient=idEntrepriseClient;
        this.nomEntreprise=nomEntreprise;
        this.adresse=adresse;
        this.codePostal=codePostal;
        this.ville=ville;
        this.listeStagiaires=listeStagiaires;
        this.listeSessionFormation = listeSessionFormation;

    }
}
