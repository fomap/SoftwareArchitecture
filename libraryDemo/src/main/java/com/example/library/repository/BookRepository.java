package com.example.library.repository;


import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

import com.example.library.model.Book;
import org.springframework.stereotype.Repository;


@Repository
public class BookRepository { // lwk just a map
	private final Map<Long, Book> booksMap = new ConcurrentHashMap<>();
	private final AtomicLong nextID =  new AtomicLong(1);
	
	public Book save(Book book)
	{
		if(book.getID() == null)
		{
			book.setID(nextID.getAndIncrement());
		}
		booksMap.put(book.getID(), book);
		return book;
	}
	
	public List<Book> findAll()
	{
		return new ArrayList<Book>(booksMap.values());
	}
	
	public Optional<Book> findById(long id)
	{
		return Optional.ofNullable(booksMap.get(id));
	}
}
