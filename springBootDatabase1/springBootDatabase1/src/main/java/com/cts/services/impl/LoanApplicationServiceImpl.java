package com.cts.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cts.dao.LoanApplicationDao;
import com.cts.entities.LoanApplication;
import com.cts.services.LoanApplicationService;

@Service
public class LoanApplicationServiceImpl implements LoanApplicationService {
	private LoanApplicationDao ccDao1;

	@Override
	public List<LoanApplication> getAllDetails() {
		return ccDao1.findAll();
	}
}
