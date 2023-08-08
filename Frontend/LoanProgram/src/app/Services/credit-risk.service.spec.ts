import { TestBed } from '@angular/core/testing';

import { CreditRiskService } from './credit-risk.service';

describe('CreditRiskService', () => {
  let service: CreditRiskService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CreditRiskService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
