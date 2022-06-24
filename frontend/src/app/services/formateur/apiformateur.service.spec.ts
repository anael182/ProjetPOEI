import { TestBed } from '@angular/core/testing';

import { ApiformateurService } from './apiformateur.service';

describe('ApiformateurService', () => {
  let service: ApiformateurService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ApiformateurService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
