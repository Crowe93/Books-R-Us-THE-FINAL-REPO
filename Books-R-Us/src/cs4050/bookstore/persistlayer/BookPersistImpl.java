package cs4050.bookstore.persistlayer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

import cs4050.bookstore.objectlayer.Book;
import cs4050.bookstore.objectlayer.BookSales;

public class BookPersistImpl {
	public int insertBook(int bookId, String title, String author, String publisher, int year, String genre, double price, int stock, String imgURL) {
		int r = 0;
		r = DbAccessImpl.create("INSERT INTO BOOK (id, title, author, publisher, year, genre, stock, price, imgURL) VALUES ("+bookId+", '" + title + "', '" 
				+ author + "', '" + publisher + "', " + year + ", '"+genre+"', " + stock +", "+ price + ", '"+imgURL+"')");
		DbAccessImpl.disconnect();
		return r;
	} // insertBook
	
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
		int id = b.getISBN();
		String title = b.getTitle();
		String author = b.getAuthor();
		String publisher = b.getPublisher();
		String genre = b.getGenre();
		int year = b.getYear();
		int stock = b.getStock();
		double price = b.getPrice();
		String imgUrl = b.getImgurl();
		
		if(stock == 0 && price == 0){
			r = this.insertBook(title, author, publisher, year);
		}
		else if(price == 0){
			r = this.insertBook(title, author, publisher, year, stock);
		}
		else{
			r = this.insertBook(id, title, author, publisher, year, genre, price, stock, imgUrl);
		}
		return r;
	}
	
	public int updateBook(int bookId, Book newBook){
		String query = MessageFormat.format(
				"UPDATE book SET id = {0}, title = \"{1}\", author = \"{2}\", publisher = \"{3}\", year = %d, genre = \"{5}\", price = \"{6}\", stock = \"{7}\", imgURL = \"{8}\", minimum = \"{9}\" WHERE id = {10}",
				newBook.getISBN(), newBook.getTitle(), newBook.getAuthor(), newBook.getPublisher(), newBook.getYear(), newBook.getGenre(), newBook.getPrice(), newBook.getStock(), newBook.getImgurl(), newBook.getMinimum(), bookId);
		query = String.format(query, newBook.getYear());
		System.out.println(query);
		return DbAccessImpl.update(query);
	}
	
	public int deleteBook(int bookId){
		String query = "DELETE FROM BOOK WHERE book.id = " + bookId;
		return DbAccessImpl.delete(query);
	}
	
	public Book getBook(int bookId){
		Book b = null;
		ResultSet result = DbAccessImpl.retrieve("SELECT * FROM book WHERE id = "+  bookId +";");
		try {
			while (result.next()) {
				b = new Book(result.getInt("id"), result.getString("title"), result.getString("author"), result.getString("publisher"), result.getString("genre"), result.getInt("year"), result.getDouble("price"), result.getInt("stock"), result.getInt("sold"), result.getString("imgURL"));
				b.setStock(result.getInt("stock"));
				b.setMinimum(result.getInt("minimum"));
			} // while
		} catch (SQLException e) {
			e.printStackTrace();
		}  // try-catch
		DbAccessImpl.disconnect();
		return b;
	}
	
	public int updateStock(int stock, int id) {
		return DbAccessImpl.update("UPDATE BOOK SET stock = " + stock + " WHERE id = " + id + ";");
	}//updateStock, id
	
	public int updateStock(int stock, String title) {
		return DbAccessImpl.update("UPDATE BOOK SET stock = " + stock + " WHERE title = '" + title + "';");
	}//updateStock, title
	
	public int getStock(int id){
		ResultSet result = DbAccessImpl.retrieve("select stock from book where id = " + id+";");
		int stock = -1;
		try{
			result.next();
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
			result.next();
			stock = result.getInt("stock");
		}
		catch (SQLException e) {
			e.printStackTrace();
		}  // try-catch
		
		return stock;
	}//getStock, title
	
	public int updatePrice(double price, int id) {
		return DbAccessImpl.update("UPDATE BOOK SET price = " + price + " WHERE id = " + id + ";");
	}//updatePrice, id
	
	public int updatePrice(double price, String title) {
		return DbAccessImpl.update("UPDATE BOOK SET price = " + price + " WHERE title = '" + title + "';");
	}//updatePrice, id
	
	public double getPrice(int id){
		ResultSet result = DbAccessImpl.retrieve("select price from book where id = " + id+";");
		float price = -1;
		try{
			result.next();
			price = result.getFloat("price");
		}
		catch (SQLException e) {
			e.printStackTrace();
		}  // try-catch
		
		return price;
	}//getPrice, id
	
	public double getPrice(String title){
		ResultSet result = DbAccessImpl.retrieve("select price from book where title = '" + title + "';");
		float price = -1;
		try{
			result.next();
			price = result.getFloat("price");
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
			sold = result.getInt("sold");
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
			sold = result.getInt("sold");
		}
		catch (SQLException e) {
			e.printStackTrace();
		}  // try-catch
		
		return sold;
	}//getSold, title
	
	public int getBookId(String title){
		ResultSet result = DbAccessImpl.retrieve("SELECT id FROM book WHERE title = '"+ title +"';");
		int id = 0;
		try {
			while (result.next()) {
				id = result.getInt("id");
			} // while
		} catch (SQLException e) {
			e.printStackTrace();
		}  // try-catch
		DbAccessImpl.disconnect();
		return id;
	}
	
	public int updateTitle(String newTitle, int id) {
		return DbAccessImpl.update("UPDATE BOOK SET title = '" + newTitle + "' WHERE id = " + id + ";");
	}
	
	public int updateAuthor(String author, int id) {
		return DbAccessImpl.update("UPDATE BOOK SET author = '" + author + "' WHERE id = " + id + ";");
	}
	
	public int updatePublisher(String publisher, int id) {
		return DbAccessImpl.update("UPDATE BOOK SET publisher = '" + publisher + "' WHERE id = " + id + ";");
	}
	
	public int updateYear(int year, int id) {
		return DbAccessImpl.update("UPDATE BOOK SET year = " + year + " WHERE id = " + id + ";");
	}
	
	public List<Book> getAllBooks(){
		ResultSet result = DbAccessImpl.retrieve("SELECT * FROM book ORDER BY price;");
		ArrayList<Book> report = new ArrayList<Book>();
		try {
			while (result.next()) {
				Book book = new Book(result.getInt("id"), result.getString("title"), result.getString("author"), result.getString("publisher"), result.getString("genre"), result.getInt("year"), result.getDouble("price"), result.getInt("stock"), result.getInt("sold"), result.getString("imgURL"));
				report.add(book);
			} // while
		} catch (SQLException e) {
			e.printStackTrace();
		}  // try-catch
		DbAccessImpl.disconnect();
		return report;
	}
	
	public List<Book> searchBooks(int filterType, String searchVal)
	{
		List<Book> results = new ArrayList<Book>();
		
		String filterBy = "";
		
		switch (filterType) {
		case 0: // title
			filterBy = "title";
			break;
		case 1: // isbn
			filterBy = "id";
			break;
		case 2: //author
			filterBy = "author";
			break;
		default:
			//wtf did you even do to get here
			break;
		}
		
		String query = "SELECT * FROM book WHERE " + filterBy + " REGEXP '" + searchVal + "' ORDER BY price;";
		
		ResultSet result = DbAccessImpl.retrieve(query);
		
		try {
			while (result.next()) {
				Book book = new Book(result.getInt("id"), result.getString("title"), result.getString("author"), result.getString("publisher"), result.getString("genre"), result.getInt("year"), result.getDouble("price"), result.getInt("stock"), result.getInt("sold"), result.getString("imgURL"));
				results.add(book);
			}
		}
		catch (SQLException e) 
		{
				e.printStackTrace();
		}
		
		DbAccessImpl.disconnect();
		return results;
	}
	
	
}//BookPersistImpl
