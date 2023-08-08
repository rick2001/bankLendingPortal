import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class CreditRiskService {
  urlLoanApp:any="http://localhost:8092/api/loanapps/all" // for fetching all the details of loan-app-id
  urlCreditRisk:any="http://localhost:8092/api/loanapps/creditrisk/add/"  //for posting data in creditrisk table
  constructor(private http:HttpClient) { }

  // addCreditDetails(id){
  //   return this.http.get();
  // }

  fetchLoanDetails(){   // fetching all the loanapp table details
    return this.http.get(this.urlLoanApp);
  }
  addNewCreditRisk(id:any,creditRisk:any){   //posting data to creditrisk table 
    return this.http.post(`${this.urlCreditRisk}${id}`,creditRisk);
  }

  fetchCreditRiskTableDetails(){  //fetch all details of creditrisk table
    return this.http.get("http://localhost:8092/api/loanapps/creditrisk/all");
  }

  urlBasicCheck="http://localhost:8092/api/loanapps/creditrisk/basiccheck/"
  basicCheckFind(id:any){
    return this.http.get(`${this.urlBasicCheck}${id}`);
  }


}
