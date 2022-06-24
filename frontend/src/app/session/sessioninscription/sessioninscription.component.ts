import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ApiformationsService } from 'src/app/services/apiformations.service';
import { ConectstagiaireService } from 'src/app/services/connexion/conectstagiaire.service';
import { ApisessionService } from 'src/app/services/session/apisession.service';

@Component({
  selector: 'app-sessioninscription',
  templateUrl: './sessioninscription.component.html',
  styleUrls: ['./sessioninscription.component.scss']
})
export class SessioninscriptionComponent implements OnInit {
  session: any;
  formation : any;
  id: string = "";
  idSession :string = "";
  idFormation: string = "";
  idStagiaire: string = "";
  stagiaire : any;
  error: boolean = false;
  
  constructor(private activatedRoute: ActivatedRoute, private apiSession: ApisessionService, private apiformation: ApiformationsService, private apiconnexionstagiaire : ConectstagiaireService ) {
    this.id = this.activatedRoute.snapshot.params['id'];
    
    if(this.id != undefined){  
      this.apiSession.getSessionById(this.id).subscribe({
        next: (data) => {
          this.session = data;
          console.log(this.session);   
        },
        error: (error) => {
          console.error(error);
          this.error = true;
        }
      });
    };
   };

   //=== ajouter le stagaire à une session ==========
   addStagiaireToSession(){
    
   
    this.id = this.activatedRoute.snapshot.params['id'];
    console.log("id session ="+this.id);
    
    this.apiformation.addStagiaireToSession(this.id, this.idStagiaire).subscribe({
      next: (data:any) => {
        this.session = data;
        console.log("session ajouter = "+this.session);
      },
      error: (error) => {
        console.error(error);
        this.error = true;
      }
    });

    location.replace("http://localhost:4200/profil/stagiaire/"+this.idStagiaire);

   }
   

  ngOnInit(): void {
    this.idFormation = this.activatedRoute.snapshot.params['idFormation'];
    if(this.idFormation != undefined){
      this.apiformation.getFormationById(this.idFormation).subscribe({
        next: (data) => {
          this.formation = data;
          console.log(this.formation);
          
        },
        error: (error) => {
          console.error(error);
          this.error = true;
        }
      });

    };
    this.apiconnexionstagiaire.getConnexionStagiaires().subscribe({
      next: (result: any) => {
       console.log(result);
       console.log("okok");
       this.stagiaire = result;
       this.idStagiaire = this.stagiaire.idUtilisateur;
          console.log("id stagiaire :"+this.idStagiaire);
      }
    });

 
  }

}
