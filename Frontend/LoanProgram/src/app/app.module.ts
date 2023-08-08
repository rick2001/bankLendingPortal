import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HomeComponent } from './Components/home/home.component';
import { NavbarComponent } from './Components/navbar/navbar.component';
import { SanctionLoanAmountComponent } from './Components/sanction-loan-amount/sanction-loan-amount.component';
import { CreditScoreComponent } from './Components/credit-score/credit-score.component';
import { UpdateLoanApplicationComponent } from './Components/update-loan-application/update-loan-application.component';
import { ViewSpecificLoanApplicationComponent } from './Components/view-specific-loan-application/view-specific-loan-application.component';
import {MatIconModule} from '@angular/material/icon';
import {MatButtonModule} from '@angular/material/button';
import {MatToolbarModule} from '@angular/material/toolbar';
import{FormsModule} from '@angular/forms';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatInputModule} from '@angular/material/input';
import { MatSnackBar, MatSnackBarModule } from '@angular/material/snack-bar';
import { MatNativeDateModule } from '@angular/material/core';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { MatSelectModule } from '@angular/material/select';
import { MatRadioModule } from '@angular/material/radio';
import { ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { LoanapplicationService } from './Services/loanapplication.service';
import { CreditRiskService } from './Services/credit-risk.service';
import { AllLoanDetailsComponent } from './Components/all-loan-details/all-loan-details.component';
import { CreditDetailsComponent } from './Components/credit-details/credit-details.component';

import { PullDateWiseLoanApplicationsComponent } from './Components/pull-date-wise-loan-applications/pull-date-wise-loan-applications.component';
import { FooterComponent } from './Components/footer/footer.component';
import { AddLoanDetailsComponent } from './Components/add-loan-details/add-loan-details.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    NavbarComponent,
    SanctionLoanAmountComponent,
    CreditScoreComponent,
    UpdateLoanApplicationComponent,
    ViewSpecificLoanApplicationComponent,
    AllLoanDetailsComponent,
    CreditDetailsComponent,
    PullDateWiseLoanApplicationsComponent,
    FooterComponent,
    AddLoanDetailsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatButtonModule,
    MatIconModule,MatToolbarModule,
    FormsModule,
    MatFormFieldModule,
    MatSnackBarModule,
    MatInputModule,
    MatNativeDateModule,
    MatDatepickerModule,
    MatSelectModule,
    MatRadioModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [MatSnackBar,LoanapplicationService,CreditRiskService],
  bootstrap: [AppComponent]
})
export class AppModule { }
