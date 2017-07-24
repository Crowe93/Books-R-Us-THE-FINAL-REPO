package cs4050.bookstore.objectlayer;

import java.util.ArrayList;
import java.util.List;

public class InventoryReport {
	private List<Book> books;
	
	public InventoryReport(List<Book> b){
		books = b;
	}
	
	public List<Book> getBooks(){
		return books;
	}
}
