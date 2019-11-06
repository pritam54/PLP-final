package com.cg.ems.expenseclaim.web;

import java.util.Arrays;
import java.util.List;

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
import com.cg.ems.expenseclaim.dto.ExpenseClaim;
import com.cg.ems.expenseclaim.exception.ExpenseClaimNotFound;
import com.cg.ems.expenseclaim.service.ExpenseClaimService;

@CrossOrigin(origins = "http://localhost:4200")
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
	public ExpenseClaim findClaim(@PathVariable int claimId) throws ExpenseClaimNotFound{
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
	@GetMapping(value = "/employee/{employeeId}",produces = "application/json")
	public Employee getEmployee(@PathVariable String employeeId) {
		Employee retrivedEmployee =restTemplate.getForObject("http://ems-employee-service/employee/id/" + employeeId,Employee.class);
		return retrivedEmployee;
	}
	
	@GetMapping(value = "/expense",produces = "application/json")
	public List<Integer> getExpense() {
		List<Integer> expenseIds =Arrays.asList(restTemplate.getForObject("http://ems-expense-service/expense/allId",Integer[].class));
		return expenseIds;
	}
	@GetMapping(value = "/client",produces = "application/json")
	public int getClient() {
		Client retrivedClient =restTemplate.getForObject("http://product-add-service/product//j",Client.class);
		return retrivedClient.getClientCode();
	}
	@GetMapping(value = "/project",produces = "application/json")
	public List<Integer> getProject() {
		List<Integer> projectIds =Arrays.asList(restTemplate.getForObject("http://ems-project-service/project/allId",Integer[].class));
		return projectIds;
	}
	@GetMapping(value = "/finance",produces = "application/json")
	public List<String> getFinance() {
		List<String> financeIds =Arrays.asList(restTemplate.getForObject("http://ems-finance-service/finance/getids",String[].class));
		return financeIds;
	}
	
}
