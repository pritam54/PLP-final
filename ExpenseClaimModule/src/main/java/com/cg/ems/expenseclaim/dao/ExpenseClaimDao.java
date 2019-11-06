package com.cg.ems.expenseclaim.dao;


import com.cg.ems.expenseclaim.dto.ExpenseClaim;
import com.cg.ems.expenseclaim.exception.ExpenseClaimNotFound;

public interface ExpenseClaimDao{
	
	int addClaim(ExpenseClaim claim);
	
	ExpenseClaim viewClaim(int claimId) throws ExpenseClaimNotFound;
		
	boolean deleteClaim(int claimId);

	ExpenseClaim modifyClaim(ExpenseClaim claim);

}
