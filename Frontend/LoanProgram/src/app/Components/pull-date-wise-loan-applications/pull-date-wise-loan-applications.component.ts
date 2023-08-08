import { Component } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';
import { catchError, throwError } from 'rxjs';
import { LoanapplicationService } from 'src/app/Services/loanapplication.service';
import { MatSnackBar } from '@angular/material/snack-bar';
import { HttpErrorResponse } from '@angular/common/http';
@Component({
  selector: 'app-pull-date-wise-loan-applications',
  templateUrl: './pull-date-wise-loan-applications.component.html',
  styleUrls: ['./pull-date-wise-loan-applications.component.css']
})
export class PullDateWiseLoanApplicationsComponent {
  
  constructor (private loanapplicationServiceObj:LoanapplicationService, private snackBar:MatSnackBar) {}
  flag:boolean=false;
  loanApplications:any;
  message:any;

  SearchForm = new FormGroup({
    date: new FormControl('')
  });

  searchByDate(dateData:any){
    this.loanapplicationServiceObj.getAllLoanAppDetailsByDate(dateData.date).
    pipe(catchError((error:HttpErrorResponse)=>{
      if (error.status == 404) {
        this.message = "Error! This date doesn't contain any loan details";
        this.flag = false;
        this.openSnackBar(); //calling the snackbar
      }
      return throwError(error);
    })
      ).subscribe((resonse)=>{
        console.log(this.loanApplications)
      this.loanApplications=resonse;
      this.flag=true;
    })
  }
  openSnackBar() {   // created a snack bar which will show the error if doesnot exist
    this.snackBar.open(this.message, 'close', {
      duration: 3000,
      verticalPosition: 'top',
      horizontalPosition: 'center'
    })
  }
  
}
