import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AccueilBackComponent } from './backOffice/accueil-back/accueil-back.component';
import { ListeformateurComponent } from './backOffice/formateur/listeformateur/listeformateur.component';
import { UpdateformateurComponent } from './backOffice/formateur/updateformateur/updateformateur.component';
import { AddformationComponent } from './backOffice/formation/addformation/addformation.component';
import { ListeFComponent } from './backOffice/formation/liste-f/liste-f.component';
import { UpdateformationComponent } from './backOffice/formation/updateformation/updateformation.component';
import { AddstagiaireComponent } from './backOffice/stagiaire/addstagiaire/addstagiaire.component';
import { ListestagiaireComponent } from './backOffice/stagiaire/listestagiaire/listestagiaire.component';
import { UpdateStagiaireComponent } from './backOffice/stagiaire/update-stagiaire/update-stagiaire.component';
import { CatalogueComponent } from './catalogue/catalogue.component';
import { ContactComponent } from './contact/contact.component';
import { DetailformationComponent } from './formation/detailformation/detailformation.component';
import { ListFormationComponent } from './list-formation/list-formation.component';
import { PageAccueilComponent } from './page-accueil/page-accueil.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { ProfilstagiaireComponent } from './profilstagiaire/profilstagiaire/profilstagiaire.component';
import { SessioninscriptionComponent } from './session/sessioninscription/sessioninscription.component';

const routes: Routes = [
  {path: 'page-accueil', component: PageAccueilComponent },
  {path: '', redirectTo: 'page-accueil', pathMatch: 'full'},
  {path: 'catalogue', component: CatalogueComponent },
  {path: 'formation/:id', component: DetailformationComponent },
  {path: 'liste-formation', component: ListFormationComponent },
  {path: 'contact', component: ContactComponent },
  {path: 'session/inscription/:id/:idFormation', component: SessioninscriptionComponent },
  {path: 'admin', component: AccueilBackComponent },
  {path: 'admin/formation/liste', component: ListeFComponent },
  {path: 'admin/formation/ajouter', component: AddformationComponent },
  {path: 'admin/formation/udateformation/:id', component: UpdateformationComponent },
  {path: 'admin/stagiaire/liste', component: ListestagiaireComponent },
  {path: 'admin/stagiaire/ajouter', component: AddstagiaireComponent },
  {path: 'profil/stagiaire/:id', component: ProfilstagiaireComponent },
  {path: 'admin/stagiaire/udateStagiaire/:id', component: UpdateStagiaireComponent },
  {path: 'admin/formateur/liste', component: ListeformateurComponent },
  {path: 'admin/formateur/udateFormateur/:id', component: UpdateformateurComponent },
  {path: '**', component: PageNotFoundComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
