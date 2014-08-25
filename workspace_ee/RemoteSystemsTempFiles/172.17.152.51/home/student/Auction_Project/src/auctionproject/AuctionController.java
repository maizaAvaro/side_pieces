package auctionproject;

import java.io.IOException;
import java.util.ArrayList;

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
			RequestDispatcher dispatcher = ctx.getRequestDispatcher("/login.jsp");
			dispatcher.forward(request, response);
			
		}else if(request.getParameter("logout") != null)
		{
			session.setAttribute("logged out", true);
			RequestDispatcher dispatcher = ctx.getRequestDispatcher("/welcome.jsp");
			dispatcher.forward(request, response);
			
		}else if(request.getParameter("itemID") != null)
		{
			ArrayList<Item> checkList = helper.getItemList(Integer.parseInt(request.getParameter("categoryID")));
			Item sendItem = null;
			
			for(int i = 0; i < checkList.size(); i++)	// TODO Loop comment
			{
				if(checkList.get(i).getItemID() == Integer.parseInt(request.getParameter("itemID")))
				{
					sendItem = checkList.get(i);
				}
			}
			
			request.setAttribute("itemObject", sendItem);
			RequestDispatcher dispatcher = ctx.getRequestDispatcher("/itemView.jsp");
			dispatcher.forward(request, response);
		}
		
		RequestDispatcher dispatcher = ctx.getRequestDispatcher("/welcome.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
	}

}
