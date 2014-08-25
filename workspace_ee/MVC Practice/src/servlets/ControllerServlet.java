package servlets;

import helper.StringReverser;

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
 * Servlet that controls where the user is sent via the appropriate input,
 * i.e. the user cannot access the reverse.jsp page without first entering a user
 * name via the HelloServlet
 * Servlet implementation class ControllerServlet
 */
@WebServlet("/Controller")
public class ControllerServlet extends HttpServlet 
{
	
	private static final long serialVersionUID = 1L;
       
    /**
     * Constructor for the Controller servlet
     * @see HttpServlet#HttpServlet()
     */
    public ControllerServlet() 
    {
        super();
    }

	/**
	 * Respond with the page that displays the original user entered string as well as the 
	 * reverse of that string
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		ServletContext ctx = this.getServletContext();
		HttpSession session = request.getSession();
		
		if(request.getParameter("userName") != null)
		{
			
			session.setAttribute("Name", request.getParameter("userName"));
			
			RequestDispatcher dispatcher = ctx.getRequestDispatcher("/Hello");
			dispatcher.forward(request, response);
			
		}else if(!(request.getParameter("inputString").isEmpty()) && (session.getAttribute("Name") != null))
		{
			
			//System.out.println("Input String: " + request.getParameter("inputString"));
			
			String userInitialString = request.getParameter("inputString");
			request.setAttribute("originalString", userInitialString);
			
			String reversedString = StringReverser.reverseIt(userInitialString);
			request.setAttribute("reversed", reversedString);
			
			RequestDispatcher dispatcher = ctx.getRequestDispatcher("/reverse.jsp");
			dispatcher.forward(request, response);
			
		}else
		{
			
			RequestDispatcher dispatcher = ctx.getRequestDispatcher("/index.jsp");
			dispatcher.forward(request, response);
			
		}
		
	}

	/**
	 * Unused functionality as the doGet method is followed in this project iteration
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
	
	}

}
