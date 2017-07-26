package cs4050.bookstore.persistlayer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cs4050.bookstore.objectlayer.BookSales;
import cs4050.bookstore.objectlayer.DayReport;
import cs4050.bookstore.objectlayer.InventoryReport;
import cs4050.bookstore.objectlayer.Book;

public class ReportPersistImpl {
	//date format yyyy-mm-dd
	
	public int createDayReport(String date){
		int i = DbAccessImpl.create("INSERT INTO dayreport (validDate, netTotal) VALUES ('" + date + "', 0)");
		DbAccessImpl.disconnect();
		return i;
	}
	
	public int createDayReport(DayReport r){
		int i = DbAccessImpl.create("INSERT INTO dayreport (validDate, netTotal) "
				+ "VALUES ('"+r.getDate()+"', "+r.getNetTotal()+")");
		DbAccessImpl.disconnect();
		return i;
	}
	
	public int createBookSales(int bookid, String date){
		int i = DbAccessImpl.create("INSERT INTO booksales (book_id, validDate) VALUES (" +bookid+ ", '"+ date + "')");
		DbAccessImpl.disconnect();
		return i;
	}
	
	public int createBookSales(BookSales r){
		int i = DbAccessImpl.create("INSERT INTO booksales (book_id, numSold, validDate) "
				+ "VALUES (" +r.getBookId()+ ", "+r.getNumSold()+", '"+ r.getDate() + "')");
		DbAccessImpl.disconnect();
		return i;
	}
	
	public DayReport getDayReport(String date){
		List<BookSales> sales = getBookSales(date);
		
		ResultSet result = DbAccessImpl.retrieve("SELECT * FROM dayreport WHERE validDate = '"+  date +"';");
		DayReport report = null;
		try {
			while (result.next()) {
				report = new DayReport(date, result.getDouble("netTotal"), sales);
				break;
			} // while
		} catch (SQLException e) {
			e.printStackTrace();
		}  // try-catch
		DbAccessImpl.disconnect();
		
		if(report == null){
			createDayReport(date);
			getDayReport(date);
		}
		
		return report;
	}
	
	public List<BookSales> getBookSales(String date){
		ResultSet result = DbAccessImpl.retrieve("SELECT * FROM booksales WHERE validDate = '"+  date +"';");
		ArrayList<BookSales> report = new ArrayList<BookSales>();
		try {
			while (result.next()) {
				BookSales bookSales = new BookSales(result.getInt(1), result.getInt(2), result.getDate(3));
				report.add(bookSales);
			} // while
		} catch (SQLException e) {
			e.printStackTrace();
		}  // try-catch
		DbAccessImpl.disconnect();
		return report;
	}
	
	public List<BookSales> getBookSales(int bookId){
		ResultSet result = DbAccessImpl.retrieve("SELECT * FROM booksales WHERE book_id = "+  bookId +";");
		ArrayList<BookSales> report = new ArrayList<BookSales>();
		try {
			while (result.next()) {
				BookSales bookSales = new BookSales(result.getInt(1), result.getInt(2), result.getDate(3));
				report.add(bookSales);
			} // while
		} catch (SQLException e) {
			e.printStackTrace();
		}  // try-catch
		DbAccessImpl.disconnect();
		return report;
	}
	
	public BookSales getBookSales(int bookId, String date){
		ResultSet result = DbAccessImpl.retrieve("SELECT * FROM booksales WHERE book_id = "+  bookId +" "
				+ "AND validDate = '"+date+"';");
		BookSales report = null;
		try {
			while (result.next()) {
				report = new BookSales(result.getInt(1), result.getInt(2), result.getDate(3));
			} // while
		} catch (SQLException e) {
			e.printStackTrace();
		}  // try-catch
		DbAccessImpl.disconnect();
		return report;
	}

	public int updateDayNetTotal(String date, double toAdd){
		int i = 0;
		double oldAmount = 0;
		ResultSet result = DbAccessImpl.retrieve("SELECT netTotal FROM dayreport WHERE date = '"+  date +"';");
		
		try {
			while (result.next()) {
				oldAmount = result.getDouble(1);
			} // while
		} catch (SQLException e) {
			e.printStackTrace();
		}  // try-catch
		DbAccessImpl.disconnect();
		
		double newAmount = toAdd + oldAmount;
		
		i = DbAccessImpl.update("UPDATE dayreport SET netTotal = " + newAmount + " WHERE validDate = '" + date + "';");
		DbAccessImpl.disconnect();
		return i;
	}
	
	public int updateBookSales(int bookId, int numSold, String date){
		int i = 0;
		int n = 0;
		ResultSet result = DbAccessImpl.retrieve("SELECT numSold FROM booksales WHERE validDate = '"+  date +"';");
		
		try {
			while (result.next()) {
				 n = result.getInt(1);
			} // while
		} catch (SQLException e) {
			e.printStackTrace();
		}  // try-catch
		DbAccessImpl.disconnect();
		
		numSold = numSold + n;
		
		i = DbAccessImpl.update("UPDATE booksales SET numSold = " + numSold + " WHERE validDate = '" + date + "' "
				+ "AND book_id = "+bookId+";");
		DbAccessImpl.disconnect();
		return i;
	}
	
	
	public int incrementBookSales(int bookId, String date){
		int i = 0;
		
		BookSales report = this.getBookSales(bookId, date);
		int n = report.getNumSold() + 1;
		i = updateBookSales(bookId, n, date);
		
		return i;
	}
	
	public InventoryReport getInvReport(String date){
		InventoryReport ir;
		List<Book> books = new ArrayList<Book>();
		ResultSet result = DbAccessImpl.retrieve("SELECT * FROM book WHERE stock <= 5;");
		
		try {
			while (result.next()) {
				Book b = new Book(result.getInt("id"), result.getString("title"), result.getString("author"), result.getString("publisher"), result.getString("genre"), result.getInt("year"), result.getDouble("price"), result.getInt("stock"), result.getInt("sold"), result.getString("imgURL"), result.getInt("minimum"));
				books.add(b);
			} // while
		} catch (SQLException e) {
			e.printStackTrace();
		}  // try-catch
		DbAccessImpl.disconnect();
		return ir = new InventoryReport(books);
	}
	
}
