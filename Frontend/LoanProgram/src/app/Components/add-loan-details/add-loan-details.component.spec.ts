import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddLoanDetailsComponent } from './add-loan-details.component';

describe('AddLoanDetailsComponent', () => {
  let component: AddLoanDetailsComponent;
  let fixture: ComponentFixture<AddLoanDetailsComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AddLoanDetailsComponent]
    });
    fixture = TestBed.createComponent(AddLoanDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
