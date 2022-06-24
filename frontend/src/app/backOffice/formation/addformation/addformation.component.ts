import { Component, OnInit } from '@angular/core';
import { Formation } from 'src/app/models/formation';
import { ApiformationsService } from 'src/app/services/apiformations.service';
import {NgForm} from '@angular/forms';

@Component({
  selector: 'app-addformation',
  templateUrl: './addformation.component.html',
  styleUrls: ['./addformation.component.scss']
})
export class AddformationComponent {

  public formation:Formation = new Formation(1, "", "", "", 0, "", [], []);
  public messageErreur:string="";
  public messageOK : string=""
  constructor(private apiformation: ApiformationsService ) { }

  createFormation(){
    this.apiformation.addFormation(this.formation).subscribe({
      next:(data:Formation)=>{
        this.messageOK = "Formation ajouter avec succés";
      },
      error:(error)=>{
        console.error(error);
        this.messageErreur=error.message+error.error;
      }
    })
    
  }

  onFrmSubmit(f:NgForm) {
    
      f.resetForm();
    }
  onResetForm(f:NgForm){
    f.resetForm();
  }

}
