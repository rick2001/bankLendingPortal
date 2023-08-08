package com.cts.services.impl;

import java.util.List;
import java.time.LocalDate;
import java.time.Period;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cts.dao.CreditRiskDao;
import com.cts.dao.LoanApplicationDao;
import com.cts.entities.CreditRisk;
import com.cts.entities.LoanApplication;
import com.cts.services.CreditRiskService;


@Service
public class CreditRiskServiceImpl implements CreditRiskService {
	@Autowired
	private CreditRiskDao ccDao2;
	
	@Autowired
	private LoanApplicationDao ccDao1;
	
	//getting all the details of creditrisk table
	@Override
	public List<CreditRisk> getAllDetailsOfCreditRisk() {
		return ccDao2.findAll();
	}

	// adding the details to creditrisk table. (This part is being done from administrator side)
	@Override
	public String addCreditRiskDetails(String id, CreditRisk creditRisk) {
		String basicCheck=creditRisk.getBasicCheck();
		LoanApplication val=ccDao1.findById(id).orElse(null);
		if(val==null) {
			return "Id not found. (Credit Details Cant be Added)";  //throw need to be added
		}
		
		//default it should be pending
		creditRisk.setBasicCheck("pending");
		
		
		// Validate the emi field
		int emi=creditRisk.getEmi();
		if(emi<0) {
			return "Emi amount must be positive";
		}
		
		// credit score range is 200-700. but if the user is getting above 500 then only his loan is approved
		// Validate the credit score field
		int creditScore=creditRisk.getCreditScore();
		if(creditScore<200 || creditScore > 700) {
			return "Credit score Min Range is 200 and Max Range is 700";
		}

		
		String crid="CR-"+id;
		creditRisk.setCrId(crid);
		creditRisk.setLoanApplication(val);
		this.ccDao2.save(creditRisk);
		return "yes";
	}

	
	//doing all the basiccheck conditions
	@Override
	public ResponseEntity<String> doingBasicChecking(String id) {
		LoanApplication val=ccDao1.findById(id).orElse(null);
		if(val==null) {
			return new ResponseEntity<>("Enter Correct **id**",HttpStatus.NOT_FOUND);
		}
		
		Period period = Period.between(val.getBirthDate(), val.getLoanAppDate());
		int yearsDifference = period.getYears();
		
		CreditRisk creditRisk=new CreditRisk();
		creditRisk=ccDao2.getCreditRisk(val.getLoanAppId());
		
//		int creditScore=val.getCreditRisk().getCreditScore();
		int creditScore=creditRisk.getCreditScore();
		CreditRisk creditRiskObj=val.getCreditRisk();		
		if(yearsDifference >=18 && yearsDifference <=58) {
			if((yearsDifference+val.getNoOfYears()<=58)) {
				if(creditScore >=500 && creditScore<=700) {
					creditRiskObj.setBasicCheck("pass");
					this.ccDao2.save(creditRiskObj);
					return new ResponseEntity<>("All criteria are satisfied. Basic Check Successfull",HttpStatus.OK);
				}
				else {
					creditRiskObj.setBasicCheck("fail");
					this.ccDao2.save(creditRiskObj);
					return new ResponseEntity<>("CreditScore Not meeting the criteria. Basic Check Failed",HttpStatus.EXPECTATION_FAILED);
				}
				
			}
			else {
				creditRiskObj.setBasicCheck("fail");
				this.ccDao2.save(creditRiskObj);
				return new ResponseEntity<>("loan Applicant and no of years collectivly should not exceed 58 years. Basic Check Failed",HttpStatus.EXPECTATION_FAILED);
			}
			
		}
		else {
			creditRiskObj.setBasicCheck("fail");
//			val.setAppStatus("Cancelled");
//			val.setStatus("Rejected");
//			this.ccDao1.save(val);
			this.ccDao2.save(creditRiskObj);
			return new ResponseEntity<>("Loan Applicant is not meeting the **age** criteria",HttpStatus.EXPECTATION_FAILED);
		}
	}
	

}
