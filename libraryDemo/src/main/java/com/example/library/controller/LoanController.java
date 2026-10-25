package com.example.library.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.library.model.Loan;
import com.example.library.service.BookUnavailableException;
import com.example.library.service.LoanService;
import com.example.library.service.NotFoundException;


@RestController
@RequestMapping("/loans")
public class LoanController {

	private final LoanService service;
	
	public LoanController(LoanService service)
	{
		this.service = service;
	}
	
	@PostMapping
	public ResponseEntity<Loan> add(@RequestBody Loan loan)
	{	
		return ResponseEntity.status(HttpStatus.CREATED).body(service.borrow(loan.getReaderID(), loan.getBookID()));
	}
	
	
	 @ExceptionHandler(NotFoundException.class)
	 public ResponseEntity<String> handleNotFound(NotFoundException e)
	 {
		 return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
	 }
	 
	 @ExceptionHandler(BookUnavailableException.class)
	 public ResponseEntity<String> handleNotFound(BookUnavailableException e)
	 {
		 return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
	 }
	
	
	
	
}
