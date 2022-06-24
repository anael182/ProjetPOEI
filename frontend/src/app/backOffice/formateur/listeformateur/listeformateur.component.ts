import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Subscription } from 'rxjs';
import { Formateur } from 'src/app/models/formateur/formateur';
import { ApiformateurService } from 'src/app/services/formateur/apiformateur.service';

@Component({
  selector: 'app-listeformateur',
  templateUrl: './listeformateur.component.html',
  styleUrls: ['./listeformateur.component.scss']
})
export class ListeformateurComponent implements OnInit {
  requestStagiaire: Subscription | undefined;
  id: string = "";
  formateurs: Formateur[] = [];
  error: boolean = false;

  constructor(private route: Router, private apiformateur : ApiformateurService) { }

  ngOnInit(): void {
    this.requestStagiaire = this.apiformateur.getFormateurs().subscribe({
      next: (result: any) => {
        for (const iterator of result) {
          let formateur = new Formateur(iterator.idUtilisateur,iterator.nom, iterator.prenom,iterator.mail, iterator.mdp, iterator.statut,iterator.adresse, iterator.codePostal,
            iterator.ville,iterator.listeEvalFormateur, iterator.listeSessionFormation);
          this.formateurs.push(formateur);
          console.log(formateur);
        }
      },
      error: (err) => { console.error("Error : " + err); }
    });

  };

  onDeleteStagiaire(index: number) {
    if (confirm("Vous êtes sûr de vouloir supprimer définitivement cet élement!") == true) {
      this.id = index.toString();
      console.log(this.id);
      this.apiformateur.deleteFormateurById(this.id).subscribe({
        next: (result: any) => {
          this.formateurs.splice(index, 1);
          this.formateurs = result;
        },
        error: (error) => {
          console.error(error);
          this.error = true;
        }
      });
    }
  };

  onUpdateStagiaire(formateur : Formateur){
    this.route.navigate(["admin/formateur/udateFormateur/"+formateur.idUtilisateur]);
  }

  redirect() {
    location.replace('http://localhost:8080/inscription-formateur/add')
}


}
