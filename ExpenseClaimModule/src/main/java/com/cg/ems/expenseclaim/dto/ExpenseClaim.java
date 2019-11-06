package com.cg.ems.expenseclaim.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "Expense_Claim_Details")
@GenericGenerator(name = "expense_claim_sequence",strategy="increment")
public class ExpenseClaim {
	
	@Id
	@GeneratedValue(generator = "expense_claim_sequence",strategy = GenerationType.SEQUENCE)
	private int claimId;
	@Column
	private String employeeId;
	@Column
	private int projectId;
	@Column
	private int clientId;
	@Column
	private int expenseId;
	@Column
	private String financeUserId;
	@Column
	@NotNull
	private double amount;
	@Column
	private Date startDate;
	@Column
	private Date endDate;
	@Column
	private String status;
	@Column
	@NotNull
	private String description;
	public int getClaimId() {
		return claimId;
	}
	public void setClaimId(int claimId) {
		this.claimId = claimId;
	}
	public int getProjectId() {
		return projectId;
	}
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	public int getClientId() {
		return clientId;
	}
	public void setClientId(int clientId) {
		this.clientId = clientId;
	}
	public int getExpenseId() {
		return expenseId;
	}
	public void setExpenseId(int expenseId) {
		this.expenseId = expenseId;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
	public String getFinanceUserId() {
		return financeUserId;
	}
	public void setFinanceUserId(String financeUserId) {
		this.financeUserId = financeUserId;
	}
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "ExpenseClaim [claimId=" + claimId + ", employeeId=" + employeeId + ", projectId=" + projectId
				+ ", clientId=" + clientId + ", expenseId=" + expenseId + ", financeUserId=" + financeUserId
				+ ", amount=" + amount + ", startDate=" + startDate + ", endDate=" + endDate + ", status=" + status
				+ ", description=" + description + "]";
	}
	
	
	
	
	

}
