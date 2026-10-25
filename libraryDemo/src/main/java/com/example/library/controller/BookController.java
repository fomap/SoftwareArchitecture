package com.example.library.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.library.model.Book;
import com.example.library.service.BookService;
import com.example.library.service.NotFoundException;

@RestController
@RequestMapping("/books")
public class BookController { //http to method calls tranlation
	
	private final BookService service;
	
	public BookController(BookService service)
	{
		this.service = service;
	}
	
	
	@PostMapping
	public ResponseEntity<Book> add(@RequestBody Book book)
	{
		return ResponseEntity.status(HttpStatus.CREATED).body(service.addBook(book));
	}
	
	@GetMapping
	public List<Book> list()
	{
		return service.listBooks();
	}
	
	@GetMapping("/{id}")
	public Book get(@PathVariable Long id)
	{
		return service.getBook(id);
	}
	
	 @ExceptionHandler(NotFoundException.class)
	 public ResponseEntity<String> handleNotFound(NotFoundException e)
	 {
		 return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
	 }
	

}
