import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Subscription } from 'rxjs';
import { Stagiaire } from '../models/stagiaire/stagiaire';
import { ConectstagiaireService } from '../services/connexion/conectstagiaire.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent implements OnInit {
  requestFormation : Subscription | undefined;
  stagiaire : any;
  isConnected = true;
  constructor(private apiconnexionstagiaire : ConectstagiaireService,private route: Router) {}

  ngOnInit(): void {
    this.requestFormation = this.apiconnexionstagiaire.getConnexionStagiaires().subscribe({
      next: (result: any) => {
       console.log(result);
       console.log("okok");
       
       
       this.stagiaire = result;
       console.log("this.stagiaire = "+this.stagiaire);
      if(this.stagiaire == null){
        this.isConnected = false;
      }else{
        this.isConnected = true;
      }
      console.log("this.isConnected = "+this.isConnected);
      
          console.log("connected :"+this.stagiaire.statut);
      
      }
    })
  }

  connexion(){
    location.replace("http://localhost:8080/login/stagiaire");
  }

  deconnexion(){
    this.apiconnexionstagiaire.getDeconnexionStagiaires().subscribe({
      next: (result: any) => {}
  });
  this.isConnected = false;
  location.reload();
  location.replace("http://localhost:4200/page-accueil");
  }

  profilStagiaire(id : any){
    this.route.navigate(["profil/stagiaire/"+id]);
  }
}
