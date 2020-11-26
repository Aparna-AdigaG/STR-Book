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
 * Servlet implementation class ViewECInfo
 */
@WebServlet("/ViewECInfo")
public class ViewECInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewECInfo() {
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
		String id=(String)session.getAttribute("stud_id");
		 Connection conn=null;

		 try{
			 Class.forName("com.mysql.jdbc.Driver");
			 conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/str_book","aparna","aparna789");
			 PreparedStatement ps=null;
			 ResultSet rs=null;
			 
				 String sql=" select * from extra_curricular where usn = (select e.usn from student_personal_info p,student_academic_details d,extra_curricular e where p.stud_id=d.stud_id and d.usn=e.usn and p.stud_id = ?)";
				 ps=conn.prepareStatement(sql);
				 ps.setString(1,id);
				 rs=ps.executeQuery();
				 RequestDispatcher requestdispatcher=request.getRequestDispatcher("ViewECInfo.jsp");
				 if(rs.next()) {
					 request.setAttribute("student",rs);
					 requestdispatcher.forward(request, response);
					}
					else {
						RequestDispatcher requestDispatcher=request.getRequestDispatcher("NoInfo.html");
						requestDispatcher.forward(request, response);
						
					}

					 
				 
				 
		 }catch(SQLException e) {
			 e.printStackTrace();
		 }catch(Exception e) {
			 e.printStackTrace();
		 }
	}

}
