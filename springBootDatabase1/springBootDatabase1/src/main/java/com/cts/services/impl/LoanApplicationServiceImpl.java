package com.cts.services.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.dao.CreditRiskDao;
import com.cts.dao.LoanApplicationDao;
import com.cts.entities.CreditRisk;
import com.cts.entities.LoanApplication;
import com.cts.services.LoanApplicationService;


@Service
public class LoanApplicationServiceImpl implements LoanApplicationService {
	@Autowired
	private LoanApplicationDao ccDao1;
	
	public LoanApplicationServiceImpl(LoanApplicationDao ccDao1) {
		this.ccDao1 = ccDao1;
	}

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
		Optional<LoanApplication> optional=ccDao1.findById(value.getLoanAppId());
//		LoanApplication val=null;
//		val=ccDao1.findById(value.getLoanApplicationId()).get();
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
			return null;
			
		}
	}

	@Override
	public String addLoanAll() {
		LoanApplication loan=new LoanApplication();
		loan.setLoanAppId("100");
		loan.setCustId("001");
		loan.setLoanAmt(100);
		loan.setNoOfYears(9);
		loan.setPurpose("Home making");
		loan.setAppStatus("Pending");
		loan.setTypeOfLoan("Home Loan");
		loan.setLoanAppDate(new Date());
		loan.setStatus("completed");
		CreditRisk credit=new CreditRisk();
		credit.setCrId("Cr10");
		credit.setCreditScore(600);
		credit.setEmi(200);
		credit.setBasicCheck("pass");
		CreditRisk credit1=new CreditRisk();
		credit1.setCrId("Cr20");
		credit1.setCreditScore(500);
		credit1.setEmi(100);
		credit1.setBasicCheck("pass");
		List<CreditRisk> arr=new ArrayList<>();
		arr.add(credit);
		arr.add(credit1);
		loan.setCreditRiskList(arr);
		ccDao1.save(loan);

		return "Data Has been inserted successfully";
	}
	
	

	
}
