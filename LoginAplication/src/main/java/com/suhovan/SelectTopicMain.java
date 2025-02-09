package com.suhovan;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SelectTopic")
public class SelectTopicMain extends HttpServlet{
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException {
		String url = "jdbc:mysql://localhost:3306/library";
		String user_name = "root";
		String password = "1234";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, user_name, password);
			
			String SubjectName = req.getParameter("subject");
			
			String query = String.format("SELECT TopicName FROM subject_topic WHERE SubjectName = '%s'",SubjectName);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			
			String query2 = String.format("SELECT ImageSource FROM subject WHERE SubjectName = '%s'",SubjectName);
			Statement st2 = con.createStatement();
			ResultSet rs2 = st2.executeQuery(query2);
			
			if(rs.next() && rs2.next()) {
				resp.setContentType("text/html");
				
				PrintWriter pw = resp.getWriter();
				pw.println("<html><head>");
				pw.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"LogIn.css\">");
				pw.println("<head><body>");
				pw.println("<br><br><br><br><br><br><br><br><br><div class=\"log\"><br>");
				pw.println("<h2><b>Select Topic in "+SubjectName+"</b></h2>");
				pw.println("<form action=\"bookDashboard\" method =\"POST\">");
				pw.println("<select name=\"subject\" id=\"subject\">");	
				pw.println("<option value=\""+rs.getString(1)+"\">"+rs.getString(1)+"</option>");
				while(rs.next()) {
					pw.println("<option value=\""+rs.getString(1)+"\">"+rs.getString(1)+"</option>");
				}
				pw.println("</select><input type = \"submit\" class = \"signin\" value = \"Continue\"></form><br>");
				pw.println("<div class=\"logn\">");
				pw.println(" <img src=\""+rs2.getString(1)+"\" alt=\"IMAGE OF THE SUBJECT\">");
				pw.println("</div>");
				pw.println("<div class=\"bottomright\"><a href=\"mailto:sushovanpan2003@gmail.com\" ><img src=\"image/logo.jpg\"  alt=\"logo\" title=\"click here to mail me\"></a></div>");
				pw.println("<body></html>");
		
			}
			else {
				resp.setContentType("text/html");
				
				PrintWriter pw = resp.getWriter();
				pw.println("<html><head>");
				pw.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"LogIn.css\">");
				pw.println("<head><body>");
				pw.println("<br><br><br><br><br><br><br><div class=\"log\"><br>");
				pw.println("<h1>Something Went Wrong.</h1>");
				pw.println("<a href = \"LogIn.html\">Go back to login page</a>");
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
