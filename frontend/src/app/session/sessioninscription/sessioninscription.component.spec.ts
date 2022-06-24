import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SessioninscriptionComponent } from './sessioninscription.component';

describe('SessioninscriptionComponent', () => {
  let component: SessioninscriptionComponent;
  let fixture: ComponentFixture<SessioninscriptionComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SessioninscriptionComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SessioninscriptionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
