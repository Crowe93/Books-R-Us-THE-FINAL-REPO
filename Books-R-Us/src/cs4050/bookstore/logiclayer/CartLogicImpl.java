package cs4050.bookstore.logiclayer;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import cs4050.bookstore.objectlayer.Item;
import cs4050.bookstore.persistlayer.CartPersistImpl;
import cs4050.bookstore.persistlayer.DbAccessImpl;

public class CartLogicImpl {
	private CartPersistImpl cartPersist = new CartPersistImpl();
	
	
	//returns cart id
	public int createCart(int userId){
		return cartPersist.createCart(userId);
		
		
	}//create cart for user
	
	public int addBookToCart(int cartId, int bookId){
		return cartPersist.addBookToCart(cartId, bookId);
	}
		
	public List<Item> getItems(int cartId){
		return cartPersist.getItems(cartId);
	}
	
}