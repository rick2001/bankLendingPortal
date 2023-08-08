package com.cts.services.impl;

import java.util.ArrayList;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.dao.CreditRiskDao;
import com.cts.dao.LoanApplicationDao;
import com.cts.entities.CreditRisk;
import com.cts.entities.LoanApplication;
import com.cts.exceptions.BadRequestFoundException;
import com.cts.exceptions.IdNotFoundException;
import com.cts.services.LoanApplicationService;


@Service
public class LoanApplicationServiceImpl implements LoanApplicationService {
	@Autowired
	private LoanApplicationDao ccDao1;
	
	public LoanApplicationServiceImpl(LoanApplicationDao ccDao1) {
		this.ccDao1 = ccDao1;
	}

	//get all the list of loan details
	@Override
	public List<LoanApplication> getAllDetails() {
		return ccDao1.findAll();
	}
	

	// fetching only one specific Loan Application details based on id
	@Override
	public LoanApplication getOnedetailBasedOnId(String id) {
		Optional<LoanApplication> response=ccDao1.findById(id);
		LoanApplication value;
		if(!response.isEmpty()) {
			value=response.get();
			System.out.println(value);
			return value;
		}
		else {
			throw new IdNotFoundException("This id doesnot exists");
		}
		
	}

	// adding loan details in the table
	@Override
	public LoanApplication addLoanDetails(LoanApplication val) {
		String id=val.getLoanAppId();
		Optional<LoanApplication> response=ccDao1.findById(id);
		if(response.isEmpty()) {
			val.setLoanAppDate(LocalDate.now());
			val.setAppStatus("new_loan");
			val.setStatus("no_status");
			ccDao1.save(val);
			return val;
		}
		else {
			throw new BadRequestFoundException("This id is already present");
		}
	}

	// get the list of data based on date
	@Override
	public List<LoanApplication> getListDateBasedResult(LocalDate date) {
		List<LoanApplication> lst= new ArrayList<>();
		for(LoanApplication val:ccDao1.findAll()) {
			if(date.compareTo(val.getLoanAppDate())==0) {
				lst.add(val);
			}
		}
		return lst;
	}

//	update loan details based on id
	@Override
	public LoanApplication updateLoanDetails(LoanApplication value) {
		Optional<LoanApplication> optional=ccDao1.findById(value.getLoanAppId());
		if(!optional.isEmpty()) {
			LoanApplication val=optional.get();
			val.setCustId(value.getCustId());
//			val.setCustomerId(value.getCustomerId());
			val.setLoanAmt(value.getLoanAmt());
//			val.setLoanAmount(value.getLoanAmount());
			val.setNoOfYears(value.getNoOfYears());
			val.setPurpose(value.getPurpose());
			val.setAppStatus(value.getAppStatus());
//			val.setApplicationStatus(value.getApplicationStatus());
			val.setTypeOfLoan(value.getTypeOfLoan());
			val.setLoanAppDate(value.getLoanAppDate());
			val.setStatus(value.getStatus());
			ccDao1.save(val);
			return val;
		}
		else {
			throw new IdNotFoundException("This id doesnot exists! Cant update details..");
			
		}
	}

	



	

	
}
