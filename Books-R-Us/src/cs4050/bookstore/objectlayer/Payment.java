package cs4050.bookstore.objectlayer;

public class Payment {
	private int userid;	
	private String cardNum;
	private String expDate;
	private String csc;
	private String name;
	private String billingaddr;
	
	public Payment(){};
	
	public Payment(int u, String cn, String e, String c, String n, String b){
		userid = u;
		cardNum = cn;
		expDate = e;
		csc = c;
		name = n;
		billingaddr = b; 
	};
	
	public Payment(int u, String cn, String e, String c, String n){
		userid = u;
		cardNum = cn;
		expDate = e;
		csc = c;
		name = n; 
	};
	
	
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getCardNum() {
		return cardNum;
	}
	public void setCardNum(String cardNum) {
		this.cardNum = cardNum;
	}
	public String getExpDate() {
		return expDate;
	}
	public void setExpDate(String expDate) {
		this.expDate = expDate;
	}
	public String getCsc() {
		return csc;
	}
	public void setCcs(String csc) {
		this.csc = csc;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBillingaddr() {
		return billingaddr;
	}
	public void setBillingaddr(String billingaddr) {
		this.billingaddr = billingaddr;
	}
	
	
	
	
	
	

}
