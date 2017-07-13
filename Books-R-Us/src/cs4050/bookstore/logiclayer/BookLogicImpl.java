package cs4050.bookstore.logiclayer;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import cs4050.bookstore.objectlayer.Book;
import cs4050.bookstore.persistlayer.BookPersistImpl;
import cs4050.bookstore.persistlayer.DbAccessImpl;


public class BookLogicImpl {
private BookPersistImpl bookPersist = new BookPersistImpl();
	
	public int insertBook(String title, String author, String publisher, int year, int stock, double price) {
		int r = 0;
		r = bookPersist.insertBook(title, author, publisher, year, stock, price);
		return r;
	}
	
	public int insertBook(Book b){
		return bookPersist.insertBook(b);
	}
	
	public int deleteBook(int id){
		return bookPersist.deleteBook(id);
	}
	
	public Book getBook(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("bookId"));
		return bookPersist.getBook(id);
	} // getBook
	
	public Book getBook(HttpSession session) {
		int id = (int) session.getAttribute("bookId");
		return bookPersist.getBook(id);	
	} // getUser
	
	
}
