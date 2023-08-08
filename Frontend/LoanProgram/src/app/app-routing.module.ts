import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './Components/home/home.component';
import { SanctionLoanAmountComponent } from './Components/sanction-loan-amount/sanction-loan-amount.component';
import { UpdateLoanApplicationComponent } from './Components/update-loan-application/update-loan-application.component';
import { ViewSpecificLoanApplicationComponent } from './Components/view-specific-loan-application/view-specific-loan-application.component';
import { CreditScoreComponent } from './Components/credit-score/credit-score.component';
import { AllLoanDetailsComponent } from './Components/all-loan-details/all-loan-details.component';
import { CreditDetailsComponent } from './Components/credit-details/credit-details.component';
// import { BasicCheckComponent } from './Components/basic-check/basic-check.component';
import { PullDateWiseLoanApplicationsComponent } from './Components/pull-date-wise-loan-applications/pull-date-wise-loan-applications.component';
import { AddLoanDetailsComponent } from './Components/add-loan-details/add-loan-details.component';

const routes: Routes = [
  {path:"",component:HomeComponent,pathMatch:"full"},
  {path:"all-loan-application",component:AllLoanDetailsComponent,pathMatch:"full"},
  {path:"upadte-loan",component:UpdateLoanApplicationComponent,pathMatch:"full"},
  {path:"view-specific",component:ViewSpecificLoanApplicationComponent,pathMatch:"full"},
  {path:"pull-by-date",component:PullDateWiseLoanApplicationsComponent,pathMatch:"full"},
  {path:"add-credit-details",component:CreditScoreComponent,pathMatch:"full"},
  {path:"show-creditrisk-details",component:CreditDetailsComponent,pathMatch:"full"},
  {path:"add-loan-details",component:AddLoanDetailsComponent,pathMatch:"full"}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
