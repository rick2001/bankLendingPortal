package com.cts.entities;

import java.util.*;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.*;

@Entity
@Table(name="loanApplication")
public class LoanApplication {
	@Id
	@Column(name="loanAppId")
	private String loanAppId;
	
	@NotBlank(message = "Customer ID is mandatory")
	@Column(name="custId")
	private String custId;
	
	@Positive(message = "Loan amount must be positive")
	@Column(name="loanAmt")
	private int loanAmt;
	
	@Positive(message = "Number of years must be positive")
	@Column(name="noOfYears")
	private int noOfYears;
	
	@NotBlank(message = "Purpose is mandatory")
	@Column(name="purpose")
	private String purpose;
	
	@NotBlank(message = "Application status is mandatory")
	@Column(name="appStatus")
	private String appStatus;
	
	@NotBlank(message = "Type of loan is mandatory")
	@Column(name="typeOfLoan")
	private String typeOfLoan;
	
	@NotNull(message = "Loan application date is mandatory")
	@Column(name="loanAppDate")
	@Temporal(TemporalType.DATE)
	private Date loanAppDate;
	
	@NotBlank(message = "Status is mandatory")
	@Column(name="status")
	private String status;
	
	@OneToOne(mappedBy = "loanApplication", cascade=CascadeType.ALL)
	private CreditRisk creditRisk;

	
	
	
	public LoanApplication(String loanAppId, @NotBlank(message = "Customer ID is mandatory") String custId,
			@Positive(message = "Loan amount must be positive") int loanAmt,
			@Positive(message = "Number of years must be positive") int noOfYears,
			@NotBlank(message = "Purpose is mandatory") String purpose,
			@NotBlank(message = "Application status is mandatory") String appStatus,
			@NotBlank(message = "Type of loan is mandatory") String typeOfLoan,
			@NotNull(message = "Loan application date is mandatory") Date loanAppDate,
			@NotBlank(message = "Status is mandatory") String status, CreditRisk creditRisk) {
		super();
		this.loanAppId = loanAppId;
		this.custId = custId;
		this.loanAmt = loanAmt;
		this.noOfYears = noOfYears;
		this.purpose = purpose;
		this.appStatus = appStatus;
		this.typeOfLoan = typeOfLoan;
		this.loanAppDate = loanAppDate;
		this.status = status;
		this.creditRisk = creditRisk;
	}
	
	

	public LoanApplication() {
		super();
		// TODO Auto-generated constructor stub
	}



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



	public Date getLoanAppDate() {
		return loanAppDate;
	}



	public void setLoanAppDate(Date loanAppDate) {
		this.loanAppDate = loanAppDate;
	}



	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}



	public CreditRisk getCreditRisk() {
		return creditRisk;
	}



	public void setCreditRisk(CreditRisk creditRisk) {
		this.creditRisk = creditRisk;
	}



	

}