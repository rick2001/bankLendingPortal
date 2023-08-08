import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AllLoanDetailsComponent } from './all-loan-details.component';

describe('AllLoanDetailsComponent', () => {
  let component: AllLoanDetailsComponent;
  let fixture: ComponentFixture<AllLoanDetailsComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AllLoanDetailsComponent]
    });
    fixture = TestBed.createComponent(AllLoanDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
