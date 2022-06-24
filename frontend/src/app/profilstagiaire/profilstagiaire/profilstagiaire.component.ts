import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Session } from 'src/app/models/session/session';
import { Stagiaire } from 'src/app/models/stagiaire/stagiaire';
import { ApistagiaireService } from 'src/app/services/stagiaire/apistagiaire.service';

@Component({
  selector: 'app-profilstagiaire',
  templateUrl: './profilstagiaire.component.html',
  styleUrls: ['./profilstagiaire.component.scss']
})
export class ProfilstagiaireComponent implements OnInit {
  stagiaire: any;
  sessions : Session [] = [];
  id: string = "";
  error: boolean = false;
  messageOK : string = "";
  messageErreur :string ="";

  constructor(private activatedRoute: ActivatedRoute, private apiStagiaire : ApistagiaireService,private route: Router) { 
    this.id = this.activatedRoute.snapshot.params['id'];
    if(this.id != undefined){
      this.apiStagiaire.getStagiaireById(this.id).subscribe({
        next: (data:any) => {
          console.log(data);
          this.stagiaire = data;
          console.log(this.stagiaire);
          
          
        },
        
        error: (error) => {
          console.error(error);
          this.error = true;
        }
      });

    } 
    
  };
  onUpdateStagiaire(stagiaire : Stagiaire){
    this.route.navigate(["admin/stagiaire/udateStagiaire/"+stagiaire.idUtilisateur]);
  };

  

  ngOnInit(): void {
    this.id = this.activatedRoute.snapshot.params['id'];
    if(this.id != undefined){
      this.apiStagiaire.getSessionForStagiaireById(this.id).subscribe({
        next: (data:any) => {
          console.log(data);
          for (const iterator of data) {
            let session = new Session(iterator.idSession, iterator.dateDebut, iterator.dateFin, iterator.typeFormation, iterator.salleInstallee, iterator.formateurConfirme, iterator.supportImprime, iterator.convocationEnvoyee, iterator.planningMisAjour, iterator.listePresenceImprimee, iterator.ticketRepasImprime, iterator.formulaireEvalGenere, iterator.formation, iterator.salleFormation, iterator.formateur, iterator.entreprise, iterator.listeStagiaires, iterator.evalSession);
            this.sessions.push(session);
            console.log(session);
          }
         
        },
        error: (error) => {
          console.error(error);
          this.error = true;
        }
      });

    }
     
  };
  redirectEvalSession(){
    location.replace("http://localhost:8080/evaluation-formation/add/"+this.sessions[0].idSession);
  }

}
