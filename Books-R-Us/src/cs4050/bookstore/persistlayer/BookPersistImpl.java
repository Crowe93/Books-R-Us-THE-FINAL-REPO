package cs4050.bookstore.persistlayer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import cs4050.bookstore.objectlayer.Book;

public class BookPersistImpl {
	public int insertBook(String title, String author, String publisher, int year, int stock, double price) {
		int r = 0;
		r = DbAccessImpl.create("INSERT INTO BOOK (title, author, publisher, year, stock, price) VALUES ('" + title + "', '" 
				+ author + "', '" + publisher + "', '" + year + "', '" + stock +"', '"+ price + "')");
		DbAccessImpl.disconnect();
		return r;
	} // insertBook
	
	public int insertBook(String title, String author, String publisher, int year, int stock) {
		int r = 0;
		r =DbAccessImpl.create("INSERT INTO BOOK (title, author, publisher, year, stock) VALUES ('" + title + "', '" 
				+ author + "', '" + publisher + "', '" + year + "', '" + stock + "')");
		DbAccessImpl.disconnect();
		return r;
	} // insertBook
	
	public int insertBook(String title, String author, String publisher, int year) {
		int r = 0;
		r = DbAccessImpl.create("INSERT INTO BOOK (title, author, publisher, year) VALUES ('" + title + "', '" 
				+ author + "', '" + publisher + "', '" + year + "')");
		DbAccessImpl.disconnect();
		return r;
	} // insertBook
	
	public int insertBook(Book b){
		int r = 0;
		
		String title = b.getTitle();
		String author = b.getAuthor();
		String publisher = b.getPublisher();
		int year = b.getYear();
		int stock = b.getStock();
		double price = b.getPrice();
		
		if(stock == 0 && price == 0){
			r = this.insertBook(title, author, publisher, year);
		}
		else if(price == 0){
			r = this.insertBook(title, author, publisher, year, stock);
		}
		else{
			r = this.insertBook(title, author, publisher, year, stock, price);
		}
		
		return r;
	}
	
	public int deleteBook(int bookId){
		String query = "DELETE BOOK FROM BOOK WHERE book.id = " + bookId;
		return DbAccessImpl.delete(query);
	}
	
	public Book getBook(int bookId){
		Book b = null;
		ResultSet result = DbAccessImpl.retrieve("SELECT title, author, publisher, genre, year, price FROM book WHERE id = "+  bookId +";");
		try {
			while (result.next()) {
				b = new Book(bookId, result.getString(1), result.getString(2), result.getString(3), result.getString(4), result.getInt(5), result.getDouble(6));
			} // while
		} catch (SQLException e) {
			e.printStackTrace();
		}  // try-catch
		DbAccessImpl.disconnect();
		return b;
	}
	
	public void updateStock(int stock, int id) {
		DbAccessImpl.update("UPDATE BOOK SET stock = " + stock + " WHERE id = " + id + ";");
		DbAccessImpl.disconnect();
	}//updateStock, id
	
	public void updateStock(int stock, String title) {
		DbAccessImpl.update("UPDATE BOOK SET stock = " + stock + " WHERE title = '" + title + "';");
		DbAccessImpl.disconnect();
	}//updateStock, title
	
	public int getStock(int id){
		ResultSet result = DbAccessImpl.retrieve("select stock from book where id = " + id+";");
		int stock = -1;
		try{
			stock = result.getInt(1);
		}
		catch (SQLException e) {
			e.printStackTrace();
		}  // try-catch
		
		return stock;
	}//getStock, id
	
	public int getStock(String title){
		ResultSet result = DbAccessImpl.retrieve("select stock from book where title = '" + title+";");
		int stock = -1;
		try{
			stock = result.getInt(1);
		}
		catch (SQLException e) {
			e.printStackTrace();
		}  // try-catch
		
		return stock;
	}//getStock, title
	
	public void updatePrice(float price, int id) {
		DbAccessImpl.update("UPDATE BOOK SET price = " + price + " WHERE id = " + id + ";");
		DbAccessImpl.disconnect();
	}//updatePrice, id
	
	public void updatePrice(float price, String title) {
		DbAccessImpl.update("UPDATE BOOK SET price = " + price + " WHERE title = '" + title + "';");
		DbAccessImpl.disconnect();
	}//updatePrice, id
	
	public float getPrice(int id){
		ResultSet result = DbAccessImpl.retrieve("select price from book where id = " + id+";");
		float price = -1;
		try{
			price = result.getFloat(1);
		}
		catch (SQLException e) {
			e.printStackTrace();
		}  // try-catch
		
		return price;
	}//getPrice, id
	
	public float getPrice(String title){
		ResultSet result = DbAccessImpl.retrieve("select price from book where title = '" + title + "';");
		float price = -1;
		try{
			price = result.getFloat(1);
		}
		catch (SQLException e) {
			e.printStackTrace();
		}  // try-catch
		
		return price;
	}//getPrice, title
	
	public void updateSold(int sold, int id) {
		DbAccessImpl.update("UPDATE BOOK SET sold = " + sold + " WHERE id = " + id + ";");
		DbAccessImpl.disconnect();
	}//updateSold, id
	
	public void updateSold(int sold, String title) {
		DbAccessImpl.update("UPDATE BOOK SET sold = " + sold + " WHERE title = '" + title + "';");
		DbAccessImpl.disconnect();
	}//updateSold, title
	
	public int getSold(int id){
		ResultSet result = DbAccessImpl.retrieve("select sold from book where id = " + id + ";");
		int sold = -1;
		try{
			sold = result.getInt(1);
		}
		catch (SQLException e) {
			e.printStackTrace();
		}  // try-catch
		
		return sold;
	}//getSold, id
	
	public int getSold(String title){
		ResultSet result = DbAccessImpl.retrieve("select sold from book where title = '" + title + "';");
		int sold = -1;
		try{
			sold = result.getInt(1);
		}
		catch (SQLException e) {
			e.printStackTrace();
		}  // try-catch
		
		return sold;
	}//getSold, title
	
}//BookPersistImpl
