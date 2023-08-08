import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { CreditRiskService } from 'src/app/Services/credit-risk.service';

@Component({
  selector: 'app-credit-details',
  templateUrl: './credit-details.component.html',
  styleUrls: ['./credit-details.component.css']
})
export class CreditDetailsComponent {

  message:any;
  creditRiskDetails: any;
  constructor(private creditRiskServiceObj:CreditRiskService, private snackBar:MatSnackBar) {
    this.creditRiskServiceObj.fetchCreditRiskTableDetails().
    subscribe((data)=>{
      console.log(data);
      this.creditRiskDetails=data;
      if(this.creditRiskDetails.length > 0){
        this.message="Credit Details Found!!";
        this.openSnackBar();
      }
      else{
        this.message="No Credit Details Found!!"
        this.openSnackBar();
      }
    });
   }
  
  openSnackBar(){
    this.snackBar.open(this.message, 'close',{
      duration:3000,
      verticalPosition: 'top',
      horizontalPosition: 'center'
    })
  }

}
