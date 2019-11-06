package com.cg.ems.expenseclaim.service;

import com.cg.ems.expenseclaim.dto.ExpenseClaim;
import com.cg.ems.expenseclaim.exception.ExpenseClaimNotFound;

public interface ExpenseClaimService {
	
	int addClaim(ExpenseClaim claim);
	
	ExpenseClaim viewClaim(int claimId) throws ExpenseClaimNotFound;
		
	boolean deleteClaim(int claimId);

	ExpenseClaim modifyClaim(ExpenseClaim claim);
	
	

}
