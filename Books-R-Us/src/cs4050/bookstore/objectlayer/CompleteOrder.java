package cs4050.bookstore.objectlayer;

import java.util.ArrayList;

import cs4050.bookstore.logiclayer.BookLogicImpl;
import cs4050.bookstore.logiclayer.UserLogicImpl;

public class CompleteOrder {

	private String orderNum;
	private ArrayList<Book> orderBooks;
	private ArrayList<PastOrder> orderEntries;
	private String date;
	private double orderTotal;
	private String shipping = "FREE";
	private User user;
	
	public CompleteOrder(PastOrder orderEntry) {
		orderBooks = new ArrayList<Book>();
		orderEntries = new ArrayList<PastOrder>();
		orderNum = orderEntry.getOrderNum();
		date = orderEntry.getDate();

		orderEntries.add(orderEntry);
	}
	
	public void addEntry(PastOrder orderEntry) {
		orderEntries.add(orderEntry);
	}
	
	public void loadBookInfo() {
		orderBooks = new ArrayList<Book>();
		
		BookLogicImpl b = new BookLogicImpl();
		for (PastOrder entry : orderEntries) {
			Book temp = b.getBook(entry.getBookId());
			temp.setStock(entry.getQty());
			orderBooks.add(temp);
		}
		
		
		//calculate order total
		this.orderTotal = 0;
		for (Book book : orderBooks) {
			double bookVal = book.getPrice() * book.getStock();
			this.orderTotal += bookVal;
		}
		if (this.orderTotal < 50) {
			this.orderTotal += 5.99;
			this.shipping = "5.99";
		}
	}
	
	public void loadUser() {
		UserLogicImpl u = new UserLogicImpl();
		user = u.getUser(orderEntries.get(0).getUserId());
	}
}
