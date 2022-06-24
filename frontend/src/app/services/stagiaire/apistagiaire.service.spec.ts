import { TestBed } from '@angular/core/testing';

import { ApistagiaireService } from './apistagiaire.service';

describe('ApistagiaireService', () => {
  let service: ApistagiaireService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ApistagiaireService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
