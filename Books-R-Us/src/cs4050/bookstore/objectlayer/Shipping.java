package cs4050.bookstore.objectlayer;

public class Shipping {
	private int userId = 0;
	private String street = null;
	private String city = null;
	private String state = null;
	private String zip = null;
	
	public Shipping (int i){
		userId = i;
	}
	
	public Shipping(int i, String s, String c, String st, String z){
		userId = i;
		street = s;
		city = c;
		state = st;
		zip = z;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}
	
}
