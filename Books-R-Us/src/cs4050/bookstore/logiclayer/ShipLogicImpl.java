package cs4050.bookstore.logiclayer;

import java.sql.ResultSet;
import java.sql.SQLException;

import cs4050.bookstore.objectlayer.Shipping;
import cs4050.bookstore.persistlayer.ShipPersistImpl;

public class ShipLogicImpl {
	ShipPersistImpl shipPersist = new ShipPersistImpl();
	public int insertShipping(Shipping s){
		return shipPersist.insertShipping(s);
	}
	
	public Shipping getShipping(int userId){
		return shipPersist.getShipping(userId);
	}
	
	public int updateStreet(int userId, String s){
		return shipPersist.updateStreet(userId, s);
	}
	
	public int updateCity(int userId, String c){
		return shipPersist.updateCity(userId, c);
	}
	
	public int updateState(int userId, String s){
		return shipPersist.updateState(userId, s);
	}
	
	public int updateZip(int userId, String z){
		return shipPersist.updateZip(userId, z);
	}

}
