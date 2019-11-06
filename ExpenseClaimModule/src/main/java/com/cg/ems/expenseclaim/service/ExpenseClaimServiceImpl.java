package com.cg.ems.expenseclaim.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.ems.expenseclaim.dao.ExpenseClaimDao;
import com.cg.ems.expenseclaim.dto.ExpenseClaim;
import com.cg.ems.expenseclaim.exception.ExpenseClaimNotFound;

@Service
@Transactional
public class ExpenseClaimServiceImpl implements ExpenseClaimService {
	
	@Autowired
	private ExpenseClaimDao dao;

	@Override
	public int addClaim(ExpenseClaim claim) {
		return dao.addClaim(claim);
	}

	@Override
	public ExpenseClaim viewClaim(int claimId)throws ExpenseClaimNotFound {
		return dao.viewClaim(claimId);
	}

	@Override
	public ExpenseClaim modifyClaim(ExpenseClaim claim) {
		return dao.modifyClaim(claim);
	}

	@Override
	public boolean deleteClaim(int claimId) {
		return dao.deleteClaim(claimId);
	}


}
