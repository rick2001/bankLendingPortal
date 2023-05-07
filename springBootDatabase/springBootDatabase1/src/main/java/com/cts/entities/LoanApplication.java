package com.cts.entities;

import java.time.LocalDate;
import java.util.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.*;
@Entity
public class LoanApplication {
	@Id
	@Column(name="loanAppId")
	private String loanAppId;
	
	@Column(name="custId")
	private String custId;
	
	@Positive(message = "Loan amount must be positive")
	@Column(name="loanAmt")
	private int loanAmt;
	
	@Positive(message = "Number of years must be positive")
	@Column(name="noOfYears")
	private int noOfYears;
	
	
	@Column(name="purpose")
	private String purpose;
	
	
	@Column(name="appStatus")
	private String appStatus;
	
	@NotBlank(message = "Type of loan is mandatory")
	@Column(name="typeOfLoan")
	private String typeOfLoan;
	
	@NotNull(message = "Loan application date is mandatory")
	@Column(name="loanAppDate")
	private LocalDate loanAppDate;
	
	@Column(name="status")
	private String status;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "loanApplication",cascade=CascadeType.ALL)
	private List<CreditRisk> creditRiskList=new ArrayList<>();
	
//	@OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
//	@JoinColumn(name="loanAppId", referencedColumnName = "loanAppId")
//	private List<CreditRisk> creditRiskList=new ArrayList<>();
	


	public String getLoanAppId() {
		return loanAppId;
	}


	public void setLoanAppId(String loanAppId) {
		this.loanAppId = loanAppId;
	}


	public String getCustId() {
		return custId;
	}


	public void setCustId(String custId) {
		this.custId = custId;
	}


	public int getLoanAmt() {
		return loanAmt;
	}


	public void setLoanAmt(int loanAmt) {
		this.loanAmt = loanAmt;
	}


	public int getNoOfYears() {
		return noOfYears;
	}


	public void setNoOfYears(int noOfYears) {
		this.noOfYears = noOfYears;
	}


	public String getPurpose() {
		return purpose;
	}


	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}


	public String getAppStatus() {
		return appStatus;
	}


	public void setAppStatus(String appStatus) {
		this.appStatus = appStatus;
	}


	public String getTypeOfLoan() {
		return typeOfLoan;
	}


	public void setTypeOfLoan(String typeOfLoan) {
		this.typeOfLoan = typeOfLoan;
	}


	public LocalDate getLoanAppDate() {
		return loanAppDate;
	}


	public void setLoanAppDate(LocalDate loanAppDate) {
		this.loanAppDate = loanAppDate;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public List<CreditRisk> getCreditRiskList() {
		return creditRiskList;
	}


	public void setCreditRiskList(List<CreditRisk> creditRiskList) {
		this.creditRiskList = creditRiskList;
	}

//	@OneToOne(cascade=CascadeType.ALL,mappedBy = "loanApplication")
//	private CreditRisk creditRisk;
	

	

	
	
	

}