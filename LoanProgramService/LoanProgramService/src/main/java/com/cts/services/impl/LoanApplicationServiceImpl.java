package com.cts.services.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.dao.LoanApplicationDao;
import com.cts.entities.LoanApplication;
import com.cts.services.LoanApplicationService;


@Service
public class LoanApplicationServiceImpl implements LoanApplicationService {
	@Autowired
	private LoanApplicationDao ccDao1;

	@Override
	public List<LoanApplication> getAllDetails() {
		return ccDao1.findAll();
	}

	@Override
	public LoanApplication getOnedetail(String id) {
		LoanApplication res=ccDao1.findById(id).get();
		return res;
	}

	@Override
	public LoanApplication addDetails(LoanApplication val) {
		ccDao1.save(val);
		return val;
	}

	@Override
	public List<LoanApplication> getDateBasedResult(Date date) {
		List<LoanApplication> lst= new ArrayList<>();
		for(LoanApplication val:ccDao1.findAll()) {
			if(date.compareTo(val.getLoanAppDate())==0) {
				lst.add(val);
			}
		}
		return lst;
	}

	@Override
	public LoanApplication updatedetails(LoanApplication value) {
		Optional<LoanApplication> optional=ccDao1.findById(value.getLoanApplicationId());
//		LoanApplication val=null;
//		val=ccDao1.findById(value.getLoanApplicationId()).get();
		if(!optional.isEmpty()) {
			LoanApplication val=optional.get();
			val.setCustomerId(value.getCustomerId());
			val.setLoanAmount(value.getLoanAmount());
			val.setNoOfYears(value.getNoOfYears());
			val.setPurpose(value.getPurpose());
			val.setApplicationStatus(value.getApplicationStatus());
			val.setTypeOfLoan(value.getTypeOfLoan());
			val.setLoanAppDate(value.getLoanAppDate());
			val.setStatus(value.getStatus());
			ccDao1.save(val);
			return val;
		}
		else {
			return null;
			
		}
	}
	
	
}