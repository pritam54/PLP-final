package com.cg.ems.expenseclaim.dao;


import com.cg.ems.expenseclaim.dto.ExpenseClaim;

public interface ExpenseClaimDao{
	
	int addClaim(ExpenseClaim claim);
	
	ExpenseClaim viewClaim(int claimId);
		
	boolean deleteClaim(int claimId);

	ExpenseClaim modifyClaim(ExpenseClaim claim);

}
