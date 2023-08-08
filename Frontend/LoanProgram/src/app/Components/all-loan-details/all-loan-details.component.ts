import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { LoanapplicationService } from 'src/app/Services/loanapplication.service';

@Component({
  selector: 'app-all-loan-details',
  templateUrl: './all-loan-details.component.html',
  styleUrls: ['./all-loan-details.component.css']
})
export class AllLoanDetailsComponent {

  message:any;
  loanAppDetails: any;
  constructor(private loanAppObj: LoanapplicationService, private snackBar:MatSnackBar) {
    this.loanAppObj.getAllDetails()
      .subscribe((data) => {
        console.log(data);
        this.loanAppDetails=data;
        if(this.loanAppDetails.length > 0){
          this.message="Details Found"
          this.openSnackBar();
        }
        else{
          this.message="No Details Found!!"
          this.openSnackBar();
        }
      });

  }
 
  openSnackBar(){
    this.snackBar.open(this.message, 'close', {
      duration:3000,
      verticalPosition: 'top',
      horizontalPosition: 'center'
    })
  }
}
