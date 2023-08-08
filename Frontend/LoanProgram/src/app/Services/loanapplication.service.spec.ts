import { TestBed } from '@angular/core/testing';

import { LoanapplicationService } from './loanapplication.service';

describe('LoanapplicationService', () => {
  let service: LoanapplicationService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(LoanapplicationService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
