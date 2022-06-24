import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProfilstagiaireComponent } from './profilstagiaire.component';

describe('ProfilstagiaireComponent', () => {
  let component: ProfilstagiaireComponent;
  let fixture: ComponentFixture<ProfilstagiaireComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ProfilstagiaireComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ProfilstagiaireComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
