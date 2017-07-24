package cs4050.bookstore.logiclayer;

import java.sql.ResultSet;
import java.sql.SQLException;

import cs4050.bookstore.objectlayer.Payment;
import cs4050.bookstore.persistlayer.DbAccessImpl;
import cs4050.bookstore.persistlayer.PayPersistImpl;

public class PayLogicImpl {
	private PayPersistImpl payPersist = new PayPersistImpl();
	
	public int insertPayment(int userid, String cardNum, String expDate, String csc, String name, String billingaddr){
		return payPersist.insertPayment(userid, cardNum, expDate, csc, name, billingaddr);
	}
	
	public Payment getPayment(int userid){
		
		return payPersist.getPayment(userid);
	}
	
	public int updateCardNum(String c, int userId){
		return payPersist.updateCardNum(c, userId);
	}
	
	public int updateExpDate(String e, int userId){
		return payPersist.updateExpDate(e, userId);
	}
	
	public int updateName(String n, int userId){
		return payPersist.updateName(n, userId);
	}
	
	public int updateBillingAddr(String b, int userId){
		return payPersist.updateBillingAddr(b, userId);
	}
	
}
