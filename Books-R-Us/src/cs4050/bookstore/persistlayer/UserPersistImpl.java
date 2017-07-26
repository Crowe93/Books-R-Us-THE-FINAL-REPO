package cs4050.bookstore.persistlayer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cs4050.bookstore.objectlayer.Item;
import cs4050.bookstore.objectlayer.User;
import cs4050.bookstore.persistlayer.DbAccessImpl;

public class UserPersistImpl {
	
	public int insertUser(String firstName, String lastName, String email, String userName, String password, int seclevel) {
		String query= "INSERT INTO USER (fname, lname, email, username, password, type) VALUES ('" + firstName + "', '" 
				+ lastName + "', '" + email + "', '" + userName + "', '" + password + "', '" + seclevel + "')";
		
		int r = DbAccessImpl.create(query);
		DbAccessImpl.disconnect();
		return r;
	} // insertUser
	
	public int insertUser(User u) {
		String firstName = u.getFirst();
		String lastName = u.getLast();
		String email = u.getEmail();
		String userName = u.getUsername();
		String password = u.getPassword();
		int type = u.getType();
		
		int r = DbAccessImpl.create("INSERT INTO USER (fname, lname, email, username, password, type) VALUES ('" + firstName + "', '" 
				+ lastName + "', '" + email + "', '" + userName + "', '" + password + "', '" + type + "')");
		DbAccessImpl.disconnect();
		return r;
	} // insertUser
	
	public int deleteUser(int id){
		String query = "DELETE FROM user WHERE id = " + id;
		return DbAccessImpl.delete(query);
	} // deleteUser
	
	public int deleteUser(String username){
		String query = "DELETE FROM user WHERE username = '" + username+"'";
		return DbAccessImpl.delete(query);
	} // deleteUser
	
	public User getUser(int userId) {
		ResultSet result = DbAccessImpl.retrieve("SELECT * FROM user WHERE id = "+  userId +";");
		User user = null;
		try {
			while (result.next()) {
				user = new User(userId, result.getString("fname"), result.getString("lname"), result.getString("username"), result.getString("password"), result.getString("email"), result.getInt("type"), "");
				user.loadPayment();
				user.loadShipping();
			} // while
		} catch (SQLException e) {
			e.printStackTrace();
		}  // try-catch
		DbAccessImpl.disconnect();
		return user;
	} // getUser
	
	public List<User> getAllUsers(){
		ResultSet result = DbAccessImpl.retrieve("SELECT * FROM user;");
		ArrayList<User> users = new ArrayList<User>();
		try {
			while (result.next()) {				
				User user = new User(result.getInt("id"), result.getString("fname"), result.getString("lname"), result.getString("username"), result.getString("password"), result.getString("email"), result.getInt("type"), "");
				users.add(user);
			} // while
		} catch (SQLException e) {
			e.printStackTrace();
		}  // try-catch
		DbAccessImpl.disconnect();
		
		return users;	
	}
	
	public int getUserId(String username){
		ResultSet result = DbAccessImpl.retrieve("SELECT id FROM user WHERE username = '"+ username +"';");
		int id = 0;
		try {
			while (result.next()) {
				id = result.getInt(1);
			} // while
		} catch (SQLException e) {
			e.printStackTrace();
		}  // try-catch
		DbAccessImpl.disconnect();
		return id;
	}
	
	public int updateFirstName(String fname, int userId) {
		int i = 0;
		i = DbAccessImpl.update("UPDATE user SET fname = '" + fname + "' WHERE id = " + userId + ";");
		DbAccessImpl.disconnect();
		return i;
	}//updateUsername
	
	public int updateLastName(String lname, int userId) {
		int i = 0;
		i = DbAccessImpl.update("UPDATE user SET lname = '" + lname + "' WHERE id = " + userId + ";");
		DbAccessImpl.disconnect();
		return i;
	}//updateUsername
	
	public int updateUsername(String username, int userId) {
		int i = 0;
		System.out.println("Updating username");
		i = DbAccessImpl.update("UPDATE user SET username = '" + username + "' WHERE id = " + userId + ";");
		DbAccessImpl.disconnect();
		return i;
	}//updateUsername
	
