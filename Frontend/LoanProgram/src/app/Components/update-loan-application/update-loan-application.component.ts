import { Component } from '@angular/core';
import { LoanapplicationService } from 'src/app/Services/loanapplication.service';
import { FormGroup, FormControl } from '@angular/forms';
import { catchError, throwError } from 'rxjs';
import { HttpErrorResponse } from '@angular/common/http';
import { CreditRiskService } from 'src/app/Services/credit-risk.service';
import {MatSnackBar} from '@angular/material/snack-bar';
@Component({
  selector: 'app-update-loan-application',
  templateUrl: './update-loan-application.component.html',
  styleUrls: ['./update-loan-application.component.css']
})
export class UpdateLoanApplicationComponent {
  // 1. first we will fetch the data only if it is a new loan.
  // 2.then we will perform the basic check (weather its passed or failed. bydefault it will be pending).
  // 3. if passed so banked will update the loan details as "updated" else banker will update it as "rejected".

  constructor(private loanApplicationServiceObj: LoanapplicationService, private creditRiskServiceObj:CreditRiskService, private snackBar:MatSnackBar) { };

  
  // creting a form where we will store the data so that we can send all during update operation
  loanDetailsForm=new FormGroup({
    loanAppId:new FormControl(''),
    custId:new FormControl(''),
    birthDate:new FormControl(''),
    loanAmt:new FormControl(''),
    noOfYears:new FormControl(''),
    purpose:new FormControl(''),
    appStatus:new FormControl(''),
    typeOfLoan:new FormControl(''),
    loanAppDate:new FormControl(''),
    status:new FormControl('')
  });


  statusFlag:boolean=false;
  flag: boolean = false;  //making it false by deafault
  message: any;   // message for error
  loanApplicationObj: any;  // will store the loan app object by id
  SearchForm = new FormGroup({  //creating a from to store
    id: new FormControl('')
  });

  basicCheck:any;  

  search(data:any){
    this.loanApplicationServiceObj.searchById(data.id).
    subscribe((response)=>{
      console.log(response);
      this.loanApplicationObj=response;
      if(this.loanApplicationObj.appStatus=='new_loan'){
        console.log(this.loanApplicationObj.appStatus);
        this.message="Id Found! Check Basic Details"
        this.flag=true;
        this.openSnackBar();
        this.loanDetailsForm.patchValue({
          loanAppId:this.loanApplicationObj.loanAppId,
          custId:this.loanApplicationObj.custId,
          birthDate:this.loanApplicationObj.birthDate,
          loanAmt:this.loanApplicationObj.loanAmt,
          noOfYears:this.loanApplicationObj.noOfYears,
          purpose:this.loanApplicationObj.purpose,
          appStatus:this.loanApplicationObj.appStatus,
          typeOfLoan:this.loanApplicationObj.typeOfLoan,
          loanAppDate:this.loanApplicationObj.loanAppDate,
          status:this.loanApplicationObj.status,
        });
      }
      else{
        this.message="Loan Details already updated!"
        this.openSnackBar();
        
      }
    },(error:HttpErrorResponse)=>{
      if(error.status==404){
        console.log(error);
        this.message="Error! This id doesn't exist";
        this.flag=false;
        this.openSnackBar();
      }
    });
  }



  //updating the loan application weather its accepted or rejected and Sanctioned or cancelled
  // updateLoanAppication(data:any){
  //   console.log(data);
  //   this.loanApplicationServiceObj.upDateLoanDeatils(data.loanAppId,data).subscribe(
  //     (response)=>{
  //       console.log(response);
  //       this.message="Loan Application Updated.."
  //       this.flag=true;
  //       this.openSnackBar();
  //     },
  //   (error:HttpErrorResponse)=>{
  //     console.log(error);
  //   })
  // }


  updateLoanAppication(data:any){   
    console.log(data);
    this.loanApplicationServiceObj.upDateLoanDeatils(data.loanAppId,data).
    pipe(catchError((error:HttpErrorResponse)=>{
      if(error.status==202){  //success
        this.message="Loan Application Updated.."
        this.flag=true;
        this.openSnackBar();
      }
      return throwError(error);
    }))
    .subscribe();

  }

  btnflag:boolean=true;
  doBasicCheck(){   //beform basic check before updating the application
      this.creditRiskServiceObj.basicCheckFind(this.loanDetailsForm.value.loanAppId).pipe(
        catchError((error:HttpErrorResponse)=>{
          if(error.status==200){
            this.message=error.error.message;
            this.message="Basic Check !Pass!";
            this.statusFlag=true;
            this.btnflag=false;
            this.openSnackBar();
          }else{
            this.statusFlag=true;
            this.flag=true;
            this.btnflag=false;
            this.message="Basic check failed. Application rejected!";
            this.openSnackBar();
          }
          return throwError(error)
        })
      ).subscribe();
  }

  

  //creating a snackbar service
  openSnackBar(){   
    this.snackBar.open(this.message,'Close',{
      duration:3000,
      verticalPosition: 'top',
      horizontalPosition: 'center'
    })
  }


}
