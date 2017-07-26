package cs4050.bookstore.objectlayer;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.ArrayList;
import java.util.List;

public class DayReport {
	private double netTotal = 0;
	private String date = null;
	private String time = null;
	private List<BookSales> booksales;

	public DayReport(Date date, double net, List<BookSales> b) {
		this.netTotal = net;
		this.date = date.toString();
		Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        time = (sdf.format(cal.getTime())).toString();
        booksales = b;
	}
	
	public DayReport(String date, double net, List<BookSales> b) {
		this.netTotal = net;
		this.date = date;
		Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        time = (sdf.format(cal.getTime())).toString();
        booksales = b;
	}
	
	public DayReport(String date, double net){
		this.netTotal = net;
		this.date = date;
	}

	public double getNetTotal() {
		return netTotal;
	}

	public void setNetTotal(double netTotal) {
		this.netTotal = netTotal;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	public String getTime(){
		return time;
	}
	
	public void setTime(String time){
		this.time = time;
	}
	
	public List<BookSales> getBookSales(){
		return booksales;
	}
	
	public void setBookSales(List<BookSales> b){
		this.booksales = b;
	}
	
}//DayReport
