import { Component, OnInit } from '@angular/core';
import { ApiformationsService } from '../services/apiformations.service';
import { Subscription } from 'rxjs';
import { Formation } from '../models/formation';


@Component({
  selector: 'app-page-accueil',
  templateUrl: './page-accueil.component.html',
  styleUrls: ['./page-accueil.component.scss']
})
export class PageAccueilComponent implements OnInit {

  requestFormation : Subscription | undefined;

  formations : Formation [] = [];
 
  constructor(private apiformation: ApiformationsService) {
   
   }

  ngOnInit(): void {
    console.log('ok');
    this.requestFormation =  this.apiformation.getFormations().subscribe({
      next: (result: any)=>{
        for (const iterator of result) {
          let formation = new Formation(iterator.idFormation ,iterator.nomDomaine, iterator.nomFormation,iterator.description,iterator.prix,iterator.nomThemeFormation,iterator.listeSousThemeFormation ,iterator.listeSessionFormation);
          this.formations.push(formation);
          console.log(formation);
        }
      },
      error:(err:any)=> {console.error("Error : "+ err); }
    });
  };

  ngAfterViewInit(){
   
  }

}
