import { TestBed } from '@angular/core/testing';

import { ConectstagiaireService } from './conectstagiaire.service';

describe('ConectstagiaireService', () => {
  let service: ConectstagiaireService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ConectstagiaireService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
