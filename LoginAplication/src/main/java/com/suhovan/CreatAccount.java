package com.suhovan;


import java.sql.*;
import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CreatAccount")
public class CreatAccount extends HttpServlet{
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException {
		String url = "jdbc:mysql://localhost:3306/library";
		String user_name = "root";
		String password = "1234";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, user_name, password);
			
			String fullname = req.getParameter("fullname");
			String username = req.getParameter("username");
			String email = req.getParameter("email");
			String passwd = req.getParameter("passwd");
			
			String query = String.format("SELECT SNamne FROM student WHERE SUserName = '%s'",username);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			
			if(rs.next()) {
				resp.setContentType("text/html");
				
				PrintWriter pw = resp.getWriter();
				pw.println("<h1>User alrady exist</h1>");
				pw.println("<a href = \"LogIn.html\">Go back to login page</a>");
				
		
			}
			else {
				resp.setContentType("text/html");
				
				String query2 = String.format("INSERT INTO student (SNamne,SUserName,StudentEmail,Spassword) VALUES ('%s','%s','%s','%s')",fullname,username,email,passwd);
				Statement st2 = con.createStatement();
				st2.executeUpdate(query2);
				
				PrintWriter pw = resp.getWriter();
				pw.println("<h1>thank you for joining us. </h1>");
				pw.println("<a href = \"LogIn.html\">SighIn</a>");
			}
			
			st.close();
			con.close();
		}
		catch(Exception ex) {
			ex.printStackTrace();
			resp.setContentType("text/html");
			
			PrintWriter pw = resp.getWriter();
			pw.println("<h1>error occured</h1>");
		}
	}
}	

