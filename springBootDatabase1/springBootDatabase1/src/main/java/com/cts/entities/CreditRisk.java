package com.cts.entities;



import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name="creditRisk")
public class CreditRisk {
	
	@Id
	@Column(name="crId")
	private String crId;
	
	
	
	
	@NotNull(message = "Credit score is mandatory")
    @Min(value = 200, message = "Credit score must be between 200 and 700")
    @Max(value = 700, message = "Credit score must be between 200 and 700")
	@Column(name="creditScore")
	private int creditScore;
	
	@Positive(message = "EMI must be positive")
	@Column(name="emi")
	private int emi;
	
	@Pattern(regexp = "pass|fail|pending",message="Basic check result can only be pass, fail or pending")
	@Column(name="basicCheck")
	private String basicCheck;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="loanAppId", referencedColumnName = "loanAppId")
	private LoanApplication loanApplication;

	public CreditRisk(String crId,
			@NotNull(message = "Credit score is mandatory") @Min(value = 200, message = "Credit score must be between 200 and 700") @Max(value = 700, message = "Credit score must be between 200 and 700") int creditScore,
			@Positive(message = "EMI must be positive") int emi,
			@Pattern(regexp = "pass|fail|pending", message = "Basic check result can only be pass, fail or pending") String basicCheck,
			LoanApplication loanApplication) {
		super();
		this.crId = crId;
		this.creditScore = creditScore;
		this.emi = emi;
		this.basicCheck = basicCheck;
		this.loanApplication = loanApplication;
	}

	public CreditRisk() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getCrId() {
		return crId;
	}

	public void setCrId(String crId) {
		this.crId = crId;
	}

	public int getCreditScore() {
		return creditScore;
	}

	public void setCreditScore(int creditScore) {
		this.creditScore = creditScore;
	}

	public int getEmi() {
		return emi;
	}

	public void setEmi(int emi) {
		this.emi = emi;
	}

	public String getBasicCheck() {
		return basicCheck;
	}

	public void setBasicCheck(String basicCheck) {
		this.basicCheck = basicCheck;
	}

	public LoanApplication getLoanApplication() {
		return loanApplication;
	}

	public void setLoanApplication(LoanApplication loanApplication) {
		this.loanApplication = loanApplication;
	}

	
	
	
}