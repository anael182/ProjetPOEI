import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListeformateurComponent } from './listeformateur.component';

describe('ListeformateurComponent', () => {
  let component: ListeformateurComponent;
  let fixture: ComponentFixture<ListeformateurComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListeformateurComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ListeformateurComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
