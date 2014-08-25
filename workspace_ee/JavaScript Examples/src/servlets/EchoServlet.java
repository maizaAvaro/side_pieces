package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Diagnostic servlet that echos posted form contents
 */
@WebServlet("/Echo")
public class EchoServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EchoServlet() 
    {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
	}

	/**
	 * Echos all request parameter names and values
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// String[] requestParameterNames = {"firstName", "lastName", "phoneNumber", "city", "zipCode"};
		String requestName = "";
		String requestValue = "";
		Enumeration<String> parameterNames = request.getParameterNames();
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		out.println("<html>");
		out.println("<head><title>Servlet Hello</title></head>");
		out.println("<body><h1>Echo Servlet</h1>");
		out.println("<p>Welcome</p>");
		out.println("<table border='1'>");
		out.println("<tr>");
		out.println("<th>Request Parameters</th><th>Request Values</th><tr>");
		
		while(parameterNames.hasMoreElements())
		{
			requestName = parameterNames.nextElement();
			requestValue = request.getParameter(requestName);
			out.println("<td>"+requestName+"</td><td>"+requestValue+"</td><tr>");
		}
		
		out.println("<p><a href=\"index.jsp\">Back to index page</a></p>");
		out.println("</body>");
		out.println("</html>");
	}

}
