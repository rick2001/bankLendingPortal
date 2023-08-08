import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PullDateWiseLoanApplicationsComponent } from './pull-date-wise-loan-applications.component';

describe('PullDateWiseLoanApplicationsComponent', () => {
  let component: PullDateWiseLoanApplicationsComponent;
  let fixture: ComponentFixture<PullDateWiseLoanApplicationsComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [PullDateWiseLoanApplicationsComponent]
    });
    fixture = TestBed.createComponent(PullDateWiseLoanApplicationsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
