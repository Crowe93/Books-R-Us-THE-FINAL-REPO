package cs4050.bookstore.persistlayer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cs4050.bookstore.objectlayer.*;

public class PayPersistImpl {
	public int insertPayment(int userid, String cardNum, String expDate, String csc, String name, String billingaddr){
		int i = DbAccessImpl.create("INSERT INTO payment (userid, cardNum, expDate, csc, cardType, billingaddr) VALUES ('" + userid + "', '" 
				+ cardNum + "', '" + expDate + "', '" + csc + "', '" + name + "', '" + billingaddr + "')");
		
		DbAccessImpl.disconnect();
		return i;
	}//insertPayment
	
	public Payment getPayment(int userid){
		ResultSet result = DbAccessImpl.retrieve("SELECT * FROM payment WHERE user_id = "+  userid +";");
		Payment pay = null;
		try {
			while (result.next()) {
				pay = new Payment(userid, result.getString("cardNum"), result.getString("expDate"), result.getString("csc"), result.getString("cardType"), result.getString("billingAddr"));
			} // while
		} catch (SQLException e) {
			e.printStackTrace();
		}  // try-catch
		DbAccessImpl.disconnect();
		
		return pay;
	}
	
	public int updateCardNum(String c, int userId){
		int i = 0;
		i = DbAccessImpl.update("UPDATE payment SET cardNum = '" + c + "' WHERE user_id = " + userId + ";");
		DbAccessImpl.disconnect();
		return i;
	}
	
	public int updateExpDate(String e, int userId){
		int i = 0;
		i = DbAccessImpl.update("UPDATE payment SET expDate = '" + e + "' WHERE user_id = " + userId + ";");
		DbAccessImpl.disconnect();
		return i;
	}
	
	public int updateCardType(String n, int userId){
		int i = 0;
		i = DbAccessImpl.update("UPDATE payment SET cardType = '" + n + "' WHERE user_id = " + userId + ";");
		DbAccessImpl.disconnect();
		return i;
	}
	
	public int updateBillingAddr(String b, int userId){
		int i = 0;
		i = DbAccessImpl.update("UPDATE payment SET billingaddr = '" + b + "' WHERE user_id = " + userId + ";");
		DbAccessImpl.disconnect();
		return i;
	}
	
	
	
}
