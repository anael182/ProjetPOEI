export class Formation {
    public idFormation: number;
    public nomDomaine : string;
    public nomFormation : string;
    public description : string;
    public prix : number;
    public nomThemeFormation : string;
    public listeSousThemeFormation : any[];
    public listeSessionFormation: any[];
    

    constructor(idFormation: number,nomDomaine: string, nomFormation:string,description:string, prix:number,nomThemeFormation: string,listeSousThemeFormation: any[], listeSessionFormation: any[]){
        this.idFormation = idFormation
        this.nomDomaine = nomDomaine;
        this.nomFormation = nomFormation;
        this.description = description;
        this.prix = prix;
        this.nomThemeFormation = nomThemeFormation;
        this.listeSousThemeFormation = listeSousThemeFormation;
        this.listeSessionFormation = listeSessionFormation;

    }

}
