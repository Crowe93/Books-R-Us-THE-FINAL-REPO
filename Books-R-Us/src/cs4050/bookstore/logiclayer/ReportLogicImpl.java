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
import cs4050.bookstore.persistlayer.ReportPersistImpl;
import cs4050.bookstore.persistlayer.DbAccessImpl;

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
	
	public int createPublisherSales(int publisherid, String date){
		return reportPersist.createPublisherSales(publisherid, date);
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
	
	/**
	 * 
	 * Field refers to what column you want to update 0=cardIn, 1=cardOut, 2=cashIn, 3=cardOut
	 * Amount is the value you want to add to current field, can be positive or negative
	 * 
	 * @param date
	 * @param field
	 * @param amount
	 * @return
	 */
	public int updateDayReport(String date, int field, double amount){
		int i = 0;
		if(reportPersist.getDayReport(date) == null){
			reportPersist.createDayReport(date);
		}
		
		if(field == 0){
			i = reportPersist.updateDayCardIn(date, amount);
		}
		else if(field == 1){
			i = reportPersist.updateDayCardOut(date, amount);
		}
		else if(field == 2){
			i = reportPersist.updateDayCashIn(date, amount);
		}
		else if(field == 3){
			i = reportPersist.updateDayCashOut(date, amount);
		}
		else{
			System.out.println(field + " is not a valid field");
		}
		
		return i;
	}
	
	public int updateDayReport(DayReport r){
		int i = 0;
		if(reportPersist.getDayReport(r.getDate()) == null){
			i = reportPersist.createDayReport(r);
		}
		else{
			
		}
		
		return i;
	}
	
	public int updateBookSales(String date, int bookId, int numSold){
		int i = 0;
		
		if(reportPersist.getBookSales(bookId, date) == null){
			reportPersist.createBookSales(bookId, date);
		}
		
		
		
		
		return i;
	}
	
	
}
