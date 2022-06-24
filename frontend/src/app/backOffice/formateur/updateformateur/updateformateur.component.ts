import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ApiformateurService } from 'src/app/services/formateur/apiformateur.service';

@Component({
  selector: 'app-updateformateur',
  templateUrl: './updateformateur.component.html',
  styleUrls: ['./updateformateur.component.scss']
})
export class UpdateformateurComponent implements OnInit {
 
  formateur: any
  id: string = "";
  error: boolean = false;
  messageOK : string = "";
  messageErreur :string ="";

  constructor(private activatedRoute: ActivatedRoute, private apiformateur : ApiformateurService) { 
    this.id = this.activatedRoute.snapshot.params['id'];
    
    if(this.id != undefined){
      this.apiformateur.getFormateurById(this.id).subscribe({
        next: (data) => {
          this.formateur = data;
        },
        error: (error) => {
          console.error(error);
          this.error = true;
        }
      });

    }

  };
  updateFormateur(){
    this.apiformateur.updateFormateur(this.formateur).subscribe({
      next:(data:any)=>{
        this.messageOK = "Formateur modifié avec succés";
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
