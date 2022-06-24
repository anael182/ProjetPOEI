import { Component, OnInit } from '@angular/core';
import { Subscription } from 'rxjs';
import { Formation } from '../models/formation';
import { ApiformationsService } from '../services/apiformations.service';

@Component({
  selector: 'app-catalogue',
  templateUrl: './catalogue.component.html',
  styleUrls: ['./catalogue.component.scss']
})
export class CatalogueComponent implements OnInit {

  requestFormation : Subscription | undefined;

  formations : Formation [] = [];
  constructor(private apiformation: ApiformationsService) { }

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
    
  }
}
