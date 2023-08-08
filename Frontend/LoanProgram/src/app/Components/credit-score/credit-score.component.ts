import { Component } from '@angular/core';
import { CreditRiskService } from 'src/app/Services/credit-risk.service';
import { FormGroup, FormControl } from '@angular/forms';
import { catchError, throwError } from 'rxjs';
import { HttpErrorResponse } from '@angular/common/http';
import { MatSnackBar } from '@angular/material/snack-bar';

@Component({
  selector: 'app-credit-score',
  templateUrl: './credit-score.component.html',
  styleUrls: ['./credit-score.component.css']
})
export class CreditScoreComponent {
  CreditRiskForm = new FormGroup({
    loanApplication: new FormGroup({
      loanAppId: new FormControl('')
    }),
    creditScore: new FormControl(''),
    emi: new FormControl(''),
    basicCheck: new FormControl('pending')
  });

  loanApps: any;
  message: any;
  constructor(private creditObj: CreditRiskService, private snackBar: MatSnackBar) {
    this.creditObj.fetchLoanDetails().subscribe((response) => {
      console.log(response);
      this.loanApps = response;
    })
  }
  submitData(data: any) {
    console.log(data.loanApplication.loanAppId);
    console.warn(data);
    this.creditObj.addNewCreditRisk(data.loanApplication.loanAppId, data).pipe(
      catchError((error: HttpErrorResponse) => {
        if (error.status == 200) {
          this.message = "Credit Details Added!";
          this.openSnackBar(); //calling the snackbarss
          this.CreditRiskForm.patchValue({
            creditScore: '',
            emi: '',
            basicCheck: 'pending',
            loanApplication: {
              loanAppId: ''
            }
          });

        }
        return throwError(error);
      })
    ).subscribe();
  }
  openSnackBar() {   // created a snack bar which will show the error if doesnot exist
    this.snackBar.open(this.message, 'close', {
      duration: 3000,
      verticalPosition: 'top',
      horizontalPosition: 'center'
    })
  }

}
