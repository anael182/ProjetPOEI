import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Session } from 'src/app/models/session/session';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ApisessionService {
  private urlSession: string = "http://localhost:8080/WS/session-formation";

  constructor(private http : HttpClient) {}
  getSession(): Observable<any>{
    return this.http.get(this.urlSession);
  }

  getSessionById(id:string){
    return this.http.get(this.urlSession+"/"+id);
  }

  deletSessionById(id:string){
    return this.http.delete(this.urlSession+"/"+id);
  }

  adSession(session:Session){
    let httpOptionsCreate = {
      headers: new HttpHeaders({
        'Content-Type':  'application/json'
      })
    };
    return this.http.post<Session>(this.urlSession,session,httpOptionsCreate);
  }

  updateSession(session:Session){
    let httpOptionsCreate = {
      headers: new HttpHeaders({
        'Content-Type':  'application/json'
      })
    };
    return this.http.put<Session>(this.urlSession,session,httpOptionsCreate);
  }
}
