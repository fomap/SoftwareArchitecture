package com.example.library.service;

import org.springframework.stereotype.Service;

import com.example.library.model.Loan;
import com.example.library.repository.LoanRepository;

@Service
public class LoanService {

	private final LoanRepository repository;
	
	public LoanService(LoanRepository repository)
	{
		this.repository = repository;
	}
	
	public Loan borrow(Loan loan)
	{
		return repository.save(loan);
	}
	
	
}
