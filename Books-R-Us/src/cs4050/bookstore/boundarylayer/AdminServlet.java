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

import cs4050.bookstore.logiclayer.*;
import cs4050.bookstore.objectlayer.Book;
import cs4050.bookstore.objectlayer.User;
import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapperBuilder;
import freemarker.template.SimpleHash;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;


@WebServlet("/AdminServlet")
public class AdminServlet extends HttpServlet {
		private static final long serialVersionUID = 1L;

		Configuration cfg = null;

		private String templateDir = "/WEB-INF/templates";
		String currentUser = null;


		/**
		 * @see HttpServlet#HttpServlet()
		 */
		public AdminServlet() {
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
			
			// The following Strings are used to check for a null value. Whichever string that does not have a null value is the action the client wants to perform
			String logout = request.getParameter("logout");
			String editProfileInfo = request.getParameter("");
//			String deleteAccount = request.getParameter("");

			//vendors and admin operations below
			String addBook = request.getParameter("add-button");
			String removeBook = request.getParameter("");
			String updateBook = request.getParameter("");
			String getSalesReport = request.getParameter("");
			String get = request.getParameter("");
			
			

			//begin checks to see what the input is
			if (logout!= null){ 
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
								
			} else if (addBook != null){
				String idX = request.getParameter("isbn");
				String image = request.getParameter("image");
				String title = request.getParameter("title");
				String author = request.getParameter("author");
				String publisher = request.getParameter("publisher");
				String genre = request.getParameter("genre");
				String yearX = request.getParameter("year");
				String priceX = request.getParameter("price");
				String stockX = request.getParameter("quantity");
				int id = 0;
				double price = 0;
				int year = 0;
				int stock = 0;
				
				try{
					id = Integer.parseInt(idX);
					price = Double.parseDouble(priceX);
					year = Integer.parseInt(yearX);
					stock = Integer.parseInt(stockX);
				} catch (NumberFormatException e){
				}
				
				Book book = new Book(id, title, author, publisher, genre,year, price ,0, stock, image);

				BookLogicImpl b = new BookLogicImpl();
				int r = b.insertBook(book);
				
				if (r == 1){ //enter here if book was successfully added to the database
					templateName = "adminHome.ftl";
					root.put("bookAdded","yes");

				} else {
					templateName = "adminHome.ftl";
					root.put("addBookError","yes");
				}

			} else if (removeBook != null){ 
				String idX = request.getParameter("id");
				int id = 0;
				
				try{
					id = Integer.parseInt(idX);
				} catch (NumberFormatException e){
				}
				
				BookLogicImpl b = new BookLogicImpl();
				int r = b.deleteBook(id);
				
				if (r == 1){ //enter here if book was successfully deleted from the database
					templateName = "adminHome.ftl";
					root.put("bookDeleted","yes");

				} else {
					templateName = "adminHome.ftl";
					root.put("deleteBookError","yes");
				}
				
			} else if (updateBook != null){
				String ISBNX = request.getParameter("");
				String image = request.getParameter("");
				String title = request.getParameter("");
				String author = request.getParameter("");
				String publisher = request.getParameter("");
				String genre = request.getParameter("");
				String yearX = request.getParameter("");
				String priceX = request.getParameter("");
				String stockX = request.getParameter("");
				int ISBN = 0;
				double price = 0;
				int year = 0;
				int stock = 0;
				
				try{
					ISBN = Integer.parseInt(ISBNX);
					price = Double.parseDouble(priceX);
					year = Integer.parseInt(yearX);
					stock = Integer.parseInt(stockX);
				} catch (NumberFormatException e){
				}
				
				BookLogicImpl b = new BookLogicImpl();
				int id = b.getBookId(title);
				int r = b.updateTitle(title, id);
				r = b.updateAuthor(author, id);
				r = b.updatePublisher(publisher, id);
				r = b.updateYear(year, id);
				r = b.updatePrice(price, id);
				
				templateName = "adminHome.ftl";
				root.put("bookUpdated","yes");
			} else if(editProfileInfo != null){
				
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
