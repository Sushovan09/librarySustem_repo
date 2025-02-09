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

@WebServlet("/UpdateAdminDatabase")
public class UpdateAdminDatabase extends HttpServlet{
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException {
		String url = "jdbc:mysql://localhost:3306/library";
		String user_name = "root";
		String password = "1234";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, user_name, password);
			String uname = req.getParameter("uname");
			String query = String.format("SELECT AName FROM admin_table WHERE AUserName = '%s'",uname);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			
			if(!(rs.next())) {
				resp.setContentType("text/html");
				
				PrintWriter pw = resp.getWriter();
				pw.println("<h1>User does not exist</h1>");
				pw.println("<a href = \"manageA\">Go back</a>");
				
		
			}
			else {
				String unknown = req.getParameter("unknown");
				String[] adminField = {"AdminName","UserName","Password","AdminSubject","Email","mobileNumber","residentialAddress"};
				String[] adminFieldMain = {"AName","AUserName","APassword","ASubject","AEmail","AmobNo","AAddress"};
				int i;
				for(i=0; i<adminField.length; i++) {
					if(unknown.equals(adminField[i])) {
						break;
					}
				}
				String unknownValue = req.getParameter(""+adminField[i]+"");
				String passwd = req.getParameter("passwd");
				
				String query2 = String.format("UPDATE admin_table SET "+adminFieldMain[i]+" ='%s' WHERE AUserName = '%s' AND APassword = '%S'",unknownValue,uname,passwd);
				Statement st2 = con.createStatement();
				st.executeUpdate(query2);

				PrintWriter pw = resp.getWriter();
				pw.println("<html><head>");
				pw.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"LogIn.css\">");
				pw.println("<head><body>");
				pw.println("<br><div class=\"logHere\">");
				pw.println("<h2>Admin Data updated Sucessfully</h2>");
				pw.println("<br><a href = \"ManageAdmin.java\">Go back</a>");
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
			pw.println("<a href = \"LogIn.html\">Go back to login page</a>");
			pw.println("</div>");
			pw.println("</body></html>");
			
			ex.printStackTrace();
		}
	}
}
