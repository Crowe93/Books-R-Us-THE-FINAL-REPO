package cs4050.bookstore.objectlayer;

public class Item {
	private int cartId; //foreign key
	private int bookId; //forign key
	private int qty;
	
	public Item(int cartId, int bookId, int qty){
		this.cartId = cartId;
		this.bookId = bookId;
		this.qty = qty;
	}
	
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
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
	
	
	
}
