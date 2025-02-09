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

@WebServlet("/createDeptDatabase")
public class CreateDeptDatabase extends HttpServlet{
		public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException {
			String url = "jdbc:mysql://localhost:3306/library";
			String user_name = "root";
			String password = "1234";
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection(url, user_name, password);
				String SubjectName = req.getParameter("Department");
				String query = String.format("SELECT ImageSource FROM subject WHERE SubjectName = '%s'",SubjectName);
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(query);
				
				if(rs.next()) {
					resp.setContentType("text/html");
					
					PrintWriter pw = resp.getWriter();
					pw.println("<h1>Department alrady exist</h1>");
					pw.println("<a href = \"CreateDorT\">Go back</a>");
					
			
				}
				else {
					String ImageSource = req.getParameter("ImageSource");

					String query2 = String.format("INSERT INTO subject(SubjectName,ImageSource) VALUES('%s','%s')",SubjectName,ImageSource);
					Statement st2 = con.createStatement();
					st.executeUpdate(query2);

					PrintWriter pw = resp.getWriter();
					pw.println("<html><head>");
					pw.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"LogIn.css\">");
					pw.println("<head><body>");
					pw.println("<br><div class=\"logHere\">");
					pw.println("<h2>Department Added Sucessfully</h2>");
					pw.println("<br><a href = \"createT\">Add Topic</a>");
					pw.println("</div><div class=\"bottomright\"><a href=\"mailto:sushovanpan2003@gmail.com\" ><img src=\"image/logo.jpg\"  alt=\"logo\" title=\"click here to mail me\"></a></div>");
					pw.println("<body></html>");
					
					st.close();
					con.close();
				}
			}
			catch(Exception ex) {
				resp.setContentType("text/html");
				
				PrintWriter pw = resp.getWriter();
				pw.println("<html><head>");
				pw.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"LogIn.css\">");
				pw.println("</head><body>");
				pw.println("<br><br><br><br><br><br><br><div class=\"log\"><br>");
				pw.println("<h2><u>error occurd</u></h2><br>");
				pw.println("<a href = \"CreateDorT\">Go back</a>");
				pw.println("</div>");
				pw.println("</body></html>");
				
				ex.printStackTrace();
			}
		}
	}


