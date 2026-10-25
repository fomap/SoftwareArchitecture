package com.example.library.service;

import java.util.*;

import org.springframework.stereotype.Service;

import com.example.library.model.Book;
import com.example.library.repository.BookRepository;

@Service
public class BookService { // da rules
	
	private final BookRepository repository;
	
	public BookService(BookRepository repository)
	{
		this.repository = repository;
	}
	
	public Book addBook(Book book)
	{
		return repository.save(book);
	}
	
	
	public List<Book> listBooks()
	{
		return repository.findAll();
	}
	
	public Book getBook(Long id)
	{
		return repository.findById(id).orElseThrow(() -> new NotFoundException("Book " + id + "is not found"));
	}
	
}
