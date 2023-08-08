import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SanctionLoanAmountComponent } from './sanction-loan-amount.component';

describe('SanctionLoanAmountComponent', () => {
  let component: SanctionLoanAmountComponent;
  let fixture: ComponentFixture<SanctionLoanAmountComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [SanctionLoanAmountComponent]
    });
    fixture = TestBed.createComponent(SanctionLoanAmountComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
