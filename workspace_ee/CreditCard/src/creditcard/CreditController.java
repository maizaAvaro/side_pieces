package creditcard;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CreditController
 */
@WebServlet("/Customer")
public class CreditController extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreditController() 
    {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		ServletContext ctx = this.getServletContext();
		CreditDAO dao = new CreditDAO();
		
		if(request.getParameter("customerID") != null) 
		{ 	// View customer account
			request.setAttribute("customer", dao.getCustomerByID(Integer.parseInt(request.getParameter("customerID") ) ) );
			request.setAttribute("purchaseList", dao.getPurchaseList(Integer.parseInt(request.getParameter("customerID") ) ) );
			ctx.getRequestDispatcher("/customer.jsp").forward(request, response);
		} else 
		{ 	// View customer list
			request.setAttribute("customerList", dao.getCustomerList() );
			ctx.getRequestDispatcher("/customerList.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		ServletContext ctx = this.getServletContext();
		CreditDAO dao = new CreditDAO();
		
		if(request.getParameter("customerName") != null &&
				request.getParameter("customerAddress") != null  &&
				request.getParameter("creditLimit") != null ) 
		{ 	// Add a new customer
			
			dao.addCustomer(request.getParameter("customerName"), 
								 request.getParameter("customerAddress"), 
								 request.getParameter("imageURL") == null ? "" : request.getParameter("imageURL"), 
								 Double.parseDouble( request.getParameter("creditLimit") ) );
			
			request.setAttribute("customerList", dao.getCustomerList() );
			ctx.getRequestDispatcher("/customerList.jsp").forward(request, response);
		
		} else if(request.getParameter("merchantName")!=null &&
						request.getParameter("merchantCity")!=null &&
						request.getParameter("merchantState")!=null &&
						request.getParameter("purchaseAmount")!=null) 
		{ 	// Add a purchase
				
				String error = dao.addPurchase(
						Integer.parseInt(request.getParameter("customerID") ), 
						request.getParameter("merchantName"), 
						request.getParameter("merchantCity"),
						request.getParameter("merchantState"), 
						Double.parseDouble(request.getParameter("purchaseAmount") ) );
			
				request.setAttribute("errorMessage", error);
				request.setAttribute("customer", dao.getCustomerByID(Integer.parseInt(request.getParameter("customerID") ) ) );
				request.setAttribute("purchaseList", dao.getPurchaseList(Integer.parseInt(request.getParameter("customerID") ) ) );
				ctx.getRequestDispatcher("/customer.jsp").forward(request, response);
		}
	}

}
