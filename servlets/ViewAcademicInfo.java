package StrBook.servlet;

import java.io.*;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ViewAcademicInfo
 */
@WebServlet("/ViewAcademicInfo")
public class ViewAcademicInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewAcademicInfo() {
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
		HttpSession session = request.getSession(false);
		Connection con;
		String id=(String)session.getAttribute("stud_id");
		try{
			 Class.forName("com.mysql.jdbc.Driver");
			 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/str_book","aparna","aparna789");
			 PreparedStatement ps=null;
			 ResultSet rs=null;
			 String sql="select * from student_academic_details where stud_id = ?";
			  ps=con.prepareStatement(sql);
			 ps.setString(1,id);
			  rs=ps.executeQuery();
			  RequestDispatcher requestDispatcher = request.getRequestDispatcher("ViewAcademicInfo.jsp");
			  if( rs.next()) {
					 
					//get the student info
					
					request.setAttribute("student",rs);
					requestDispatcher.forward(request, response);
						}
						else {
							request.setAttribute("error","no student information");
							requestDispatcher.forward(request, response);
							
						}

		con.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
