import { Component, OnInit } from '@angular/core';
import { ApiformationsService } from 'src/app/services/apiformations.service';
import { Subscription } from 'rxjs';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-detailformation',
  templateUrl: './detailformation.component.html',
  styleUrls: ['./detailformation.component.scss']
})
export class DetailformationComponent implements OnInit {
  requestFormation : Subscription | undefined;

  formation: any
  id: string = "";
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
   }

  ngOnInit(): void {
   
  }

}
