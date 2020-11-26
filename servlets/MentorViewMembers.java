package StrBook.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MentorViewMembers
 */
@WebServlet("/MentorViewMembers")
public class MentorViewMembers extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MentorViewMembers() {
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
		String usn=request.getParameter("usn1");
		System.out.print(usn);
		Connection con;
		PreparedStatement ps=null,ps1=null;
		ResultSet rs=null,rs1=null;
		try {
				
			
				Class.forName("com.mysql.jdbc.Driver");
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/str_book","aparna","aparna789");
				String sql="select proj_id from works_on where usn=?";
				 ps=con.prepareStatement(sql);
				ps.setString(1, usn);
				 rs=ps.executeQuery();
				 if(rs.next()) {
									
					String s=" select usn,proj_updates from project p,works_on w where p.proj_id=w.proj_id and w.proj_id in (select proj_id from works_on where usn=?)";
					PreparedStatement ps2=con.prepareStatement(s);
					ps2.setString(1, usn);
					ResultSet rs2=ps2.executeQuery();
					RequestDispatcher requestdispatcher=request.getRequestDispatcher("ViewMembers.jsp");
					
					if(rs2.next()) {
						request.setAttribute("members", rs2);
						requestdispatcher.forward(request, response);
					}
				 }
					else {
						RequestDispatcher requestDispatcher=request.getRequestDispatcher("MentorNoInfo.html");
						requestDispatcher.forward(request, response);

					}

		
		}catch(SQLException e) {
			e.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
