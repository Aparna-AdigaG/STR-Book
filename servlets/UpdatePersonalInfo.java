package StrBook.servlet;

import java.io.*;
import java.sql.*;

import javax.servlet.http.HttpSession;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpdateStudentInfo
 */
@WebServlet("/UpdatePersonalInfo")
public class UpdatePersonalInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdatePersonalInfo() {
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
		 Connection con=null;
		 HttpSession session = request.getSession(false);

		String id=(String)session.getAttribute("stud_id");

		 try{
			 Class.forName("com.mysql.jdbc.Driver");
			 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/str_book","aparna","aparna789");
			 String address=request.getParameter("s_address");
			 String phoneno=request.getParameter("s_phoneno");
			 String email=request.getParameter("s_email");
			 String sql="update student_personal_info set s_address = ?,  s_phoneno = ? , s_email = ? where stud_id =?";
			 PreparedStatement ps = con.prepareStatement(sql);
			 RequestDispatcher requestdispatcher=request.getRequestDispatcher("PersonalInfo.html");
			 ps.setString(1,address);
			 ps.setString(2,phoneno);
			 ps.setString(3,email);
			 ps.setString(4,id);
			 int p=ps.executeUpdate();
			 requestdispatcher.forward(request, response);
			 //rs.close();
			 ps.close();
			 con.close();
		 }




			catch(SQLException e){
				e.printStackTrace();
			}
		catch(Exception e){
			e.printStackTrace();
		}
	}

}
