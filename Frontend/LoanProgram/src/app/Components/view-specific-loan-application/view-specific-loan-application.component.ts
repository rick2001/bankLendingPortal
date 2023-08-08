import { HttpErrorResponse } from '@angular/common/http';
import { Component } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';
import { catchError, throwError } from 'rxjs';
import { LoanapplicationService } from 'src/app/Services/loanapplication.service';
import { MatSnackBar } from '@angular/material/snack-bar';

@Component({
  selector: 'app-view-specific-loan-application',
  templateUrl: './view-specific-loan-application.component.html',
  styleUrls: ['./view-specific-loan-application.component.css']
})
export class ViewSpecificLoanApplicationComponent {

  constructor(private loanAppObj: LoanapplicationService, private snackBar: MatSnackBar) { }

  flag: boolean = false;  //making it false by deafault
  message: any;   // message for error
  loanApplication: any;  // will store the loan app object by id
  SearchForm = new FormGroup({
    id: new FormControl('')
  });


  search(data: any) { //function to serach loan application by id
    // console.log(data);
    this.loanAppObj.searchById(data.id).subscribe((response) => {
      console.log(response);
      this.message = "Id Found! See Above the details.";
      this.loanApplication = response;  //storing the resonse
      this.flag = true;   // if the id is valid
      this.openSnackBar();
    },
      (error: HttpErrorResponse) => {
        if(error.status==404){
          this.message = "Error! This id doesn't exist";
          this.flag = false;
          this.openSnackBar(); //calling the snackbar
        }
      }
    );
  }




  openSnackBar() {   // created a snack bar which will show the error if doesnot exist
    this.snackBar.open(this.message, 'close', {
      duration:3000,
      verticalPosition: 'top',
      horizontalPosition: 'center'
    })
  }
}
