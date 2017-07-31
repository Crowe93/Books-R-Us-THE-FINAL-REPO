package cs4050.bookstore.logiclayer;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import cs4050.bookstore.objectlayer.BookSales;
import cs4050.bookstore.objectlayer.DayReport;
import cs4050.bookstore.objectlayer.InventoryReport;
import cs4050.bookstore.persistlayer.ReportPersistImpl;

public class ReportLogicImpl {
	private ReportPersistImpl reportPersist = new ReportPersistImpl();
	
	public int createDayReport(String date){
		return reportPersist.createDayReport(date);
	}
	
	public int createDayReport(DayReport r){
		return reportPersist.createDayReport(r);
	}

	public int createBookSales(int bookid, String date){
		return reportPersist.createBookSales(bookid, date);
	}
	
	public int createBookSales(BookSales r){
		return reportPersist.createBookSales(r);
	}
	
	public DayReport getDayReport(String date){
		return reportPersist.getDayReport(date);
	}
	
	//returns all book sales for a given date
	public List<BookSales> getBookSales(String date){
		return reportPersist.getBookSales(date);
	}
	
	//returns all books sales for a given book
	public List<BookSales> getBookSales(int bookId){
		return reportPersist.getBookSales(bookId);
	}
	
	//returns the books sales for a given book on a specific date
	public BookSales getBookSales(int bookId, String date){
		return reportPersist.getBookSales(bookId, date);
	}
	
	
	public int updateDayReport(String date, double toAdd){
		int i = 0;
		if(reportPersist.getDayReport(date) == null){
			reportPersist.createDayReport(date);
			i = reportPersist.updateDayNetTotal(date, toAdd);
		}
		else{
			i = reportPersist.updateDayNetTotal(date, toAdd);
		}
		return i;
	}
	
	//takes a DayReport object that holds the date to be modified and the amount to ADD to the database
	public int updateDayReport(DayReport r){
		int i = 0;
		if(reportPersist.getDayReport(r.getDate()) == null){
			reportPersist.createDayReport(r);
			i = reportPersist.updateDayNetTotal(r.getDate(), r.getNetTotal());
		}
		else{
			i = reportPersist.updateDayNetTotal(r.getDate(), r.getNetTotal());
		}
		return i;
	}
	
	public int updateBookSales(String date, int bookId, int numSold){
		int i = 0;
		
		if(reportPersist.getBookSales(bookId, date) == null){
			reportPersist.createBookSales(bookId, date);
			i = reportPersist.updateBookSales(bookId, numSold, date);
		}
		else{
			i = reportPersist.updateBookSales(bookId, numSold, date);
		}
		
		return i;
	}
	
	public InventoryReport getInvReport(){
		return reportPersist.getInvReport();
	}
	
	public int updateBookSales(BookSales b){
		int i = 0;
		
		if(reportPersist.getBookSales(b.getBookId(), b.getDate()) == null){
			reportPersist.createBookSales(b.getBookId(), b.getDate());
			i = reportPersist.updateBookSales(b.getBookId(), b.getNumSold(), b.getDate());
		}
		else{
			i = reportPersist.updateBookSales(b.getBookId(), b.getNumSold(), b.getDate());
		}
		
		return i;
	}
}
