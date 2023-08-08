package com.cts.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.entities.LoanApplication;
import com.cts.exceptions.IdNotFoundException;
import com.cts.services.LoanApplicationService;

@RestController
@CrossOrigin
@RequestMapping("api/loanapps")
public class LoanMasterApplicationController {
	// creating a object of service class
		@Autowired
		private LoanApplicationService loanApplicationService;

		// fetching all the data present in the table
		@GetMapping("all")
		public ResponseEntity<List<LoanApplication>> getAllLoanDetails() {
			List<LoanApplication> res = this.loanApplicationService.getAllDetails();
			return new ResponseEntity<>(res, HttpStatus.OK);
		}

		// part of testing
		// fetching list of applications based on date  //done exception handling
		@GetMapping("pull/{date}")
		public ResponseEntity<List<LoanApplication>> getListOfDetailsBasedOnDate(
				@PathVariable("date") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) throws IdNotFoundException {
			List<LoanApplication> res = this.loanApplicationService.getListDateBasedResult(date);
			if (res.isEmpty()) {
		        throw new IdNotFoundException("No data Found of this Date");
			} else {
				return new ResponseEntity<>(res, HttpStatus.OK);

			}

		}

		// part of testing
		// fetching only one specific Loan Application details based on id
		@GetMapping("view/{id}")
		public ResponseEntity<LoanApplication> getSingleDetailsBasedOnId(@PathVariable String id) { //done exception handling
			LoanApplication res = this.loanApplicationService.getOnedetailBasedOnId(id);
			return new ResponseEntity<>(res,HttpStatus.OK); //200-found
			
		}

		// add loan details
		@PostMapping("add")
		public ResponseEntity<LoanApplication> addDetailsToLoanAppTable(@RequestBody LoanApplication val) {
			LoanApplication res = this.loanApplicationService.addLoanDetails(val);
			return new ResponseEntity<>(res,HttpStatus.CREATED);

		}

		// part of unit testing
		// update loan details based on id
		@PutMapping("update/{id}")
		public ResponseEntity<String> updateDetailsOfLoan(@PathVariable String id, @RequestBody LoanApplication val) {
			val.setLoanAppId(id);
			LoanApplication res = this.loanApplicationService.updateLoanDetails(val);
			return new ResponseEntity<>("Your data has been updated successfully", HttpStatus.ACCEPTED); //202


		}

	
}
