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
 * Servlet implementation class MentorLogin
 */
@WebServlet("/MentorLogin")
public class MentorLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MentorLogin() {
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
			String emailid=request.getParameter("username");
			String password=request.getParameter("password");
			Connection con;
	
		Class.forName("com.mysql.jdbc.Driver");
		
			 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/str_book","aparna","aparna789");
			 HttpSession session=request.getSession();
			 String sql="select * from mentor where emailid=? and password=?";
			 PreparedStatement ps=con.prepareStatement(sql);
			 ps.setString(1, emailid);
			 ps.setString(2, password);
			 ResultSet rs=ps.executeQuery();
			 
			 if(rs.next()==false) {
				 response.sendRedirect("error.html");
			 }
			 else {
				 //rs.next();
				session.setAttribute("mentor_id", rs.getString("mentor_id"));
				System.out.println("User: "+rs.getInt("mentor_id"));
				
				request.getRequestDispatcher("MentorStudent").forward(request,response);
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
