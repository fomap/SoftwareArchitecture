package com.example.library.model;


public class Book { //adamsha class 
	
	private Long _id;
	private String _title;
	private boolean _available = true;
	
	
	public Book() {}
	
	public Long getID() { return  _id; }
	public void setID(Long id) {this._id = id; }
	
	public String getTitle() { return _title;}
	public void setTitle(String title) { this._title = title; }
	
	public boolean getAvailable() { return _available;}
	public void setAvailable(boolean bool) {this._available = bool;}
	
}
