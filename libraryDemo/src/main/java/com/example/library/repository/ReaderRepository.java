package com.example.library.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Repository;

import com.example.library.model.Reader;

@Repository
public class ReaderRepository {
	
	private final Map<Long, Reader> readersMap = new ConcurrentHashMap<>();
	private final AtomicLong nextID =  new AtomicLong(1);
	
	public Reader save(Reader reader)
	{
		if(reader.getID() == null)
		{
			reader.setID(nextID.getAndIncrement());
		}
		readersMap.put(reader.getID(), reader);
		return reader;
	}
	
	public List<Reader> findAll()
	{
		return new ArrayList<Reader>(readersMap.values());
	}
	
	public Optional<Reader> findById(long id)
	{
		return Optional.ofNullable(readersMap.get(id)); 
	}

}
