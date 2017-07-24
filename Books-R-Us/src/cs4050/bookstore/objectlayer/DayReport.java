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

	public DayReport(double net, Date date, List<BookSales> b) {
//		this.cashInTotal = cashInTotal;
//		this.cashOutTotal = cashOutTotal;
//		this.cardInTotal = cardInTotal;
//		this.cardOutTotal = cardOutTotal;
		this.netTotal = net;
		this.date = date.toString();
		Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        time = (sdf.format(cal.getTime())).toString();
        booksales = b;
	}

	public DayReport(double cashInTotal, double cashOutTotal, double cardInTotal, double cardOutTotal, String date) {
//		this.cashInTotal = cashInTotal;
//		this.cashOutTotal = cashOutTotal;
//		this.cardInTotal = cardInTotal;
//		this.cardOutTotal = cardOutTotal;
		this.netTotal = (cashInTotal + cardInTotal) - (cashOutTotal + cardOutTotal);
		this.date = date;
	}

/*	public double getCashInTotal() {
		return cashInTotal;
	}

	public void setCashInTotal(double cashInTotal) {
		this.cashInTotal = cashInTotal;
	}

	public double getCashOutTotal() {
		return cashOutTotal;
	}

	public void setCashOutTotal(double cashOutTotal) {
		this.cashOutTotal = cashOutTotal;
	}

	public double getCardInTotal() {
		return cardInTotal;
	}

	public void setCardInTotal(double cardInTotal) {
		this.cardInTotal = cardInTotal;
	}

	public double getCardOutTotal() {
		return cardOutTotal;
	}

	public void setCardOutTotal(double cardOutTotal) {
		this.cardOutTotal = cardOutTotal;
	}
*/
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
	
}//DayReport
