package cs4050.bookstore.persistlayer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cs4050.bookstore.objectlayer.BookSales;
import cs4050.bookstore.objectlayer.DayReport;

public class ReportPersistImpl {
	//date format yyyy-mm-dd
	
	/**
	 * Will return 0 on failure to insert 
	 * 
	 * @param date
	 * @return number of rows altered
	 */
	public int createDayReport(String date){
		int i = DbAccessImpl.create("INSERT INTO dayreport (cashIn, cashOut, cardIn, cardOut, validDate) VALUES (0, 0, 0, 0, '" + date + "')");
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
	
	public int createPublisherSales(int publisherid, String date){
		int i = DbAccessImpl.create("INSERT INTO publishersales (publisher_id, validDate) VALUES ("+publisherid+", '" + date + "')");
		DbAccessImpl.disconnect();
		return i;
	}
	
/*	public DayReport getDayReport(String date){
		ResultSet result = DbAccessImpl.retrieve("SELECT * FROM dayreport WHERE validDate = '"+  date +"';");
		DayReport report = null;
		try {
			while (result.next()) {
				report = new DayReport( result.getDouble(1), result.getDouble(2), result.getDouble(3), result.getDouble(4), result.getString(5));
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
	}*/
	
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

	
	public int updateDayCardIn(String date, double newAmount){
		int i = 0;
		double oldAmount = 0;
		ResultSet result = DbAccessImpl.retrieve("SELECT cardIn FROM dayreport WHERE date = '"+  date +"';");
		
		try {
			while (result.next()) {
				oldAmount = result.getDouble(1);
			} // while
		} catch (SQLException e) {
			e.printStackTrace();
		}  // try-catch
		DbAccessImpl.disconnect();
		
		newAmount = newAmount + oldAmount;
		
		i = DbAccessImpl.update("UPDATE dayreport SET cardIn = " + newAmount + " WHERE validDate = '" + date + "';");
		DbAccessImpl.disconnect();
		return i;
	}
	
	public int updateDayCardOut(String date, double newAmount){
		int i = 0;
		double oldAmount = 0;
		ResultSet result = DbAccessImpl.retrieve("SELECT cardOut FROM dayreport WHERE date = '"+  date +"';");
		
		try {
			while (result.next()) {
				oldAmount = result.getDouble(1);
			} // while
		} catch (SQLException e) {
			e.printStackTrace();
		}  // try-catch
		DbAccessImpl.disconnect();
		
		newAmount = newAmount + oldAmount;
		
		i = DbAccessImpl.update("UPDATE dayreport SET cardOut = " + newAmount + " WHERE validDate = '" + date + "';");
		DbAccessImpl.disconnect();
		return i;
	}
	
	public int updateDayCashIn(String date, double newAmount){
		int i = 0;
		double oldAmount = 0;
		ResultSet result = DbAccessImpl.retrieve("SELECT cashIn FROM dayreport WHERE date = '"+  date +"';");
		
		try {
			while (result.next()) {
				oldAmount = result.getDouble(1);
			} // while
		} catch (SQLException e) {
			e.printStackTrace();
		}  // try-catch
		DbAccessImpl.disconnect();
		
		newAmount = newAmount + oldAmount;
		
		i = DbAccessImpl.update("UPDATE dayreport SET cashIn = " + newAmount + " WHERE validDate = '" + date + "';");
		DbAccessImpl.disconnect();
		return i;
	}
	
	public int updateDayCashOut(String date, double newAmount){
		int i = 0;
		double oldAmount = 0;
		ResultSet result = DbAccessImpl.retrieve("SELECT cashOut FROM dayreport WHERE date = '"+  date +"';");
		
		try {
			while (result.next()) {
				oldAmount = result.getDouble(1);
			} // while
		} catch (SQLException e) {
			e.printStackTrace();
		}  // try-catch
		DbAccessImpl.disconnect();
		
		newAmount = newAmount + oldAmount;
		
		i = DbAccessImpl.update("UPDATE dayreport SET cashOut = " + newAmount + " WHERE validDate = '" + date + "';");
		DbAccessImpl.disconnect();
		return i;
	}
	
	public int updateBookSales(int bookId, int numSold, String date){
		int i = 0;
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
	
	public int updatePublisherSales(int publisherId, int numSold, double netTotal, String date){
		int i = 0;
		
		i = DbAccessImpl.update("UPDATE publishersales SET numSold = " + numSold + ", netTotal = "+netTotal+" WHERE validDate = '" + date + "' "
				+ "AND publisher_id = "+publisherId+";");
		DbAccessImpl.disconnect();
		
		return i;
	}
	
}
