import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListestagiaireComponent } from './listestagiaire.component';

describe('ListestagiaireComponent', () => {
  let component: ListestagiaireComponent;
  let fixture: ComponentFixture<ListestagiaireComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListestagiaireComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ListestagiaireComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
