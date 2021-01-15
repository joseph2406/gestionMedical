import { TestBed } from '@angular/core/testing';

import { AntecedantServService } from './antecedant-serv.service';

describe('AntecedantServService', () => {
  let service: AntecedantServService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AntecedantServService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
