package com.cts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.entities.CreditRisk;
import com.cts.services.CreditRiskService;


@RestController
@CrossOrigin
@RequestMapping("api/loanapps")
public class CreditRiskApplicationController {
	// creating a object of service class
		@Autowired
		private CreditRiskService creditRiskService;
		
		
		//getting all the details of credit-risk table
		@GetMapping("creditrisk/all")
		public ResponseEntity<List<CreditRisk>> getListOfDetailsFromCreditRisk() {
			List<CreditRisk> res=this.creditRiskService.getAllDetailsOfCreditRisk();
			return new ResponseEntity<>(res,HttpStatus.OK);
		}
		
		// adding the details to credit-risk table. (This part is being done from administrator side)
		@PostMapping("creditrisk/add/{id}")
		public ResponseEntity<String> addDetailsToCreditRisk(@PathVariable String id  ,@RequestBody CreditRisk val){
			String res=this.creditRiskService.addCreditRiskDetails(id,val);
			if(res.equals("yes")) {
				return new ResponseEntity<>("Loan Details has been updated",HttpStatus.OK);
			}
			else {
				return new ResponseEntity<>(res,HttpStatus.BAD_REQUEST);
			}	
		}
		
		
		@GetMapping("creditrisk/basiccheck/{id}")
		public ResponseEntity<String> basicCheck(@PathVariable String id){
			return this.creditRiskService.doingBasicChecking(id);
		}
	
}
