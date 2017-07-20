package cs4050.bookstore.boundarylayer;
import java.io.IOException;
import java.io.Writer;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import cs4050.bookstore.logiclayer.BookLogicImpl;
import cs4050.bookstore.logiclayer.UserLogicImpl;
import cs4050.bookstore.objectlayer.User;
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
			String test = request.getParameter("test");
			
			if (test != null)
			{
				ExampleJSON testJson = new ExampleJSON(1, "Here is some theorhetical data being returned");
				try {
					sendJsonResponse(response, testJson);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return;
			}
			
			String loadBooks = request.getParameter("loadBooks");
			
			if (loadBooks != null)
			{
				BookLogicImpl bookLogic = new BookLogicImpl();
				
				
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
			
			//***************************************************
			
		
			
			
			// The following Strings are used to check for a null value. Whichever string that does not have a null value is the action the client wants to perform
			String register = request.getParameter("register");
			String login = request.getParameter("login"); 
			String logout = request.getParameter("logout");
			String addToCart = request.getParameter("");
			String removeFromCart = request.getParameter("");
			String editProfileInfo = request.getParameter("");
			String deleteAccount = request.getParameter("");
			String userEnteredPromo = request.getParameter("");
			String order = request.getParameter("");

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
				String fname = request.getParameter("fname");
				String lname = request.getParameter("lname");
				
				System.out.println("QUERY VALUES: " + email + " " + username + " " + password + " " + fname + " " + lname);
				User user = new User(fname, lname, email, username, password, 2);
				UserLogicImpl u = new UserLogicImpl();
				int r = u.insertUser(user);
				
				if (r == 0){
					templateName = "signup.ftl"; //error inserting the new user into the database.
					root.put("registerError","yes");

				} else{
					root.put("registerSuccessful","yes");
					templateName = "login.ftl";
				}
								
			} else if (login != null){
				System.out.println("Login triggered");
				String username = request.getParameter("username");
				String password = request.getParameter("password");

				System.out.println(username);
					UserLogicImpl u = new UserLogicImpl();
					User user = u.getUser(u.getUserId(username));
					
					
					boolean authenticUser = u.isAdmin(u.getUserId(username), password);
					
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
							root.put("userId", user.getId());
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
							root.put("userId", user.getId());
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
				
			} else if (addToCart != null){
				
			} else if (removeFromCart != null){
				
			} else if (editProfileInfo != null){
				
			} else if (deleteAccount != null){
				templateName = "home.ftl";
				UserLogicImpl u = new UserLogicImpl();
				u.deleteUser(u.getUserId(currentUser));
				
			} else if (userEnteredPromo != null){
				
			} else if (order != null){
				
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
		
		class ExampleJSON {
			public int id;
			public String data;
			
			ExampleJSON(int id, String data)
			{
				this.id = id;
				this.data = data;
			}
		}
}
