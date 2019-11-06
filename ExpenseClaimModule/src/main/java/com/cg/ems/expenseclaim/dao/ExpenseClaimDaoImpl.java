package com.cg.ems.expenseclaim.dao;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cg.ems.expenseclaim.dto.ExpenseClaim;

@Repository
public class ExpenseClaimDaoImpl implements ExpenseClaimDao {
	
	@Autowired
	private EntityManager mgr;

	@Override
	public int addClaim(ExpenseClaim claim) {
		mgr.persist(claim);
		return claim.getClaimId();
	}

	@Override
	public ExpenseClaim viewClaim(int claimId) {
		ExpenseClaim claim = mgr.find(ExpenseClaim.class, claimId);
		return claim;
	}

	@Override
	public ExpenseClaim modifyClaim(ExpenseClaim claim) {
		//ExpenseClaim initialClaim = mgr.find(ExpenseClaim.class, claimId);
		//System.out.println(initialClaim);
		mgr.merge(claim);
		return claim;
	}

	@Override
	public boolean deleteClaim(int claimId) {
		mgr.remove(claimId);
		return true;
	}


}
