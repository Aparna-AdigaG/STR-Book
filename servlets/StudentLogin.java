package StrBook.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class StudentLogin
 */
@WebServlet("/StudentLogin")
public class StudentLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentLogin() {
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
		try {
			String clg_email=request.getParameter("username");
			String password=request.getParameter("password");
			Connection con;
	
		Class.forName("com.mysql.jdbc.Driver");
		
			 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/str_book","aparna","aparna789");
			 HttpSession session=request.getSession();
			 String sql="select * from student_academic_details where clg_email=? and password=?";
			 PreparedStatement ps=con.prepareStatement(sql);
			 ps.setString(1, clg_email);
			 ps.setString(2, password);
			 ResultSet rs=ps.executeQuery();
			 
			 if(rs.next()==false) {
				 response.sendRedirect("error.html");
			 }
			 else {
				 //rs.next();
				session.setAttribute("stud_id", rs.getString("stud_id"));
				System.out.println("User: "+rs.getInt("stud_id"));
				request.getRequestDispatcher("StudentHome.html").forward(request,response);
				//request.getRequestDispatcher("StudentHomeServlet.java").forward(request,response);
				return;
			 }
			 
			 rs.close();
			 ps.close();
			 con.close();
			 return;
			 
	}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	
	catch(ClassNotFoundException e) {
		e.printStackTrace();

	}
	
	}

}
