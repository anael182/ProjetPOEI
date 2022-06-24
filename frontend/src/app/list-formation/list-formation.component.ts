import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ApiformationsService } from '../services/apiformations.service';

@Component({
  selector: 'app-list-formation',
  templateUrl: './list-formation.component.html',
  styleUrls: ['./list-formation.component.scss']
})
export class ListFormationComponent  {
  
  @Input()
  formation: any
  id: string = "";
  public messageErreur:string="";
  public messageOK : string=""
  error: boolean = false;

  constructor(private activatedRoute: ActivatedRoute,private apiformation: ApiformationsService) { 
    this.id = this.activatedRoute.snapshot.params['id'];
    
    if(this.id != undefined){
      //console.log(this.id);
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
 

}