	public String getUsername(int userId) {
		ResultSet result = DbAccessImpl.retrieve("SELECT username FROM user WHERE id = "+  userId +";");
		String username = null;
		try {
			while (result.next()) {
				username = result.getString("username");
			} // while
		} catch (SQLException e) {
			e.printStackTrace();
		}  // try-catch
		DbAccessImpl.disconnect();
		return username;
	}//getUsername
	
	public int updatePassword(String password, int userId) {
		int i = DbAccessImpl.update("UPDATE user SET password = '" + password + "' WHERE id = " + userId + ";");
		DbAccessImpl.disconnect();
		return i;
	}//updatePassword
	
	public String getPassword(int userId) {
		ResultSet result = DbAccessImpl.retrieve("SELECT password FROM user WHERE id = "+  userId +";");
		String password = null;
		try {
			while (result.next()) {
				password = result.getString("password");
			} // while
		} catch (SQLException e) {
			e.printStackTrace();
		}  // try-catch
		DbAccessImpl.disconnect();
		return password;
	}//getPassword
	
	public int updateEmail(String email, int userId) {
		int r = DbAccessImpl.update("UPDATE user SET email = '" + email + "' WHERE id = " + userId + ";");
		DbAccessImpl.disconnect();
		return r;
	}//updateEmail
	
	public String getEmail(int userId) {
		ResultSet result = DbAccessImpl.retrieve("SELECT email FROM user WHERE id = "+  userId +";");
		String email = null;
		try {
			while (result.next()) {
				email = result.getString("email");
			} // while
		} catch (SQLException e) {
			e.printStackTrace();
		}  // try-catch
		DbAccessImpl.disconnect();
		return email;
	}//getEmail
	
	public int getType(int userId){
		ResultSet result = DbAccessImpl.retrieve("SELECT type FROM user WHERE id = "+  userId +";");
		int type = 0;
		try {
			while (result.next()) {
				type = result.getInt("type");
			} // while
		} catch (SQLException e) {
			e.printStackTrace();
		}  // try-catch
		DbAccessImpl.disconnect();
		return type;
	}
	
	public int authenticateUser(String userName, String password){
		int id = 0;
		String query = 
				"SELECT id FROM USER WHERE username = '"+userName+"' AND password = '"+password+"'";
		ResultSet resultSet = null;
		
		try{
			resultSet = DbAccessImpl.retrieve(query);
			if(resultSet.next()){
				id = resultSet.getInt("id");
			}
			resultSet.close();
		} catch (SQLException e){
			e.printStackTrace();
		} finally {
			DbAccessImpl.disconnect();
		} // try-catch
		return id;
	}
	
	public boolean isAdmin(int userId, String password){
		int type = 0;
		String query = 
				"SELECT type FROM USER WHERE id = "+userId+" and password = '"+password+"'";
		ResultSet resultSet = null;
		
		try{
			resultSet = DbAccessImpl.retrieve(query);
			if(resultSet.next()){
				type = resultSet.getInt("type");
			}
			resultSet.close();
		} catch (SQLException e){
			e.printStackTrace();
		} finally {
			DbAccessImpl.disconnect();
		} // try-catch
		
		if(type == 1){
			return true;
		}
		else{
			return false;
		}
	}
	
	public boolean cardSaved(int userId){
		boolean saved = false;
		
		String query = 
				"SELECT name FROM payment WHERE user_id = "+userId;
		
		ResultSet resultSet = null;
		resultSet = DbAccessImpl.retrieve(query);
		
		if(resultSet == null){
			return saved;
		}
		else{
			saved = true;
			return saved;
		}
	}
	
	public int verifyOldPassword(int userId, String password){
		int r = 0;
		String query = 
				"SELECT id FROM USER WHERE id = "+userId+" AND password = '"+password+"'";
		ResultSet resultSet = null;
		
		try{
			resultSet = DbAccessImpl.retrieve(query);
			if(resultSet.next()){
				r = resultSet.getInt("id");
			}
			resultSet.close();
		} catch (SQLException e){
			e.printStackTrace();
		} finally {
			DbAccessImpl.disconnect();
		} // try-catch
		return r;
	}

}
