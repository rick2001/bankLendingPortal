import { HttpErrorResponse } from '@angular/common/http';
import { Component, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';
import { LoanapplicationService } from 'src/app/Services/loanapplication.service';

@Component({
  selector: 'app-add-loan-details',
  templateUrl: './add-loan-details.component.html',
  styleUrls: ['./add-loan-details.component.css']
})
export class AddLoanDetailsComponent {
  constructor (private loanApplicationServiceObj:LoanapplicationService, private snackBar:MatSnackBar) {}

  @ViewChild('loanForm') loanForm!: NgForm;
  message:any;
  data:any={
    loanAppId:"",
    custId:"",
    birthDate:"",
    loanAmt:"",
    noOfYears:"",
    purpose:"",
    appStatus:"new_loan",
    typeOfLoan:"",
    status:"no_status"
  }
  addLoanDetails(){  // adding loan details
    console.log("Ready to add..");
    this.loanApplicationServiceObj.addLoanDetails(this.data).subscribe((response)=>{
      console.log(response);
      this.message="Data added successfully!";
      this.openSnackBar();
      this.loanForm.resetForm();

    },(error:HttpErrorResponse)=>{
      if(error.status==400){
        this.message="This Loanapp Id already Exists! Try different loan id";
        this.openSnackBar();
      }
    })

  }
  openSnackBar(){
    this.snackBar.open(this.message,'close',{
      duration:3000,
      verticalPosition: 'top',
      horizontalPosition: 'center'
    })
  }


}
