import { Component,Input, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ApiformationsService } from 'src/app/services/apiformations.service';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-updateformation',
  templateUrl: './updateformation.component.html',
  styleUrls: ['./updateformation.component.scss']
})
export class UpdateformationComponent implements OnInit {
  @Input()
  formation: any
  id: string = "";
  error: boolean = false;
  messageOK : string = "";
  messageErreur :string ="";


  constructor(private activatedRoute: ActivatedRoute,private apiformation: ApiformationsService) { 
    this.id = this.activatedRoute.snapshot.params['id'];
    
    if(this.id != undefined){
      this.apiformation.getFormationById(this.id).subscribe({
        next: (data) => {
          this.formation = data;
        },
        error: (error) => {
          console.error(error);
          this.error = true;
        }
      });

    }

  };
  updateFormation(){
    this.apiformation.updateFormation(this.formation).subscribe({
      next:(data:any)=>{
        this.messageOK = "Formation modifié avec succés";
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
