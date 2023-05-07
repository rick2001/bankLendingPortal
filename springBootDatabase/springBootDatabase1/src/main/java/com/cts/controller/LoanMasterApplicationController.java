package com.cts.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.*;

import com.cts.entities.CreditRisk;
import com.cts.entities.LoanApplication;
import com.cts.services.CreditRiskService;
import com.cts.services.LoanApplicationService;
import com.cts.services.impl.LoanApplicationServiceImpl;

@RestController
@RequestMapping("api/loanapps")
public class LoanMasterApplicationController {
//	//get all the loan details
	@Autowired
	private LoanApplicationService loanApplicationService;

	// fetching all the data present in the table
	@GetMapping("all")
	public ResponseEntity<List<LoanApplication>> getAllLoanDetails() {
		List<LoanApplication> res = this.loanApplicationService.getAllDetails();
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	// part of testing
	// fetching list of applications based on date
	@GetMapping("pull/{date}")
	public ResponseEntity<List<LoanApplication>> getListOfDetailsBasedOnDate(
			@PathVariable("date") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
		List<LoanApplication> res = this.loanApplicationService.getDateBasedResult(date);
		if (res.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(res, HttpStatus.OK);

		}

	}

	// part of testing
	// fetching only one specific Loan Application details based on id
	@GetMapping("view/{id}")
	public ResponseEntity<LoanApplication> getSingleDetailsBasedOnId(@PathVariable String id) {
		LoanApplication res = this.loanApplicationService.getOnedetail(id);
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	// add loan details
	@PostMapping("add")
	public ResponseEntity<LoanApplication> addDetailsToLoanAppTable(@RequestBody LoanApplication val) {
//			CreditRisk data=val.getCreditRisk();
		LoanApplication res = this.loanApplicationService.addDetails(val);
//			String output=this.creditRiskService.addDetails(data);
		return new ResponseEntity<>(res, HttpStatus.CREATED);
	}

	// part of unit testing
	// update loan details based on id
	@PutMapping("update/{id}")
	public ResponseEntity<String> updateLoanDetails(@PathVariable String id, @RequestBody LoanApplication val) {
		val.setLoanAppId(id);
//			val.setLoanAppId(id);
		LoanApplication res = this.loanApplicationService.updatedetails(val);
		if (res == null) {
			return new ResponseEntity<>("Id not found", HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<>("Your data has been updated successfully", HttpStatus.OK);

		}

	}

	// demo project
	@PostMapping("loanapp/add")
	public ResponseEntity<String> addDetailsDemo() {
		String res = this.loanApplicationService.addLoanAll();
		return new ResponseEntity<>(res, HttpStatus.OK);

	}

	// delete loan details
}