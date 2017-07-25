package cs4050.bookstore.persistlayer;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cs4050.bookstore.objectlayer.Item;

public class CartPersistImpl {
	
	//returns cart id
	public int createCart(int userId){
		
		int cartId = 0;
		
		/*
		 * CHECK IF CART EXISTS
		 * SELECT * FROM cart WHERE user_id = userId
		 */
		String cartExistsQuery = "SELECT * FROM cart WHERE user_id=" + userId+ ";";
		ResultSet existsResult = DbAccessImpl.retrieve(cartExistsQuery);
		
		try {
			//check to see if they exist
			if (existsResult.next()) {
				return existsResult.getInt("id");
			}
			//they don't exist in the database, create them now
			else {
				DbAccessImpl.create("INSERT INTO cart (user_id) VALUES ("+ userId +")");
				System.out.println("Creating new cart for user");
				DbAccessImpl.disconnect();
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		


		ResultSet result = DbAccessImpl.retrieve("SELECT id FROM cart WHERE user_id = "+  userId +";");
		try {
			while (result.next()) {
				cartId = result.getInt("id");
			} // while
		} catch (SQLException e) {
			e.printStackTrace();
		}  // try-catch
		DbAccessImpl.disconnect();
		return cartId;
		
		
	}//create cart for user
	
	public int addBookToCart(int cartId, int bookId){
		
		
		
		
		int i = -1;
		
		/*
		 * ADD BOOK TO CART
		 * INSERT INTO ITEM (cart_id, book_id, qty) VALUES (cartId, bookId, 1)
		 */
		
		String query= "INSERT INTO item (cart_id, book_id, qty) VALUES (" + cartId + ", " + bookId + ", 1);";
		
		int r = DbAccessImpl.create(query);
		DbAccessImpl.disconnect();
		return r;
	}
	
	public List<Item> getItems(int cartId){
		ResultSet result = DbAccessImpl.retrieve("SELECT * FROM item WHERE cart_id = "+  cartId +";");
		ArrayList<Item> items = new ArrayList<Item>();
		try {
			while (result.next()) {
				Item item = new Item(result.getInt("cart_id"), result.getInt("book_id"), result.getInt("qty"));
				items.add(item);
			} // while
		} catch (SQLException e) {
			e.printStackTrace();
		}  // try-catch
		DbAccessImpl.disconnect();
		
		return items;
	}
	
	public int getCartId(int userId){
		ResultSet result = DbAccessImpl.retrieve("SELECT id FROM cart WHERE user_id = "+  userId +";");
		int i = -1;
		try {
			while (result.next()) {
				i = result.getInt("id");
			} // while
		} catch (SQLException e) {
			e.printStackTrace();
		}  // try-catch
		DbAccessImpl.disconnect();
		
		return i;
	}
	
	public int itemsInCart(int userId){
		int cartId = getCartId(userId);
		
		ResultSet result = DbAccessImpl.retrieve("SELECT * FROM item WHERE cart_id = "+  cartId +";");
		int i = 0;
		try {
			while (result.next()) {
				i++;
			} // while
		} catch (SQLException e) {
			e.printStackTrace();
		}  // try-catch
		DbAccessImpl.disconnect();
		
		return i;
	}
	
	public void completePurchase(int userId){
		BookPersistImpl b = new BookPersistImpl();
		int cartId = getCartId(userId);
		List<Item> items = getItems(cartId);
		int size = items.size();
		String orderNum = Integer.toString(userId);
		orderNum.concat(Integer.toString(cartId));
		
		for(int i = 0; i<=size; i++){
			Item temp = items.get(i);
			int bookId = temp.getBookId();
			int qty = temp.getQty();
			
			int stock = b.getStock(bookId);
			stock = stock - temp.getQty();
			b.updateStock(stock, bookId);
			
			DbAccessImpl.create("INSERT INTO pastorder (orderNum, user_id, book_id, qty) "
					+ "VALUES ('"+orderNum+"', " + userId + ", " + bookId + ", " + qty + ")");
			DbAccessImpl.disconnect();
			
		}
		
		//clear cart
		
		DbAccessImpl.delete("DELETE FROM cart WHERE user_id = "+userId+";");
		
	}
	
}
