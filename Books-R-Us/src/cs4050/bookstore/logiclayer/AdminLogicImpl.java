package cs4050.bookstore.logiclayer;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import cs4050.bookstore.objectlayer.User;
import cs4050.bookstore.persistlayer.UserPersistImpl;

public class AdminLogicImpl {
	UserPersistImpl userPersist = new UserPersistImpl();
	
	public int deleteUser(int userId){
		int i = 0;
		
		
		
		return i;
	}
	
	
	public int deleteUser(String username){
		int i = 0;
		
		return i;
	}
	
	
}
