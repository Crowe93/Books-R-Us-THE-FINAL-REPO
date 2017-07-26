package cs4050.bookstore.persistlayer;

import java.sql.ResultSet;
import java.sql.SQLException;
import cs4050.bookstore.objectlayer.Shipping;

public class ShipPersistImpl {

	public int insertShipping(Shipping s){
		
		/*
		 * REPLACE INTO shippinginfo (user_id, street, city, state, zip) VALUES (etc)
		 */
		
		int r = DbAccessImpl.create("REPLACE INTO shippinginfo (user_id, street, city, state, zip) "
				+ "VALUES ("+s.getUserId()+", '"+s.getStreet()+"', '"+s.getCity()+"', '"+s.getState()+"', '"+s.getZip()+"');");
		DbAccessImpl.disconnect();
		return r;
	}
	
	public Shipping getShipping(int userId){
		ResultSet result = DbAccessImpl.retrieve("SELECT * FROM shippinginfo WHERE user_id = "+  userId +";");
		Shipping ship = new Shipping(userId);
		try {
			while (result.next()) {
				 ship.setStreet(result.getString("street"));
				 ship.setCity(result.getString("city"));
				 ship.setState(result.getString("state"));
				 ship.setZip(result.getString("zip"));
			} // while
		} catch (SQLException e) {
			e.printStackTrace();
		}  // try-catch
		DbAccessImpl.disconnect();
		return ship;
	}
	
	public int updateStreet(int userId, String s){
		int i = 0;
		i = DbAccessImpl.update("UPDATE shippinginfo SET street = '" + s + "' WHERE user_id = " + userId + ";");
		DbAccessImpl.disconnect();
		return i;
	}
	
	public int updateCity(int userId, String s){
		int i = 0;
		i = DbAccessImpl.update("UPDATE shippinginfo SET city = '" + s + "' WHERE user_id = " + userId + ";");
		DbAccessImpl.disconnect();
		return i;
	}
	
	public int updateState(int userId, String s){
		int i = 0;
		i = DbAccessImpl.update("UPDATE shippinginfo SET state = '" + s + "' WHERE user_id = " + userId + ";");
		DbAccessImpl.disconnect();
		return i;
	}
	
	public int updateZip(int userId, String s){
		int i = 0;
		i = DbAccessImpl.update("UPDATE shippinginfo SET zip = '" + s + "' WHERE user_id = " + userId + ";");
		DbAccessImpl.disconnect();
		return i;
	}
	
}
