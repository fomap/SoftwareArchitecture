package com.example.library.service;
import java.util.*;

import org.springframework.stereotype.Service;

import com.example.library.model.Reader;
import com.example.library.repository.ReaderRepository;

@Service
public class UserService {
	
	private final ReaderRepository repository;
	
	public UserService(ReaderRepository repository)
	{
		this.repository = repository;
	}
	
	
	public Reader addReader(Reader reader)
	{
		return repository.save(reader);
	}
	
	public List<Reader> listReaders()
	{
		return repository.findAll();
	}
	
	public Reader getReader(Long id)
	{
		return repository.findById(id).orElseThrow(() -> new NotFoundException("Reader " + id + "is not found!!!!"));
	}
	
}
