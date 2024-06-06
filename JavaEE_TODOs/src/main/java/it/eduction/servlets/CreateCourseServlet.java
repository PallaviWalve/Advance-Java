package it.eduction.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import it.eduction.dao.CourseWebDao;
import it.eduction.entity.Course;

/**
 * Servlet implementation class CreateCourseServlet
 */
@WebServlet(urlPatterns = {"/createNewCourse"},
name = "myCreateCourseServlet"
)
public class CreateCourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		String courseID = request.getParameter("course_id");
		int id=Integer.parseInt(courseID);
		
		String courseName = request.getParameter("course_name");
		
		String courseProvider = request.getParameter("course_provider");
		
		String courseDuration = request.getParameter("course_duration");
		int duration=Integer.parseInt(courseDuration);
		
		String courseFees = request.getParameter("course_fees");
		int fees=Integer.parseInt(courseFees);
		
		Course currentCourse = new Course(id,courseName,courseProvider,duration,fees);
		CourseWebDao coursewebdao = new CourseWebDao();
		boolean valid = coursewebdao.addCourse(currentCourse);
//		System.out.println("Validation Status: " + valid);
//		prepared for sending response
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String responseText = "<h1 style='color:red'>Sorry, Course Failed to add</h1>";
		if(valid)
			responseText = "<h1 style='color:green'>Congratulations, Course added</h1>";
		out.println(responseText);
	}
		
		
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
