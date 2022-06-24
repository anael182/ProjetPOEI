import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ApistagiaireService } from 'src/app/services/stagiaire/apistagiaire.service';

@Component({
  selector: 'app-update-stagiaire',
  templateUrl: './update-stagiaire.component.html',
  styleUrls: ['./update-stagiaire.component.scss']
})
export class UpdateStagiaireComponent implements OnInit {

  stagiaire: any
  id: string = "";
  error: boolean = false;
  messageOK : string = "";
  messageErreur :string ="";

  constructor(private activatedRoute: ActivatedRoute, private apiStagiaire : ApistagiaireService) { 
    this.id = this.activatedRoute.snapshot.params['id'];
    
    if(this.id != undefined){
      this.apiStagiaire.getStagiaireById(this.id).subscribe({
        next: (data) => {
          this.stagiaire = data;
        },
        error: (error) => {
          console.error(error);
          this.error = true;
        }
      });

    }

  };
  updateStagiaire(){
    this.apiStagiaire.updateFormation(this.stagiaire).subscribe({
      next:(data:any)=>{
        this.messageOK = "Stagiaire modifié avec succés";
      },
      error:(error)=>{
        console.error(error);
        this.messageErreur=error.message+error.error;
      }
    })

  }

  ngOnInit(): void {
  }

}
