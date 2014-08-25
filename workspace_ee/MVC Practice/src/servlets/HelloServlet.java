package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * "Hello World" Servlet that also stores user name in the Session
 * Servlet implementation class HelloServlet
 */
@WebServlet("/Hello")
public class HelloServlet extends HttpServlet
{
	
	private static final long serialVersionUID = 1L;
       
    /**
     * Constructor for the servlet
     * @see HttpServlet#HttpServlet()
     */
    public HelloServlet() 
    {
        super();
    }

	/**
	 * Respond with a cheery message
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String userName = request.getParameter("userName");
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		out.println("<html>");
		out.println("<head><title>Servlet Hello</title></head>");
		out.println("<body><h1>Hi There!</h1>");
		out.println("<p>Welcome, "+userName+"</p>");
		out.println("<p><a href=\"index.jsp\">Back to index page</a></p>");
		out.println("</body>");
		out.println("</html>");
		
	}

	/**
	 * Unused functionality as the doGet method is followed in this project iteration
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
	}

}
