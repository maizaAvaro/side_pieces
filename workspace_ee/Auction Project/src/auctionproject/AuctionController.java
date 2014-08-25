package auctionproject;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AuctionController
 */
@WebServlet("/AuctionController")
public class AuctionController extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AuctionController() 
    {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		ServletContext ctx = this.getServletContext();
		HttpSession session = request.getSession();
		AuctionHelper helper = new AuctionHelper();
		
		request.setAttribute("catList", helper.getCategoryList());
		
		if(request.getParameter("login") != null)
		{
			request.setAttribute("error", "");
			
			if(session.getAttribute("userName") == null)
			{
				RequestDispatcher dispatcher = ctx.getRequestDispatcher("/login.jsp");
				dispatcher.forward(request, response);
				return;
			}else if(session.getAttribute("userName") != null)
			{
				RequestDispatcher dispatcher = ctx.getRequestDispatcher("/admin.jsp");
				dispatcher.forward(request, response);
				return;
			}
			
		}else if(request.getParameter("logout") != null)
		{
			session.setAttribute("logged out", true);
			session.setAttribute("userName", null);
			RequestDispatcher dispatcher = ctx.getRequestDispatcher("/welcome.jsp");
			dispatcher.forward(request, response);
			return;
			
		}else if(request.getParameter("itemID") != null)
		{
			Item sendItem = helper.getItem(Integer.parseInt(request.getParameter("itemID")));
			
			request.setAttribute("itemObject", sendItem);
			RequestDispatcher dispatcher = ctx.getRequestDispatcher("/item.jsp");
			dispatcher.forward(request, response);
			return;
		}
		
		RequestDispatcher dispatcher = ctx.getRequestDispatcher("/welcome.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		ServletContext ctx = this.getServletContext();
		HttpSession session = request.getSession();
		AuctionHelper helper = new AuctionHelper();
		
		request.setAttribute("catList", helper.getCategoryList());
		
		if(request.getParameter("userName") != null && request.getParameter("password") != null)
		{
			String userName = "ntray";
			String password = "marley1";
			
			String enteredUserName = request.getParameter("userName");
			String enteredPassword = request.getParameter("password");
			
			request.setAttribute("newUserName", enteredUserName);
			request.setAttribute("newPassword", enteredPassword);
		
			if((userName.equalsIgnoreCase(enteredUserName)) && (password.equals(enteredPassword)))
			{	
				// Successful verification of user name and password redirects to admin page
			
				session.setAttribute("userName", userName);
			
				RequestDispatcher dispatcher = ctx.getRequestDispatcher("/admin.jsp");
				dispatcher.forward(request, response);
				return;
			}else
			{
				String errorMessage = "Invalid login information. Please try again.";
				request.setAttribute("error", errorMessage);
				
				RequestDispatcher dispatcher = ctx.getRequestDispatcher("/login.jsp");
				dispatcher.forward(request, response);
				return;
			}	
		}else if(request.getParameter("itemID") != null && request.getParameter("highBid") != null && request.getParameter("bidderName") != null && request.getParameter("bidderEmail") != null)
		{
			// Add a bid on an item
			
			if((request.getParameter("highBid").isEmpty()) || (request.getParameter("bidderName").isEmpty()) || (request.getParameter("bidderEmail").isEmpty()))
			{
				helper.setErrorMessage("In order to place a bid you must fill out every field with the appropriate information.");
				String errorMessage = helper.getErrorMessage();
				
				request.setAttribute("error", errorMessage);
				
				Item sendItem = helper.getItem(Integer.parseInt(request.getParameter("itemID")));
				request.setAttribute("itemObject", sendItem);
				
				RequestDispatcher dispatcher = ctx.getRequestDispatcher("/item.jsp");
				dispatcher.forward(request, response);
				
				helper.setErrorMessage("");
				return;
			}else
			{
				int categoryID = Integer.parseInt(request.getParameter("catID"));
				String bidderName = request.getParameter("bidderName");
				String bidderEmail = request.getParameter("bidderEmail");
				double highBid = Double.parseDouble(request.getParameter("highBid"));
				int itemID = Integer.parseInt(request.getParameter("itemID"));
				
				helper.updateItemWithBid(categoryID, bidderName, bidderEmail, highBid, itemID);
				
				String errorMessage = helper.getErrorMessage();
				request.setAttribute("error", errorMessage);
				
				Item sendItem = helper.getItem(Integer.parseInt(request.getParameter("itemID")));
				
				request.setAttribute("itemObject", sendItem);
				RequestDispatcher dispatcher = ctx.getRequestDispatcher("/item.jsp");
				dispatcher.forward(request, response);
				return;
			}

		}else if(request.getParameter("itemName") != null && request.getParameter("itemDescription") != null && request.getParameter("imageURL") == null)
		{
			// Add an item in the admin view with imageUrl equal to the empty string
			if(request.getParameter("itemName").isEmpty() && request.getParameter("itemDescription").isEmpty() && request.getParameter("imageURL").isEmpty())
			{
				RequestDispatcher dispatcher = ctx.getRequestDispatcher("/admin.jsp");
				dispatcher.forward(request, response);
				return;
			}else
			{
				int categoryID = Integer.parseInt(request.getParameter("catID"));
				String itemName = request.getParameter("itemName");
				String itemDescription = request.getParameter("itemDescription");
				String imageURL = "";
				
				helper.addItemPriorToBid(categoryID, itemName, itemDescription, imageURL);
				request.setAttribute("catList", helper.getCategoryList());
				
				RequestDispatcher dispatcher = ctx.getRequestDispatcher("/admin.jsp");
				dispatcher.forward(request, response);
				return;
			}
		}else if(request.getParameter("itemName") != null && request.getParameter("itemDescription") != null && request.getParameter("imageURL") != null)
		{
			// Add an item in the admin view with imageUrl defined
			
			if(request.getParameter("itemName").isEmpty() && request.getParameter("itemDescription").isEmpty() && request.getParameter("imageURL").isEmpty())
			{
				RequestDispatcher dispatcher = ctx.getRequestDispatcher("/admin.jsp");
				dispatcher.forward(request, response);
				return;
			}else
			{
				int categoryID = Integer.parseInt(request.getParameter("catID"));
				String itemName = request.getParameter("itemName");
				String itemDescription = request.getParameter("itemDescription");
				String imageURL = request.getParameter("imageURL");
				
				helper.addItemPriorToBid(categoryID, itemName, itemDescription, imageURL);
				request.setAttribute("catList", helper.getCategoryList());
				
				RequestDispatcher dispatcher = ctx.getRequestDispatcher("/admin.jsp");
				dispatcher.forward(request, response);
				return;
			}
		}else if(request.getParameter("deleteItem") != null)
		{
			int itemID = Integer.parseInt(request.getParameter("itemID"));
			helper.deleteItem(itemID);
			
			request.setAttribute("catList", helper.getCategoryList());
			RequestDispatcher dispatcher = ctx.getRequestDispatcher("/admin.jsp");
			dispatcher.forward(request, response);
			return;
		}
		
		RequestDispatcher dispatcher = ctx.getRequestDispatcher("/welcome.jsp");
		dispatcher.forward(request, response);
	}

}
