package cs4050.bookstore.objectlayer;

import java.util.Date;

public class BookSales {
	private int bookId = 0;
	private String date = null;
	private int numSold = 0;
	
	public BookSales(int bookId, int numSold, String date){
		this.bookId = bookId;
		this.numSold = numSold;
		this.date = date;
	}
	
	public BookSales(int bookId, int numSold, Date date){
		this.bookId = bookId;
		this.numSold = numSold;
		this.date = date.toString();
	}
	
	public String getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date.toString();
	}
	public void setDate(String date){
		this.date = date;
	}
	public int getNumSold() {
		return numSold;
	}
	public void setNumSold(int numSold) {
		this.numSold = numSold;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	
}
