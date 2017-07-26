package cs4050.bookstore.boundarylayer;
import java.io.IOException;
import java.io.Writer;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import cs4050.bookstore.logiclayer.*;
import cs4050.bookstore.objectlayer.*;
import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapperBuilder;
import freemarker.template.SimpleHash;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;


@WebServlet("/Servlet")
public class Servlet extends HttpServlet {
		private static final long serialVersionUID = 1L;

		Configuration cfg = null;

		private String templateDir = "/WEB-INF/templates";
		String currentUser = null;



		/**
		 * @see HttpServlet#HttpServlet()
		 */
		public Servlet() {
			super();
		}

		public void init() {
			// Create your Configuration instance, and specify if up to what FreeMarker
			// version (here 2.3.25) do you want to apply the fixes that are not 100%
			// backward-compatible. See the Configuration JavaDoc for details.
			cfg = new Configuration(Configuration.VERSION_2_3_25);

			// Specify the source where the template files come from.
			cfg.setServletContextForTemplateLoading(getServletContext(), templateDir);

			// Sets how errors will appear.
			// This handler outputs the stack trace information to the client, formatting it so 
			// that it will be usually well readable in the browser, and then re-throws the exception.
			cfg.setTemplateExceptionHandler(TemplateExceptionHandler.HTML_DEBUG_HANDLER);
		}

