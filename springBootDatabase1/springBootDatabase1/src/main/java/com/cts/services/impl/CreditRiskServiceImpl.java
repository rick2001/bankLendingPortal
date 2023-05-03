package com.cts.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.dao.CreditRiskDao;
import com.cts.entities.CreditRisk;
import com.cts.services.CreditRiskService;


@Service
public class CreditRiskServiceImpl implements CreditRiskService {
	@Autowired
	private CreditRiskDao ccDao2;

	@Override
	public List<CreditRisk> getAllDetails() {
		return ccDao2.findAll();
	}

	@Override
	public String addDetails(CreditRisk creditRisk) {
		String basicCheck=creditRisk.getBasicCheck();
		// Validate the basic check field
		if(!basicCheck.equals("pass") && !basicCheck.equals("fail") && !basicCheck.equals("pending")) {
			return "Basic check field is not metting the criteria";
		}
		// Validate the emi field
		int emi=creditRisk.getEmi();
		if(emi<0) {
			return "emi field is not meeting the criteria";
		}
		
		// Validate the credit score field
		int creditScore=creditRisk.getCreditScore();
		if(creditScore<200 || creditScore > 700) {
			return "credit score is not meeting the criteria";
		}
		
		String crid="CR-"+creditRisk.getLoanApplication().getLoanAppId();
		creditRisk.setCrId(crid);
		
		
		ccDao2.save(creditRisk);
		return "yes";
	}
	

}
