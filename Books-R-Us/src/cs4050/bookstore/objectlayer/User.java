package cs4050.bookstore.objectlayer;

public class User {
	private int id = 0;
	private String email = null;
	private String username = null;
	private String password = null;
	private int type = 0;
	private String shipaddress = null;
	private int cardsaved = 0;
	private String fname = null;
	private String lname = null;
	
	public User () {}
	
	public User(int i, String f, String l, String u, String p, String e, int t, String ship){
		id =i;
		email = e;
		username = u;
		password = p; 
		type = t;
		shipaddress = ship;
		fname = f;
		lname = l;
	}
	
	public User(int i, String f, String l, String u, String p, String e){
		
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

	public String getShipaddress() {
		return shipaddress;
	}

	public void setShipaddress(String shipaddress) {
		this.shipaddress = shipaddress;
	}

	public int getCardsaved() {
		return cardsaved;
	}

	public void setCardsaved(int cardsaved) {
		this.cardsaved = cardsaved;
	}
	
}//User
