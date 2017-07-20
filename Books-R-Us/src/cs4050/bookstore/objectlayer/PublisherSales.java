package cs4050.bookstore.objectlayer;

import java.util.Date;

public class PublisherSales {
	private int publisherId = 0;
	private int numSold = 0;
	private double netTotal = 0;
	private String date = null;
	
	public PublisherSales(int publisher_id, int numSold, double netTotal, String date){
		this.publisherId=publisher_id;
		this.numSold = numSold;
		this.netTotal = netTotal;
		this.date = date;
	}
	
	public PublisherSales(int publisher_id, int numSold, double netTotal, Date date){
		this.publisherId=publisher_id;
		this.numSold = numSold;
		this.netTotal = netTotal;
		this.date = date.toString();
	}
	
	public int getPublisherId() {
		return publisherId;
	}
	public void setPublisherIdd(int publisher_id) {
		this.publisherId = publisher_id;
	}
	public int getNumberSold() {
		return numSold;
	}
	public void setNumberSold(int numberSold) {
		this.numSold = numberSold;
	}
	public double getNetTotal() {
		return netTotal;
	}
	public void setNetTotal(double netTotal) {
		this.netTotal = netTotal;
	}
	public String getDate(){
		return date;
	}
	public void setDate(String date){
		this.date = date;
	}
	public void setDate(Date date){
		this.date = date.toString();
	}
	
}
