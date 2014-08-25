package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import helper.*;

import java.util.*;

import org.json.simple.*;

/**

 * Receives GET and POST requests and possibly performs some action before forwarding the request,
 * either back to the same page or to a new page
 * 
 */
@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller() {
        super();
    }

	/**
	 * Handles GET requests dealing with displaying classes corresponding to a particular
	 * requirement. GET requests are also used when navigating between pages via hyperlinks.
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext ctx = this.getServletContext();
		HttpSession session = request.getSession();
		PickerDAO dao = new PickerDAO();
		String forwardAddress = "/picker.jsp";
		
		String pageToVisit = request.getParameter("page");
		
		if( pageToVisit != null ) { //visit a page
			
			if( pageToVisit.equals("picker") ) { //go from schedule page to course picker page
				request.setAttribute("requirementList", dao.getRequirementList());
				forwardAddress = "/picker.jsp";
			} else if( pageToVisit.equals("schedule") ) { //go from picker page to schedule page
				if(session.getAttribute("schedule") == null)
					session.setAttribute("schedule", new Schedule() );
				else
					request.setAttribute("schedule", session.getAttribute("schedule") );
				request.setAttribute("courseList", ((Schedule) session.getAttribute("schedule")).toJSONString() );
				forwardAddress = "/schedule.jsp";
			}
			
		} else if(request.getParameter("searchForCourses") != null)  { //get the list of courses for a given requirement
			
			int requirementID = Integer.parseInt(request.getParameter("requirementID") );
			request.setAttribute("courseList", dao.getCourseList(requirementID));
			ArrayList<Requirement> rlist = dao.getRequirementList();
			request.setAttribute("requirementList", rlist);//dao.getRequirementList());
			Requirement r = null;
			for(int i=0; i<rlist.size(); i++)
				if(rlist.get(i).getRequirementID() == requirementID)
					r = rlist.get(i);
			request.setAttribute("requirement", r);//dao.getRequirement(requirementID));
			forwardAddress = "/picker.jsp";
			
		} else { //initial visit to the site
			
			request.setAttribute("requirementList", dao.getRequirementList());
			forwardAddress = "/picker.jsp";
			
		}
			
		ctx.getRequestDispatcher(forwardAddress).forward(request, response);
	}

	/**
	 * Handles POST requests, responsible for adding and removing classes based on their call number
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext ctx = this.getServletContext();
		HttpSession session = request.getSession();
		PickerDAO dao = new PickerDAO();
		//Schedule schedule = (Schedule) session.getAttribute("schedule");
		String forwardAddress = "/picker.jsp";	
		
		if(request.getParameter("addCourse") != null) { //add a course to the session-store schedule
			
			if(session.getAttribute("schedule") == null)
				session.setAttribute("schedule", new Schedule() );
			Schedule schedule = (Schedule) session.getAttribute("schedule");
			int requirementID = Integer.parseInt( request.getParameter("rID") );
			ArrayList<Course> list = dao.getCourseList( requirementID );
			Course crs = findCourse(list, request.getParameter("courseName"));
			String callNo = request.getParameter("callNo");
			schedule.addSection( crs.getSection(callNo) );
			session.setAttribute("schedule", schedule );
			
			request.setAttribute("schedule", schedule );
			request.setAttribute("courseList", schedule.toJSONString() );
			request.setAttribute("courseList", dao.getCourseList(requirementID));
			ArrayList<Requirement> rlist = dao.getRequirementList();
			Requirement r = null;
			for(int i=0; i<rlist.size(); i++)
				if(rlist.get(i).getRequirementID() == requirementID)
					r = rlist.get(i);
			request.setAttribute("requirement", r);//dao.getRequirement(requirementID));
			request.setAttribute("requirementList", rlist);
			forwardAddress = "/picker.jsp";
			
		} else if(request.getParameter("removeCourse") != null) { //remove a course from the session-store schedule
			Schedule schedule = (Schedule)session.getAttribute("schedule");	
			schedule.removeSection(request.getParameter("callNumber"));
			session.setAttribute("schedule", schedule );
			request.setAttribute("schedule", schedule );
			request.setAttribute("courseList", schedule.toJSONString() );
			forwardAddress = "/schedule.jsp";
			
		}
		
		ctx.getRequestDispatcher(forwardAddress).forward(request, response);
	}
	
	public static Course findCourse(ArrayList<Course> list, String name) {
		for(Course c : list)
			if(c.getCourseTitle().equalsIgnoreCase(name))
				return c;
		
		return null;
	}
	


}
