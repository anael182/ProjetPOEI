import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Stagiaire } from 'src/app/models/stagiaire/stagiaire';

@Injectable({
  providedIn: 'root'
})
export class ApistagiaireService {

  private urlStagiaire: string = "http://localhost:8080/WS/stagiaire";
  private urlSessionFromStagiaire: string = "http://localhost:8080/WS/stagiaire-session";

  constructor(private http : HttpClient) {}

  getSessionForStagiaireById(id:string){
    return this.http.get(this.urlSessionFromStagiaire+"/"+id);
  }

  getStagiaires(): Observable<any>{
    return this.http.get(this.urlStagiaire);
  }

  getStagiaireById(id:string){
    return this.http.get(this.urlStagiaire+"/"+id);
  }

  deleteStagiairesById(id:string){
    return this.http.delete(this.urlStagiaire+"/"+id);
  }

  addStagiaires(stagiaire:Stagiaire){
    let httpOptionsCreate = {
      headers: new HttpHeaders({
        'Content-Type':  'application/json'
      })
    };
    return this.http.post<Stagiaire>(this.urlStagiaire,stagiaire,httpOptionsCreate);
  }

  updateFormation(stagiaire:Stagiaire){
    let httpOptionsCreate = {
      headers: new HttpHeaders({
        'Content-Type':  'application/json'
      })
    };
    return this.http.put<Stagiaire>(this.urlStagiaire,stagiaire,httpOptionsCreate);
  }
}
