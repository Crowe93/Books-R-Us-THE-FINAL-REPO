package cs4050.bookstore.objectlayer;

public class Payment {
	private int userId = 0;	
	private String cardNum = null;
	private String expDate = null;
	private String csc = null;
	private String cardType = null;
	private String billingaddr = null;
	
	public Payment(){};
	
	public Payment(int u, String cn, String e, String c, String n, String b){
		userId = u;
		cardNum = cn;
		expDate = e;
		csc = c;
		cardType = n;
		billingaddr = b; 
	};
	
	public Payment(int u, String cn, String e, String c, String n){
		userId = u;
		cardNum = cn;
		expDate = e;
		csc = c;
		cardType = n; 
	};
	
	
	public int getUserId() {
		return userId;
	}
	public void setUserid(int userid) {
		this.userId = userid;
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
	public String getCardType() {
		return cardType;
	}
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}
	public String getBillingaddr() {
		return billingaddr;
	}
	public void setBillingaddr(String billingaddr) {
		this.billingaddr = billingaddr;
	}
	
	
	
	
	
	

}
