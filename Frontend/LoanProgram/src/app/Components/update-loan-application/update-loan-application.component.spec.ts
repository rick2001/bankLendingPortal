import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateLoanApplicationComponent } from './update-loan-application.component';

describe('UpdateLoanApplicationComponent', () => {
  let component: UpdateLoanApplicationComponent;
  let fixture: ComponentFixture<UpdateLoanApplicationComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [UpdateLoanApplicationComponent]
    });
    fixture = TestBed.createComponent(UpdateLoanApplicationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
