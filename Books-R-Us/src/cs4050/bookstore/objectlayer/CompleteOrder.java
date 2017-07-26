package cs4050.bookstore.objectlayer;

import java.util.ArrayList;

import cs4050.bookstore.logiclayer.BookLogicImpl;

public class CompleteOrder {

	private String orderNum;
	private ArrayList<Book> orderBooks;
	private ArrayList<PastOrder> orderEntries;
	private String date;
	
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
	}
}
