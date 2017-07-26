package cs4050.bookstore.objectlayer;

import cs4050.bookstore.logiclayer.PayLogicImpl;
import cs4050.bookstore.logiclayer.ShipLogicImpl;

public class User {
	private int id = 0;
	private String email = null;
	private String username = null;
	private String password = null;
	private int type = 0;
	private String fname = null;
	private String lname = null;
	private Shipping shipping;
	private Payment payment;
	
	public User () {}
	
	public User(int i, String f, String l, String u, String p, String e, int t, String ship){
		id =i;
		email = e;
		username = u;
		password = p; 
		type = t;
		fname = f;
		lname = l;
	}
	
	public void loadShipping() {
		ShipLogicImpl ship = new ShipLogicImpl();
		shipping = ship.getShipping(id);
	}
	
	public void loadPayment() {
		PayLogicImpl pay = new PayLogicImpl();
		payment = pay.getPayment(id);
	}
	
	public User(int i, String f, String l, String u, String p, String e){
		id = i;
		fname = f;
		lname = l;
		username = u;
		password = p;
		email = e;
	}
	
	public User(int i, String f, String l, String u, String p, String e, int t){
		id =i;
		email = e;
		username = u;
		password = p; 
		type = t;
		fname = f;
		lname = l;
	}
	
	public User(String f, String l, String e, String u, String p, int t){
		email = e;
		username = u;
		password = p; 
		type = t;
		fname = f;
		lname = l;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirst(){
		return fname;
	}
	
	public void setFirst(String f){
		this.fname = f;
	}
	
	public String getLast(){
		return lname;
	}
	
	public void setLast(String l){
		this.lname = l;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getType() {
		return type;
	}

	public void settype(int type) {
		this.type = type;
	}

	
}//User
