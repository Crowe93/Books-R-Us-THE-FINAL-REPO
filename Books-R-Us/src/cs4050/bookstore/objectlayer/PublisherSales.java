package cs4050.bookstore.objectlayer;

import java.util.Date;

public class PublisherSales {
	private int publisher_id;
	private int numSold;
	private double netTotal;
	private String date;
	
	public PublisherSales(int publisher_id, int numSold, double netTotal, String date){
		this.publisher_id=publisher_id;
		this.numSold = numSold;
		this.netTotal = netTotal;
		this.date = date;
	}
	
	public PublisherSales(int publisher_id, int numSold, double netTotal, Date date){
		this.publisher_id=publisher_id;
		this.numSold = numSold;
		this.netTotal = netTotal;
		this.date = date.toString();
	}
	
	public int getPublisher_id() {
		return publisher_id;
	}
	public void setPublisher_id(int publisher_id) {
		this.publisher_id = publisher_id;
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
