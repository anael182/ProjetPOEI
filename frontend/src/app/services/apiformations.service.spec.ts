import { TestBed } from '@angular/core/testing';

import { ApiformationsService } from './apiformations.service';

describe('ApiformationsService', () => {
  let service: ApiformationsService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ApiformationsService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
