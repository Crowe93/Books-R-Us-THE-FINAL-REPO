package cs4050.bookstore.logiclayer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import cs4050.bookstore.objectlayer.User;
import cs4050.bookstore.persistlayer.UserPersistImpl;

public class UserLogicImpl {
	private UserPersistImpl userPersist = new UserPersistImpl();
	
	public void insertUser(String email, String username, String password, int type, String fname, String lname){
		userPersist.insertUser(fname, lname, email, username, password, type);
	}
	
	public int insertUser(User u){
		return userPersist.insertUser(u);
	}
	
	public void deleteUser(int id){
		userPersist.deleteUser(id);
	}
	
	public User getUser(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("userId"));
		return userPersist.getUser(id);
	} // getUser
	
	public User getUser(HttpSession session) {
		int id = (int) session.getAttribute("userId");
		return userPersist.getUser(id);	
	} // getUser
	
	public User getUser(int userId) {
		return userPersist.getUser(userId);
	}
	
	public List<User> getAllUsers(){
		return userPersist.getAllUsers();
	}
	
	public int getUserId(String userName){
		return userPersist.getUserId(userName);
	} // getUserId
	
	public int authenticateUser(String userName, String password) {
		return userPersist.authenticateUser(userName, password);
	}
	
	public boolean isAdmin(int id, String password){
		return userPersist.isAdmin(id, password);
	}
	
	public boolean cardSaved(int id){
		return userPersist.cardSaved(id);
	}
	
	public int updateUser(User u){
		int i = 0;
		int id = u.getId();
		String f = u.getFirst();
		String l = u.getLast();
		String un = u.getUsername();
		String p = u.getPassword();
		String e = u.getEmail();
		
		User oldUser = userPersist.getUser(id);
		
		if(f!=null){
			i += userPersist.updateFirstName(f,id);
		}
		if(l!=null){
			i += userPersist.updateLastName(l, id);
		}
		if(un!=null){
			i += userPersist.updateLastName(un, id);
		}
		if(p!=null){
			i += userPersist.updateLastName(p, id);
		}
		if(e!=null){
			i += userPersist.updateLastName(e, id);
		}
		
		return i;
	}
	
	
}//UserLogicImpl