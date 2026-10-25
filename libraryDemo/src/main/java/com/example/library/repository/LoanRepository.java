package com.example.library.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Repository;

import com.example.library.model.Loan;


@Repository
public class LoanRepository {
	
	private final Map<Long, Loan> loansMap = new ConcurrentHashMap<>();
	private final AtomicLong nextID =  new AtomicLong(1);
	
	public Loan save(Loan loan)
	{
		if(loan.getLoanID() == null)
		{
			loan.setLoanID(nextID.getAndIncrement());
		}
		loansMap.put(loan.getLoanID(), loan);
		return loan;
	}
	
	public List<Loan> findAll()
	{
		return new ArrayList<Loan>(loansMap.values());
	}
	
	public Optional<Loan> findById(long id)
	{
		return Optional.ofNullable(loansMap.get(id));
	}
	
	
	
}
