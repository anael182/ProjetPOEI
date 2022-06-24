import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddstagiaireComponent } from './addstagiaire.component';

describe('AddstagiaireComponent', () => {
  let component: AddstagiaireComponent;
  let fixture: ComponentFixture<AddstagiaireComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddstagiaireComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AddstagiaireComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
