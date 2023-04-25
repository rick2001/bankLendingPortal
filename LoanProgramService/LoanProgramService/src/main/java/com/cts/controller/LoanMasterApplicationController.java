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
import java.util.*;

import com.cts.entities.LoanApplication;
import com.cts.services.LoanApplicationService;
import com.cts.services.impl.LoanApplicationServiceImpl;



@RestController
@RequestMapping("api/loanapps")
public class LoanMasterApplicationController {
//	//get all the loan details
	@Autowired
	private LoanApplicationService loanApplicationService;
	
	
	//fetching all the data present in the table
	@GetMapping("all")
	public ResponseEntity<List<LoanApplication>> getAll(){
		List<LoanApplication> res=this.loanApplicationService.getAllDetails();
		return new ResponseEntity<>(res,HttpStatus.OK);
	}
	
	// fetching all the data based on date
	@GetMapping("pull/{date}")
	public ResponseEntity<List<LoanApplication>> getDetails(@PathVariable("date") @DateTimeFormat(pattern="yyyy-MM-dd") Date date){
		List<LoanApplication> res=this.loanApplicationService.getDateBasedResult(date);
		if(res.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		else {
			return new ResponseEntity<>(res, HttpStatus.OK);
			
		}
		
	}
	
	//fetching only one based on id
	@GetMapping("{id}")
	public ResponseEntity<LoanApplication> getOne(@PathVariable String id){
		LoanApplication res=this.loanApplicationService.getOnedetail(id);
		return new ResponseEntity<>(res,HttpStatus.OK);
	}
	// add loan details
	@PostMapping("add")
	public ResponseEntity<LoanApplication> details(@RequestBody LoanApplication val){
		LoanApplication res=this.loanApplicationService.addDetails(val);
		return new ResponseEntity<>(res,HttpStatus.CREATED);
	}
	
	//update loan details
	@PutMapping("update/{id}")
	public ResponseEntity<String> updating(@PathVariable String id, @RequestBody LoanApplication val){
		val.setLoanApplicationId(id);
		LoanApplication res=this.loanApplicationService.updatedetails(val);
		if(res==null) {
			return new ResponseEntity<>("Id not found",HttpStatus.BAD_REQUEST);
		}
		else {
			return new ResponseEntity<>("Your data has been updated successfully",HttpStatus.OK);
			
		}
			
	}
	//delete loan details
}