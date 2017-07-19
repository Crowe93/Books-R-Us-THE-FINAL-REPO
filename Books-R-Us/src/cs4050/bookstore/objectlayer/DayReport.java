package cs4050.bookstore.objectlayer;

import java.sql.Date;

public class DayReport {
	private double cashInTotal = 0; 
	private double cashOutTotal = 0;
	private double cardInTotal = 0;// something scriptable with a few of our buttons. Admin looking at low inventory could click
	private double cardOutTotal = 0;// on Order to "purchase" books raising cardOut and online purchases will go to cardInTotal obviously 
	private double netTotal = 0;
	private String date = null;

	public DayReport(double cashInTotal, double cashOutTotal, double cardInTotal, double cardOutTotal, Date date) {
		this.cashInTotal = cashInTotal;
		this.cashOutTotal = cashOutTotal;
		this.cardInTotal = cardInTotal;
		this.cardOutTotal = cardOutTotal;
		this.netTotal = (cashInTotal + cardInTotal) - (cashOutTotal + cardOutTotal);
		this.date = date.toString();
	}

	public DayReport(double cashInTotal, double cashOutTotal, double cardInTotal, double cardOutTotal, String date) {
		this.cashInTotal = cashInTotal;
		this.cashOutTotal = cashOutTotal;
		this.cardInTotal = cardInTotal;
		this.cardOutTotal = cardOutTotal;
		this.netTotal = (cashInTotal + cardInTotal) - (cashOutTotal + cardOutTotal);
		this.date = date;
	}

	public double getCashInTotal() {
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
