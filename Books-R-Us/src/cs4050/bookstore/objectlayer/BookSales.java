package cs4050.bookstore.objectlayer;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import cs4050.bookstore.logiclayer.BookLogicImpl;

public class BookSales {
	private int bookId = 0;
	private String date = null;
	private int numSold = 0;
	private Book book;
	
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
	
	public BookSales(int bookId, int numSold){
		this.bookId = bookId;
		this.numSold = numSold;

		Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        
		date = (sdf.format(cal.getTime())).toString();
	}
	
	public void loadBook() {
		BookLogicImpl b = new BookLogicImpl();
		book = b.getBook(bookId);
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
