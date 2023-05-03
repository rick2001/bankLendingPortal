package com.cts.services;

import java.util.*;

import com.cts.entities.CreditRisk;

public interface CreditRiskService {
	public List<CreditRisk> getAllDetails();
	public String addDetails(CreditRisk creditRisk);
}
