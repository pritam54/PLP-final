package com.cg.ems.expenseclaim.service;

import com.cg.ems.expenseclaim.dto.ExpenseClaim;

public interface ExpenseClaimService {
	
	int addClaim(ExpenseClaim claim);
	
	ExpenseClaim viewClaim(int claimId);
		
	boolean deleteClaim(int claimId);

	ExpenseClaim modifyClaim(ExpenseClaim claim);
	
	

}
