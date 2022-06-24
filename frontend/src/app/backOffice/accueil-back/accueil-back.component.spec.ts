import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AccueilBackComponent } from './accueil-back.component';

describe('AccueilBackComponent', () => {
  let component: AccueilBackComponent;
  let fixture: ComponentFixture<AccueilBackComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AccueilBackComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AccueilBackComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
