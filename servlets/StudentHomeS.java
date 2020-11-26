package StrBook.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

/**
 * Servlet implementation class StudentHome
 */
@WebServlet("/StudentHomeS")
public class StudentHomeS extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentHomeS() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
			String choice=(String)request.getParameter("info");
			if(choice.equals("personal info"))
			{
				request.getRequestDispatcher("PersonalInfo.html").forward(request,response);
			}
			else if(choice.equals("academic details")) {
				request.getRequestDispatcher("AcademicDetails.html").forward(request,response);
			}
			else if(choice.equals("results")) {
				request.getRequestDispatcher("Results.jsp").forward(request, response);
			}
			else if(choice.equals("extra activities")) {
				request.getRequestDispatcher("ExtraCurricular.html").forward(request, response);
			}
			else {
				request.getRequestDispatcher("Project.html").forward(request, response);
			}
			
			
			
			
	}

}
