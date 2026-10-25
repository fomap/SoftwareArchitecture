package com.example.library.service;

import org.springframework.stereotype.Service;

import com.example.library.model.Loan;
import com.example.library.repository.BookRepository;
import com.example.library.repository.LoanRepository;
import com.example.library.repository.ReaderRepository;

@Service
public class LoanService {

	private final LoanRepository loanRepository;
	private final ReaderRepository readerRepository;
	private final BookRepository bookRepository;
	
	public LoanService(LoanRepository loanRepository, ReaderRepository readerRepository, BookRepository bookRepository)
	{
		this.loanRepository = loanRepository;
		this.readerRepository = readerRepository;
		this.bookRepository = bookRepository;
	}
	
	
	public Loan borrow(Long readerID, Long bookID)
	{
		if(readerRepository.findById(readerID).isEmpty())
		{
			throw new NotFoundException("Reader " + readerID + " is not found");
		}
		
		if(bookRepository.findById(bookID).isEmpty())
		{
			throw new NotFoundException("Book " + bookID + " is not found");
		
		}
		
		if(!bookRepository.findById(bookID).get().getAvailable())
		{
			throw new BookUnavailableException("Book " + bookID + " is unavailable!");
		}
		
		bookRepository.findById(bookID).get().setAvailable(false);
		bookRepository.save(bookRepository.findById(bookID).get());
	
		Loan loan = new Loan();
		loan.setReaderID(readerID);
		loan.setBookID(bookID);
		
		loanRepository.save(loan);
		return loan;
		
	}
	
}
