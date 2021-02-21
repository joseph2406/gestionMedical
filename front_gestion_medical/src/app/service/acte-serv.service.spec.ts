import { TestBed } from '@angular/core/testing';

import { ActeServService } from './acte-serv.service';

describe('ActeServService', () => {
  let service: ActeServService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ActeServService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
