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

import java.sql.*;
import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/adminLog")
public class AdminLoginProcess extends HttpServlet{
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException {
		String url = "jdbc:mysql://localhost:3306/library";
		String user_name = "root";
		String password = "1234";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, user_name, password);
			
			String username = req.getParameter("username");
			String passwd = req.getParameter("passwd");
			
			String query = String.format("SELECT AName FROM admin_table WHERE AUserName = '%s' AND APassword = '%s'",username,passwd);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			
			if(rs.next()) {
				resp.setContentType("text/html");
				
				PrintWriter pw = resp.getWriter();
				pw.println("<html><head>");
				pw.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"LogIn.css\">");
				pw.println("</head><body>");
				pw.println("<br><br><br><br><br><br><br><br><br><div class=\"log\">");
				pw.println("<h1>Welcome <br>"+rs.getString(1)+"</h1>");
				pw.println("<form action=\"adminDashboard.html\">");
				pw.println("<input type = \"submit\" class=\"signin\"  value = \"continue\"></form>");
				pw.println("<a href = \"AdminLogin.html\">Logout</a>");
				pw.println("</div>");
				pw.println("<div class=\"logn\">");
				pw.println("<form action=\"adminDashboard.html\">");
				pw.println(" <input type=\"image\" src=\"image/welcome2.gif\" name=\"submit\" alt=\"continue\" title=\"click here to continue\"/>");
				pw.println("</form>");
				pw.println("</div>");
				pw.println("<div class=\"bottomright\"><a href=\"mailto:sushovanpan2003@gmail.com\" ><img src=\"image/logo.jpg\"  alt=\"logo\" title=\"click here to mail me\"></a></div>");
				pw.println("</body></html>");
		
			}
			else {
				resp.setContentType("text/html");
				
				PrintWriter pw = resp.getWriter();
				pw.println("<html><head>");
				pw.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"LogIn.css\">");
				pw.println("<head><body>");
				pw.println("<br><br><br><br><br><br><br><div class=\"log\"><br>");
				pw.println("<h2><u>You<br>have<br>entered<br>wrong<br>username<br>and<br>password.</u></h2><br>");
				pw.println("<a href = \"AdminLogin.html\">Go back to login page</a>");
				pw.println("</div>");
				pw.println("<body></html>");
				
			}
			
			st.close();
			con.close();
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}
}

