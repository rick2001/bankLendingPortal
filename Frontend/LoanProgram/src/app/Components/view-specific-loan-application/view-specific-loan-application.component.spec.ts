import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewSpecificLoanApplicationComponent } from './view-specific-loan-application.component';

describe('ViewSpecificLoanApplicationComponent', () => {
  let component: ViewSpecificLoanApplicationComponent;
  let fixture: ComponentFixture<ViewSpecificLoanApplicationComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ViewSpecificLoanApplicationComponent]
    });
    fixture = TestBed.createComponent(ViewSpecificLoanApplicationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
