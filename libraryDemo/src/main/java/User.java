import java.util.Vector;

import com.sun.source.tree.WhileLoopTree;

public class User {

	public  String nameString;
	
	public User(String nameString)
	{		
		this.nameString = nameString;
	}
	
	public String getUserName()
	{
		return this.nameString;
	}
	
	
}


public class Librarian extends User
{

	public Librarian(String nameString) {
		super(nameString);
		// TODO Auto-generated constructor stub
	}
	
	public void registerBook(Reader reader, Book book)
	{
		if(!(book.availableCopies > 0))
		{
			System.out.println("No availabel copies!");
		}
		
		if(book.isBorrowedBy(reader.ID))
		{
			System.out.println("Reader already has a copy!");
		}
		
		if(! (reader.borrowedBooks.count() < reader.getBookLimit())) 
		{
			System.out.println("Reader has too many borrowed books!");
		}
			
	}
	

	
}


public class Reader extends User
{
	public String ID;
	public int bookLimit;
	public Vector<Book> borrowedBooks;
	
	
	public Reader(String nameString, String ID, int bookLimit) {
		
		this.nameString = nameString;
		this.ID = ID;
		this.bookLimit = bookLimit;
		
	}
	
	Iterator<Book> it = borrowedBooks.iterator();
	
	while(it.hasNext())
	{
		System.out.print(it.next());
	}
	
	public int getBookLimit()
	{
		return this.bookLimit;
	}

	
	
	
	
	
}
