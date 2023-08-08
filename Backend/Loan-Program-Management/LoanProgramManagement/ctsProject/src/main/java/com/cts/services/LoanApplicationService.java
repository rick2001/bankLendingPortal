package com.cts.services;
import java.time.LocalDate;
import java.util.*;

import com.cts.entities.LoanApplication;
import com.cts.exceptions.IdNotFoundException;
public interface LoanApplicationService {
	
	//all the data details
	public List<LoanApplication> getAllDetails();
	
	// get the data based on date
	public List<LoanApplication> getListDateBasedResult (LocalDate date);
	
	//get data based on id
	public LoanApplication getOnedetailBasedOnId(String id) throws IdNotFoundException;
	
	//adding the Loan details
	public LoanApplication addLoanDetails(LoanApplication val) throws IdNotFoundException;
	
	//updating the Loan details
	public LoanApplication updateLoanDetails(LoanApplication value) throws IdNotFoundException; 
	
	

}