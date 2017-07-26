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
	
	public int updateCardType(String n, int userId){
		return payPersist.updateCardType(n, userId);
	}
	
	public int updateBillingAddr(String b, int userId){
		return payPersist.updateBillingAddr(b, userId);
	}
	
	public int updatePayment(Payment p){
		int i = 0;
		int userId = p.getUserId();
		String cardNum = p.getCardNum();
		String expDate = p.getExpDate();
		String csc = p.getCsc();
		String cardType = p.getCardType();
		String billingAddr = p.getBillingaddr();
		
		if(cardNum!=null || cardNum != ""){
			i += payPersist.updateCardNum(cardNum, userId);
		}
		if(expDate!=null || expDate != ""){
			i += payPersist.updateExpDate(expDate, userId);
		}
		if(cardType!=null || cardType != ""){
			i += payPersist.updateCardType(cardType, userId);
		}
		if(billingAddr!=null || billingAddr != ""){
			i += payPersist.updateBillingAddr(cardNum, userId);
		}
		
		return i;
	}
	
}
