package com.example.library.model;

public class Loan {
	
	private Long _loanID;
	private Long _readerID;
	private Long _bookID;
	

	public Loan( ) {}

	
	public Long getLoanID() { return _loanID;}
	
	public void setLoanID(Long _loanID) {
		this._loanID = _loanID;
	}
	
	public Long getReaderID() {
		return _readerID;
	}

	public void setReaderID(Long _readerID) {
		this._readerID = _readerID;
	}
	

	public Long getBookID() {
		return _bookID;
	}


	public void setBookID(Long _bookID) {
		this._bookID = _bookID;
	}



}
