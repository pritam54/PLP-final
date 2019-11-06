package com.cg.ems.expenseclaim.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.cg.ems.expenseclaim.dto.Client;
import com.cg.ems.expenseclaim.dto.Employee;
import com.cg.ems.expenseclaim.dto.Expense;
import com.cg.ems.expenseclaim.dto.ExpenseClaim;
import com.cg.ems.expenseclaim.dto.FinanceUser;
import com.cg.ems.expenseclaim.dto.Project;
import com.cg.ems.expenseclaim.service.ExpenseClaimService;

@CrossOrigin(origins = "http://localhost:4200/expenseclaim")
@RestController
@RequestMapping("/ems")
public class ExpenseClaimController {
	
	@Autowired
	private ExpenseClaimService service;
	@Autowired
	RestTemplate restTemplate;
	
	@PostMapping(value = "/claim/addclaim",produces = "application/json",consumes = "application/json")
	public int addClaim(@RequestBody ExpenseClaim claim) {
		return service.addClaim(claim);
	}
	
	@GetMapping(value="/claim/{claimId}",produces = "application/json")
	public ExpenseClaim findClaim(@PathVariable int claimId) {
		return service.viewClaim(claimId);
	}
	
	@PutMapping(value = "/claim/modifyclaim",produces = "application/json",consumes = "application/json")
	public ExpenseClaim modifyClaim(@RequestBody ExpenseClaim claim) {
		return service.modifyClaim(claim);
		
	}
	@DeleteMapping(value = "/claim/deleteclaim",produces = "application/json")
	public boolean deleteclaim(@RequestParam int claimId) {
		return service.deleteClaim(claimId);
		
	}
	@GetMapping(value = "/employee",produces = "application/json")
	public Employee getEmployee(@RequestParam String employeeId) {
		Employee retrivedEmployee =restTemplate.getForObject("http://product-add-service/product/add/" + employeeId,Employee.class);
		return retrivedEmployee;
	}
	
	@GetMapping(value = "/expense",produces = "application/json")
	public Expense getExpense() {
		Expense retrivedExpense =restTemplate.getForObject("http://product-add-service/product//",Expense.class);
		return retrivedExpense;
	}
	@GetMapping(value = "/client",produces = "application/json")
	public int getClient() {
		Client retrivedClient =restTemplate.getForObject("http://product-add-service/product//j",Client.class);
		return retrivedClient.getClientCode();
	}
	@GetMapping(value = "/project",produces = "application/json")
	public Project getProject() {
		Project retrivedProject =restTemplate.getForObject("http://product-add-service/product//j",Project.class);
		return retrivedProject;
	}
	@GetMapping(value = "/finance",produces = "application/json")
	public FinanceUser getFinance() {
		FinanceUser retrivedFinance =restTemplate.getForObject("http://product-add-service/product//j",FinanceUser.class);
		return retrivedFinance;
	}
	
}
