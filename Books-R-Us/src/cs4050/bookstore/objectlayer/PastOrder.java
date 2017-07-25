package cs4050.bookstore.objectlayer;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class PastOrder {
	private String orderNum = null;
	private int userId = 0;
	private int bookId = 0;
	private int qty = 0;
	private String date = null;
	
	public PastOrder(String o, int u, int b, int q, Date d){
		orderNum = o;
		userId = u;
		bookId = b;
		qty = q;
		date = d.toString();
	}
	
	public PastOrder(String o, int u, int b, int q, String d){
		orderNum = o;
		userId = u;
		bookId = b;
		qty = q;
		date = d;
	}
	
	public PastOrder(String o, int u, int b, int q){
		orderNum = o;
		userId = u;
		bookId = b;
		qty = q;
		
		Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        
		date = (sdf.format(cal.getTime())).toString();
	}
	
	public String getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	
}
