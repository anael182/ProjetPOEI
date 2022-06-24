import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListeFComponent } from './liste-f.component';

describe('ListeFComponent', () => {
  let component: ListeFComponent;
  let fixture: ComponentFixture<ListeFComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListeFComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ListeFComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
