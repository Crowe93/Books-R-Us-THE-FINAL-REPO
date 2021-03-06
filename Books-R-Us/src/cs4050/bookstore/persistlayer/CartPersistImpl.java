package cs4050.bookstore.persistlayer;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cs4050.bookstore.objectlayer.Item;
import cs4050.bookstore.objectlayer.PastOrder;
import cs4050.bookstore.objectlayer.BookSales;
import cs4050.bookstore.objectlayer.DayReport;
import cs4050.bookstore.logiclayer.ReportLogicImpl;

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
		int qty = 0;
		ResultSet result = DbAccessImpl.retrieve("SELECT qty FROM item WHERE cart_id = "+ cartId +" AND book_id = "+bookId+";");
		try {
			while (result.next()) {
				qty = result.getInt("qty");
			} // while
		} catch (SQLException e) {
			e.printStackTrace();
		}  // try-catch
		DbAccessImpl.disconnect();
		
		if(qty == 0){
			String query= "INSERT INTO item (cart_id, book_id, qty) VALUES (" + cartId + ", " + bookId + ", 1);";
			i = DbAccessImpl.create(query);
			DbAccessImpl.disconnect();
		}
		return i;
	}
	
	public int removeBookFromCart(int cartId, int bookId) {
		/*
		 * REMOVE BOOK FROM CART
		 * DELETE FROM item WHERE cart_id = cartId AND book_id = bookId
		 */
		String query = "DELETE FROM item WHERE cart_id=" + cartId + " AND book_id=" + bookId +";";
		int rowsDeleted = DbAccessImpl.delete(query);
		DbAccessImpl.disconnect();
		
		return rowsDeleted;
	}
	
	public List<Item> getItems(int userId){
		/*
		 * RETREIVE CART FOR USER
		 * SELECT * FROM (cart, item) WHERE cart.user_id = userId AND cart.id = item.cart_id;
		 */
		ResultSet result = DbAccessImpl.retrieve("SELECT * FROM (cart, item) WHERE cart.user_id = " + userId + " AND cart.id = item.cart_id" + ";");
		ArrayList<Item> items = new ArrayList<Item>();
		try {
			while (result.next()) {
				Item item = new Item(result.getInt("cart_id"), result.getInt("book_id"), result.getInt("qty"));
				items.add(item);
			} // while
		} catch (SQLException e) {
			e.printStackTrace();
		}  // try-catch
		for (Item i : items) {
			i.loadBook();
		}
		DbAccessImpl.disconnect();
		
		return items;
	}
	
	public int updateQty(int userId, int bookId, int newQty) {
		/*
		 * UPDATE item SET qty = newQty WHERE book_id = bookId AND cart_id = cartId
		 */
		System.out.println("UPDATING CART INFO------");
		
		
		int cartId = getCartId(userId);
		
		String query = "UPDATE item SET qty = " + newQty + " WHERE book_id = " + bookId + " AND cart_id = " + cartId + ";";
		System.out.println(query);
		
		int rowsUpdated = DbAccessImpl.update(query);
		
		return rowsUpdated;
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
	
	public String completePurchase(int userId){
		BookPersistImpl b = new BookPersistImpl();
		ReportLogicImpl r = new ReportLogicImpl();
		int cartId = getCartId(userId);
		List<Item> items = getItems(userId);
		int size = items.size();
		String orderNum = Integer.toString(userId);
		orderNum = orderNum.concat(Integer.toString(cartId));
		int x = 0;
		
		
		for(int i = 0; i < size; i++){
			Item temp = items.get(i);
			int bookId = temp.getBookId();
			int qty = temp.getQty();
			
			PastOrder p = new PastOrder(orderNum, userId, bookId, qty);
			
			x = DbAccessImpl.create("INSERT INTO pastorder (orderNum, user_id, book_id, qty, date) "
					+ "VALUES ('"+orderNum+"', "+userId+", "+bookId+", "+qty+", '"+p.getDate()+"')");
			DbAccessImpl.disconnect();
			
			//updates book stock
			int stock = b.getStock(bookId);
			stock = stock - temp.getQty();
			b.updateStock(stock, bookId);
			
			//update copies sold
			int sold = b.getSold(bookId);
			sold = sold + temp.getQty();
			b.updateSold(sold, bookId);
			
			//add qty to book sales report
			BookSales s = new BookSales(bookId, qty);
			r.updateBookSales(s);
			
			//add total sales to day report
			double price = b.getPrice(bookId);
			double total = price * qty;
			DayReport d = new DayReport(s.getDate(),total);
			r.updateDayReport(d);
			
		}//for
		
		//clear cart
		if(x>0){
			DbAccessImpl.delete("DELETE FROM cart WHERE user_id = "+userId+";");
		}//if stored in past order
		
		return orderNum;
		
	}
	
}
