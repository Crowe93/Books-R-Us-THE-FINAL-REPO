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
import cs4050.bookstore.objectlayer.PublisherSales;
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
	
	public int createPublisherSales(PublisherSales r){
		return reportPersist.createPublisherSales(r);
	}
	
	public DayReport getDayReport(String date){
		return reportPersist.getDayReport(date);
	}
	
	public List<BookSales> getBookSales(String date){
		return reportPersist.getBookSales(date);
	}
	
	public List<BookSales> getBookSales(int bookId){
		return reportPersist.getBookSales(bookId);
	}
	
	public BookSales getBookSales(int bookId, String date){
		return reportPersist.getBookSales(bookId, date);
	}
	
	
	
	public List<PublisherSales> getPublisherSales(String date){
		return reportPersist.getPublisherSales(date);
	}
		
	//returns all the sales for a specific publisher, across multiple dates
	public List<PublisherSales> getPublisherSales(int publisherId){
		return reportPersist.getPublisherSales(publisherId);
	}
	
	
	
	
	
	
}