		/*
		 * This method is called by the doGet method. This method will create and process the template
		 * used to display the search results or an error page if the user input is invalid.
		 */
		public void runTemplate(HttpServletRequest request, HttpServletResponse response) throws SQLException {

			Template template = null;
			String templateName = null; //template to be generated

			DefaultObjectWrapperBuilder df = new DefaultObjectWrapperBuilder(Configuration.VERSION_2_3_25);
			SimpleHash root = new SimpleHash(df.build());
			
			
			
			//*********** Example Ajax Handling *****************
			
			String loadBooks = request.getParameter("loadBooks");
			
			if (loadBooks != null)
			{
				BookLogicImpl bookLogic = new BookLogicImpl();
				List<Book> books = bookLogic.getAllBooks();
				
				try {
					sendJsonResponse(response, books);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return;
			}
			
			String searchBooks = request.getParameter("searchBooks");
			
			if (searchBooks != null)
			{
				BookLogicImpl bookLogic = new BookLogicImpl();
				int filterType = Integer.parseInt(request.getParameter("filterType"));
				String searchVal = request.getParameter("searchVal");
				List<Book> books = bookLogic.searchBooks(filterType, searchVal);
				
				try {
					sendJsonResponse(response, books);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return;
			}
				
			//***************************************************
			
			//*********** Temporary Login Testing ***************
			
			String loginAuth = request.getParameter("loginAuth");
			
			if (loginAuth != null) 
			{
				UserLogicImpl userLogic = new UserLogicImpl();
				int userId = userLogic.getUserId(request.getParameter("username"));
				User user = userLogic.getUser(userId);
				
				try {
					sendJsonResponse(response, user);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
			String userInfo = request.getParameter("userInfo");
			
			if (userInfo != null) 
			{
				UserLogicImpl userLogic = new UserLogicImpl();
				int userId = Integer.parseInt(request.getParameter("userId"));
				User user = userLogic.getUser(userId);
				
				try {
					sendJsonResponse(response, user);
				}
				catch (IOException e) {
					e.printStackTrace();
				}
				return;
			}
			
			//***************************************************
			
		
			
			
			// The following Strings are used to check for a null value. Whichever string that does not have a null value is the action the client wants to perform
			String register = request.getParameter("register");
			String login = request.getParameter("login"); 
			String logout = request.getParameter("logout");
			String addToCart = request.getParameter("addToCart");
			String viewCart = request.getParameter("viewCart");
			String removeFromCart = request.getParameter("removeFromCart");
			String editProfile = request.getParameter("editProfile");
			String deleteAccount = request.getParameter("deleteAccount");
			String checkout = request.getParameter("checkout");
			String userEnteredPromo = request.getParameter("");
			String confirmOrder = request.getParameter("confirmOrder");

			//vendors and admin operations below
			String addBook = request.getParameter("");
			String removeBook = request.getParameter("");
			String getSalesReport = request.getParameter("");
			String get = request.getParameter("");
			
			

			//begin checks to see what the input is
			if (register!= null){ // check to see if user clicked the register button on the sign up page
				System.out.println("Register triggered");
				String email = request.getParameter("email");
				String username = request.getParameter("username");
				String password = request.getParameter("password");
				String password2 = request.getParameter("password2");
				String fname = request.getParameter("fname");
				String lname = request.getParameter("lname");
				
				if(password.compareTo(password2) == 0){ //enter here if the passwords match
					System.out.println("QUERY VALUES: " + email + " " + username + " " + password + " " + fname + " " + lname);
					User user = new User(fname, lname, email, username, password, 2);
					UserLogicImpl u = new UserLogicImpl();
					int r = u.insertUser(user);
					
					if (r == 0){
						templateName = "register.ftl"; //error inserting the new user into the database.
						root.put("registerError","yes"); //username or email already used

					} else{
						templateName = "login.ftl";
						root.put("registerSuccessful","yes");

					}
				} else{ //enter here if passwords do not match
					templateName = "register.ftl";
					root.put("passwordMatchingError","yes");

				}
				
				
								
			} else if (login != null){
				System.out.println("Login triggered");
				String username = request.getParameter("username");
				String password = request.getParameter("password");

				System.out.println(username);
					UserLogicImpl u = new UserLogicImpl();
					
					int userId = u.getUserId(username);

					boolean authenticUser = u.isAdmin(userId, password);
					
					if(authenticUser){ //enter here if admin is trying to log in
						int r = u.authenticateUser(username, password);
						
						
						if(r!= 0){ //enter here if authentification is successful
							templateName = "adminHome.ftl"; 
							
							HttpSession session = request.getSession();
							synchronized(session) {
								String sessionID = session.getId();
								session.setAttribute("sessionID", sessionID);
								session.setAttribute("currentUser", username);
							}
							root.put("admin", session.getAttribute("currentUser"));
							root.put("userId", userId);
							currentUser = username;
						} else{ // enter here if authentification fails
							templateName = "login.ftl";
							root.put("failedLogin", "yes");
						}
						
					} else{ // enter here if customer is trying to log in
						int r = u.authenticateUser(username, password);
						
						if(r!= 0){ //enter here if authentification is successful
							templateName = "home.ftl"; 
							
							HttpSession session = request.getSession();
							synchronized(session) {
								String sessionID = session.getId();
								session.setAttribute("sessionID", sessionID);
								session.setAttribute("currentUser", username);
							}
							root.put("user", session.getAttribute("currentUser"));
							root.put("userId", userId);
							currentUser = username;
						} else{ // enter here if authentification fails
							templateName = "login.ftl";
							root.put("failedLogin", "yes");
						}
					}
					
			} else if (logout != null){ 
				request.getSession().invalidate();
				templateName = "home2.ftl";
				System.out.println("logout COMPLETE!");
				
			} else if (deleteAccount != null) {
				int userId = Integer.parseInt(request.getParameter("userId"));
				UserLogicImpl u = new UserLogicImpl();
				
				u.deleteUser(userId);
				
				return;
			
			} else if (addToCart != null){
				System.out.println("Starting add-to-cart sequence");
				int userId = Integer.parseInt(request.getParameter("userId"));
				int bookId = Integer.parseInt(request.getParameter("bookId"));
				BookLogicImpl b = new BookLogicImpl();
				
				Book book = b.getBook(bookId);
				System.out.println(book.getTitle());
				
				int stock = book.getStock();
				System.out.println("Stock: " + stock);
				
				ResultStatus result = new ResultStatus(0, "");
				
				if(stock != 0) { //enter here if item is in stock
					System.out.println("Creating cart for user");
					CartLogicImpl c = new CartLogicImpl();
					int cartId = c.createCart(userId); //create a cart for the user, return current cart id if it already exists

					int x = c.addBookToCart(cartId, bookId);
					
					if(x == 0){ //enter here if the book was successfully added to the cart
						System.out.println("Book successfully added to the cart");
						sendJsonStatus(response, 1, "Added to cart");
						
					} else{ //enter here if there was an error adding a book to the cart
						//root.put("bookAddError", "yes");

						sendJsonStatus(response, 1, "Added to cart");
					}
				}
				else{ //enter here if the item is not in stock
					//root.put("itemNotInStock", "yes");
					sendJsonStatus(response, 0, "Item not in stock");
				}
				
				//templateName = "search.ftl";
				return;
			
				
			} else if (removeFromCart != null){
				int userId = Integer.parseInt(request.getParameter("userId"));
				int bookId = Integer.parseInt(request.getParameter("bookId"));
				CartLogicImpl c = new CartLogicImpl();
				
				int cartId = c.getCartId(userId);
				
				c.removeBookFromCart(cartId, bookId);
				return;
				
			} else if (viewCart != null) {
				int userId = Integer.parseInt(request.getParameter("userId"));
				CartLogicImpl c = new CartLogicImpl();
				List<Item> items = c.getItems(userId);
				try {
					sendJsonResponse(response, items);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return;
				
			} else if (checkout != null) {
				int userId = Integer.parseInt(request.getParameter("userId"));
				
				
				
			} else if (editProfile != null){

				int userId = Integer.parseInt(request.getParameter("userId"));
				
				
				//basic account info
				String fname = request.getParameter("fname");
				String lname = request.getParameter("lname");
				String email = request.getParameter("email");
				String username = request.getParameter("username");
				String oldPassword = request.getParameter("oldpassword");
				String newPassword = request.getParameter("newpassword");

				//shipping info
				String street = request.getParameter("address");
				String city = request.getParameter("city");
				String state = request.getParameter("state");
				String zip = request.getParameter("zip");
				String fullAddress = street + " " + city + ", " + state + " " + zip;
				
				//payment info
				String cardType = request.getParameter("cardType");
				String cardNumber = request.getParameter("cardNum");
				String cardCVV = request.getParameter("cardccv");
				String expirationMonth = request.getParameter("expDate");
				String expirationYear = request.getParameter("expYear");
				String expirationDate = expirationMonth + "/" + expirationYear;
				UserLogicImpl u = new UserLogicImpl();
				PayLogicImpl p = new PayLogicImpl();
				ShipLogicImpl s = new ShipLogicImpl();
				
				int r = u.verifyOldPassword(userId, oldPassword);
				if(r == 0){ //enter here if the old password does not match their current password in the database
					sendJsonStatus(response, 0, "Error! Old password does not match the one in our database.");
				}else{ //enter here if the old password matches with the current password in the database
					User user = new User(userId, fname, lname, username, null, email);
					u.updateUser(user);
					Shipping sX = new Shipping(userId, street, city, state, zip);
					s.insertShipping(sX);
					p.insertPayment(userId, cardNumber, expirationDate, cardCVV, cardType, fullAddress);
					return;
				}


				
			} else if (deleteAccount != null){
				templateName = "home.ftl";
				UserLogicImpl u = new UserLogicImpl();
				u.deleteUser(u.getUserId(currentUser));
				
			} else if (userEnteredPromo != null){
				
			} else if (confirmOrder != null){

			}
				
				
				
				
	
			try {
				template = cfg.getTemplate(templateName);
				response.setContentType("text/html");
				Writer out = response.getWriter();
				template.process(root, out); 
			} catch (IOException e) {
				e.printStackTrace();
			} catch (TemplateException e) {
				e.printStackTrace();
			}
		}
		
		

		/**
		 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				try {
					runTemplate(request, response);
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}

		/**
		 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			doGet(request, response);
		}
		
		/**
		 * Helper method to return any object as a JSON-type response from the servlet
		 * @param response outgoing response from servlet
		 * @param objToEncode object to encode as a JSON-type
		 * @throws IOException 
		 */
		protected void sendJsonResponse(HttpServletResponse response, Object objToEncode) throws IOException{
		    String json = new Gson().toJson(objToEncode);
		    response.setContentType("application/json");
		    response.setCharacterEncoding("UTF-8");
		    response.getWriter().write(json);
		}
		
		protected void sendJsonStatus(HttpServletResponse response, int success, String msg){
			ResultStatus result = new ResultStatus(success, msg);
			try {
				sendJsonResponse(response, result);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		class ResultStatus {
			public int status;
			public String msg;
			
			ResultStatus(int id, String msg)
			{
				this.status = status;
				this.msg = msg;
			}
		}
}
