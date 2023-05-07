package com.cts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.cts.entities.CreditRisk;
//import com.cts.entities.LoanApplication;
import com.cts.services.CreditRiskService;


@RestController
@RequestMapping("api/loanapps")
public class CreditRiskApplicationController {
	@Autowired
	private CreditRiskService creditRiskService;
	
	@GetMapping("creditrisk/all")
	public ResponseEntity<List<CreditRisk>> getListOfDetailsFromCreditRisk() {
		List<CreditRisk> res=this.creditRiskService.getAllDetails();
		return new ResponseEntity<>(res,HttpStatus.OK);
	}
	
	@PostMapping("creditrisk/add/{id}")
	public ResponseEntity<String> addDetailsToCreditRisk(@PathVariable String id  ,@RequestBody CreditRisk val){
//		String crid="CR"+val.getLoanApplication();
//		val.setCrId(crid);
		String res=this.creditRiskService.addDetails(id,val);
		if(res.equals("yes")) {
			return new ResponseEntity<>("Data has been inserted successfully",HttpStatus.CREATED);
		}
		else {
			return new ResponseEntity<>(res,HttpStatus.BAD_REQUEST);
		}
		
		
		
	}
	
}
