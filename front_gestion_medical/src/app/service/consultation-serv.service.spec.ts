import { TestBed } from '@angular/core/testing';

import { ConsultationServService } from './consultation-serv.service';

describe('ConsultationServService', () => {
  let service: ConsultationServService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ConsultationServService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
