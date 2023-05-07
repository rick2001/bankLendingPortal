package com.cts.services;
import java.time.LocalDate;
import java.util.*;

import com.cts.entities.LoanApplication;
public interface LoanApplicationService {
	
	//all the data details
	public List<LoanApplication> getAllDetails();
	
	// get the data based on date
	public List<LoanApplication> getDateBasedResult(LocalDate date);
	
	//get data based on id
	public LoanApplication getOnedetail(String id);
	
	//adding the details
	public LoanApplication addDetails(LoanApplication val);
	
	//updating the details
	public LoanApplication updatedetails(LoanApplication value); 
	
	//just a demo of adding
	public String addLoanAll();
	
		
	

}