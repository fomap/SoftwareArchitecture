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

import com.example.library.model.Reader;
import com.example.library.service.NotFoundException;
import com.example.library.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	private final UserService service;
	
	public UserController(UserService service)
	{
		this.service = service;
	}
	
	@PostMapping
	public ResponseEntity<Reader> add(@RequestBody Reader reader)
	{
		return ResponseEntity.status(HttpStatus.CREATED).body(service.addReader(reader));
	}
	
	
	
	@GetMapping
	public List<Reader> list()
	{
		return service.listReaders();	 
	}
	
	@GetMapping("/{id}")
	public Reader get(@PathVariable Long id)
	{
		return service.getReader(id);
	}
	
	
	
	 @ExceptionHandler(NotFoundException.class)
	 public ResponseEntity<String> handleNotFound(NotFoundException e)
	 {
		 return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
	 }
	
	
}
