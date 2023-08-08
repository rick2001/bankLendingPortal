import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class LoanapplicationService {
url1="http://localhost:8092/api/loanapps/view/"
  constructor(private http:HttpClient) { }

  urlAddLoanDetails="http://localhost:8092/api/loanapps/add"
  addLoanDetails(data:any){
    return this.http.post(this.urlAddLoanDetails,data);
  }

  searchById(id:any){   //serrching specific loan details by id
    return this.http.get(`${this.url1}${id}`);
  }
  getAllDetails(){  // finding all the loan details present in table
    return this.http.get("http://localhost:8092/api/loanapps/all");
  }

  url2="http://localhost:8092/api/loanapps/pull/"
  getAllLoanAppDetailsByDate(date:any){      // getting list of loan details based on date
    return this.http.get(`${this.url2}${date}`);
  }

  urlUpdateLoanDetails="http://localhost:8092/api/loanapps/update/"
  upDateLoanDeatils(id:any,data:any){
    return this.http.put(`${this.urlUpdateLoanDetails}${id}`,data);
  }
}
