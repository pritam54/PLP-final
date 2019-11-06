package com.cg.ems.expenseclaim.exception;


import java.util.Date;


import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.cg.ems.expenseclaim.dto.ErrorPageModification;





@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
@RestController
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(ExpenseClaimNotFound.class)
	@ResponseBody
	public ResponseEntity<Object> handleInvalidEntry(ExpenseClaimNotFound ex){
		ErrorPageModification error = new ErrorPageModification();
		error.setTimestamp(new Date());
		error.setMessage(ex.getMessage());
		error.setDetails(ex.getUriDetails());
		return new ResponseEntity<Object>(error, HttpStatus.NOT_FOUND );
	}
	}
