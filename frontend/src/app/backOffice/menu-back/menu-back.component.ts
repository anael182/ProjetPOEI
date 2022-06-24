import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-menu-back',
  templateUrl: './menu-back.component.html',
  styleUrls: ['./menu-back.component.scss']
})
export class MenuBackComponent implements OnInit {

  constructor() { }

  noteFormateurRedirect(){
    location.replace("http://localhost:8080/admin/note-experience-formateur");
  }

  mesTachesRedirect(){
    location.replace("http://localhost:8080/admin/mes-taches");
  }

  listeSessions(){
    location.replace("http://localhost:8080/admin/liste-des-sessions");
  }

  ngOnInit(): void {
  }

}
