import java.util.Vector;

public class Book {
	
	public String title;
	public int availableCopies;
	public Vector<String> borrowedBy;
	
	public Book(String title, int copies)
	{
		this.title = title;
		this.availableCopies = copies; 
		
	}
	
	
	public boolean isBorrowedBy(String target)
	{
		for(String name : borrowedBy)
		{
			if(target != null && target.equals(name))
			{
				
				return true;
			}
		}
			
		return true;
	}
	
	public boolean isAvailableForBorrow()
	{
		if(availableCopies > 0)
		{
			return true;
		}
		return false;
	}
	
//	public void registerBookBorrow()
//	{
//		
//	}
	
//	public Book 
//	
	/*
	 * The prototype is successful when a reader can be registered, 
	 * a book can be added, 
	 * and a valid borrowing request changes that book’s availability in the running application.
	 * */
	
}
