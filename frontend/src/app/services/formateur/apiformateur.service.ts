import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Formateur } from 'src/app/models/formateur/formateur';
@Injectable({
  providedIn: 'root'
})
export class ApiformateurService {

  private urlFormateur: string = "http://localhost:8080/WS/formateur";

  constructor(private http : HttpClient) {}
  getFormateurs(): Observable<any>{
    return this.http.get(this.urlFormateur);
  }

  getFormateurById(id:string){
    return this.http.get(this.urlFormateur+"/"+id);
  }

  deleteFormateurById(id:string){
    return this.http.delete(this.urlFormateur+"/"+id);
  }

  addFormateur(formateur:Formateur){
    let httpOptionsCreate = {
      headers: new HttpHeaders({
        'Content-Type':  'application/json'
      })
    };
    return this.http.post<Formateur>(this.urlFormateur,formateur,httpOptionsCreate);
  }

  updateFormateur(formateur:Formateur){
    let httpOptionsCreate = {
      headers: new HttpHeaders({
        'Content-Type':  'application/json'
      })
    };
    return this.http.put<Formateur>(this.urlFormateur,formateur,httpOptionsCreate);
  }
}
