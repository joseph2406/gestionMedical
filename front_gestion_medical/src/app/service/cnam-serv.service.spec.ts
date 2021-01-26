import { TestBed } from '@angular/core/testing';

import { CnamServService } from './cnam-serv.service';

describe('CnamServService', () => {
  let service: CnamServService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CnamServService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
