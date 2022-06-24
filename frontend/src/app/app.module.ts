import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { PageAccueilComponent } from './page-accueil/page-accueil.component';
import { ContactComponent } from './contact/contact.component';
import { CatalogueComponent } from './catalogue/catalogue.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { FormsModule } from '@angular/forms';

import { HttpClientModule } from '@angular/common/http';
import { ListFormationComponent } from './list-formation/list-formation.component';

import { MenuBackComponent } from './backOffice/menu-back/menu-back.component';
import { ListeFComponent } from './backOffice/formation/liste-f/liste-f.component';
import { AddformationComponent } from './backOffice/formation/addformation/addformation.component';
import { UpdateformationComponent } from './backOffice/formation/updateformation/updateformation.component';
import { ListestagiaireComponent } from './backOffice/stagiaire/listestagiaire/listestagiaire.component';
import { AddstagiaireComponent } from './backOffice/stagiaire/addstagiaire/addstagiaire.component';
import { DetailformationComponent } from './formation/detailformation/detailformation.component';
import { SessioninscriptionComponent } from './session/sessioninscription/sessioninscription.component';
import { AccueilBackComponent } from './backOffice/accueil-back/accueil-back.component';
import { ListeformateurComponent } from './backOffice/formateur/listeformateur/listeformateur.component';
import { UpdateformateurComponent } from './backOffice/formateur/updateformateur/updateformateur.component';
import { UpdateStagiaireComponent } from './backOffice/stagiaire/update-stagiaire/update-stagiaire.component';
import { ProfilstagiaireComponent } from './profilstagiaire/profilstagiaire/profilstagiaire.component';



@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    PageAccueilComponent,
    ContactComponent,
    CatalogueComponent,
    PageNotFoundComponent,
    ListFormationComponent,
    AccueilBackComponent,
    MenuBackComponent,
    ListeFComponent,
    AddformationComponent,
    UpdateformationComponent,
    ListestagiaireComponent,
    AddstagiaireComponent,
    DetailformationComponent,
    SessioninscriptionComponent,
    ListeformateurComponent,
    UpdateformateurComponent,
    UpdateStagiaireComponent,
    ProfilstagiaireComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
