package com.example.library.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.library.service.LoanService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/loans")
public class LoanController {

	private final LoanService service;
	
	public LoanController(LoanService service)
	{
		this.service = service;
	}
	

	
	
	
}
