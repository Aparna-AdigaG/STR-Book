package StrBook.servlet;

import java.io.*;
import java.sql.*;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class PasswordChange
 */
@WebServlet("/PasswordChange")
public class PasswordChange extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PasswordChange() {
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
			 PreparedStatement ps=null,ps1=null;
			 
			 ResultSet rs=null,rs1=null;
			 //String oldpass=request.getParameter("oldpass");
			 String newpass=request.getParameter("newpass");
			 String confirmpass=request.getParameter("confirmpass");
			 
			  
			 String sql="select * from student_academic_details where stud_id=?";
			 ps=conn.prepareStatement(sql);
			 ps.setString(1,id);
			
			 rs=ps.executeQuery();
			 while(rs.next()){
				 String pass=rs.getString("password");
				 //out.println(pass);
				 //out.println(oldpass);
				 //out.println(newpass);
				 //out.println(confirmpass);
				 PrintWriter pw=response.getWriter();

				 
				// if(oldpass.equals(pass)){
					 if(newpass.equals(confirmpass)){
						 ps1=conn.prepareStatement("update student_academic_details set password=? where stud_id =?");
						
						 ps1.setString(1,newpass);
						 ps1.setString(2,id);
						 int p=ps1.executeUpdate();
						 
						 						 

						 if(p==0){
							 pw.println("not updated");
							 //<h4> not updated</h4>
							  
						 } else{
							 pw.println("updated");
							 //<h4> updated</h4>
							  
						 }
					 }
					 else{
						 pw.println("new password and confrim password didn't match");
						 //<h3>new password and confrim password didn't match</h3>
						 
					 }
				 
			 }
				 //else{
					// pw.println("old password didn't match");
					 //<h3>old password didn't match</h3>
					  
				 //}
			// }
			 

		}
		 catch(SQLException e){
			 e.printStackTrace();
		 }
		catch(Exception e){
			e.printStackTrace();
		}

	}

}
