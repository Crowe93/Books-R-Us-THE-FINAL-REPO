package cs4050.bookstore.persistlayer;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cs4050.bookstore.objectlayer.Item;
import cs4050.bookstore.objectlayer.PublisherSales;


public class CartPersistImpl {
	
	//returns cart id
	public int createCart(int userId){
		int i = 0;
		i = DbAccessImpl.create("INSERT INTO cart (user_id) VALUES ("+userId+")");
		DbAccessImpl.disconnect();
		
		ResultSet result = DbAccessImpl.retrieve("SELECT id FROM cart WHERE user_id = "+  userId +";");
		try {
			while (result.next()) {
				i = result.getInt(0);
			} // while
		} catch (SQLException e) {
			e.printStackTrace();
		}  // try-catch
		DbAccessImpl.disconnect();
		return i;
		
		
	}//create cart for user
	
	public int addBookToCart(int cartId, int bookId){
		int i = -1;
		ResultSet result = DbAccessImpl.retrieve("SELECT qty FROM item WHERE cart_id = "+  cartId +";");
		try {
			while (result.next()) {
				i = result.getInt(0);
			} // while
		} catch (SQLException e) {
			e.printStackTrace();
		}  // try-catch
		DbAccessImpl.disconnect();
		
		i += i;
		
		String query= "INSERT INTO item (qty) VALUES ("+i+") WHERE cart_id = "+cartId+";";
		
		int r = DbAccessImpl.create(query);
		DbAccessImpl.disconnect();
		return r;
	}
	
	public List<Item> getItems(int cartId){
		ResultSet result = DbAccessImpl.retrieve("SELECT * FROM item WHERE cart_id = "+  cartId +";");
		ArrayList<Item> items = new ArrayList<Item>();
		try {
			while (result.next()) {
				Item item = new Item(result.getInt(0), result.getInt(1), result.getInt(2));
				items.add(item);
			} // while
		} catch (SQLException e) {
			e.printStackTrace();
		}  // try-catch
		DbAccessImpl.disconnect();
		
		return items;
	}
	
	
}
