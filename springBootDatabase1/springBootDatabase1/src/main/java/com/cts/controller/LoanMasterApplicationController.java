package com.cts.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;

import com.cts.entities.LoanApplication;
import com.cts.services.LoanApplicationService;



@RestController
@RequestMapping("/api/loanapps/")
public class LoanMasterApplicationController {
	//get all the loan details
	private LoanApplicationService loanApplicationService;
	
	@GetMapping("all")
	public ResponseEntity<List<LoanApplication>> getAll(){
		List<LoanApplication> res=this.loanApplicationService.getAllDetails();
		return new ResponseEntity<>(res,HttpStatus.OK);
	}
	
	//get only one loan detail
	
	// add loan details
	
	//update loan details
	
	//delete loan details
}
