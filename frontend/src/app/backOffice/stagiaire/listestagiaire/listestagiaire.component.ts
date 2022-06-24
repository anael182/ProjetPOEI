import { Component, OnInit } from '@angular/core';
import { Stagiaire } from 'src/app/models/stagiaire/stagiaire';
import { ApistagiaireService } from 'src/app/services/stagiaire/apistagiaire.service';
import {Router}  from '@angular/router';
import { Subscription } from 'rxjs';

@Component({
  selector: 'app-listestagiaire',
  templateUrl: './listestagiaire.component.html',
  styleUrls: ['./listestagiaire.component.scss']
})
export class ListestagiaireComponent implements OnInit {
  requestStagiaire: Subscription | undefined;
  id: string = "";
  stagiaires: Stagiaire[] = [];
  error: boolean = false;

  constructor(private apiStagiaire: ApistagiaireService,private route: Router ) { }

  ngOnInit(): void {
    this.requestStagiaire = this.apiStagiaire.getStagiaires().subscribe({
      next: (result: any) => {
        for (const iterator of result) {
          let stagiaire = new Stagiaire(iterator.idUtilisateur,iterator.nom, iterator.prenom,iterator.mail, iterator.mdp, iterator.statut,iterator.adresse, iterator.codePostal,
            iterator.ville,iterator.entreprise,iterator.listeEvalSession, iterator.listeEvalFormateur,iterator.listeSessionFormation);
          this.stagiaires.push(stagiaire);
          console.log(stagiaire);
        }
      },
      error: (err) => { console.error("Error : " + err); }
    });

  }

  onDeleteStagiaire(index: number) {
    if (confirm("Vous êtes sûr de vouloir supprimer définitivement cet élement!") == true) {
      this.id = index.toString();
      console.log(this.id);
      this.apiStagiaire.deleteStagiairesById(this.id).subscribe({
        next: (result: any) => {
          this.stagiaires.splice(index, 1);
          this.stagiaires = result;
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
  }

  redirect() {
    location.replace('http://localhost:8080/inscription-stagiaire/add')
}

}
