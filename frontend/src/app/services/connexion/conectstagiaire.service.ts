import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ConectstagiaireService {

  private urlConnexionStagiaire: string = "http://localhost:8080/WS/session";
  private urlDeconnexion: string = "http://localhost:8080/WS/logout";

  constructor(private http : HttpClient) {}
  getConnexionStagiaires(): Observable<any>{
    return this.http.get(this.urlConnexionStagiaire);
  }

 
  getDeconnexionStagiaires(): Observable<any>{
    return this.http.get(this.urlDeconnexion);
  }
}
