package com.cts.services;

import java.util.*;

import org.springframework.http.ResponseEntity;

import com.cts.entities.CreditRisk;

public interface CreditRiskService {
	//getting all the details of creditrisk table
	public List<CreditRisk> getAllDetailsOfCreditRisk();
	
	// adding the details to creditrisk table. (This part is being done from administrator side)
	public String addCreditRiskDetails(String id, CreditRisk creditRisk);
	
	public ResponseEntity<String> doingBasicChecking(String id);
}
