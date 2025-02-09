package com.suhovan;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/updateAdmin2")
public class UpdateAdmin2 extends HttpServlet{
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException {

				PrintWriter pw = resp.getWriter();
				pw.println("<html><head>");
				pw.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"LogIn.css\">");
				pw.println("<head><body>");
				pw.println("<br><div class=\"logHere\">");
				pw.println("<form action=\"UpdateAdminDatabase\" method = \"POST\">");
				pw.println("<h2>Provide Required Fields</h2>");
				pw.println("<input type = \"text\" class =\"text\" name= \"uname\" placeholder = \"Enter Username\"><br><br>");
				pw.println("<input type = \"password\" class =\"text\" name= \"passwd\" placeholder = \"Enter password\"><br><br>");
				
				String option = req.getParameter("field"); 
				String o1 = "Password";
				String o2 = "mobileNumber";
				if(option.equals(o1)) {
					pw.println("<input type = \"password\" class =\"text\" name= \""+option+"\" placeholder = \"Enter new "+option+"\"><br><br>");
				}
				else if(option.equals(o2)) {
					pw.println("<input type = \"number\" class =\"text\" name= \""+option+"\" placeholder = \"Enter new "+option+"\"><br><br>");
				}
				else {
					pw.println("<input type = \"text\" class =\"text\" name= \""+option+"\" placeholder = \"Enter new "+option+"\"><br><br>");
				}
				pw.println("<input type = \"hidden\" class =\"text\" name= \"unknown\" value = \""+option+"\">");
				pw.println("<input type = \"submit\" class =\"signin\" value = \"update\">");	
				pw.println("<br><a href = \"manageA\">Go back</a>");
				pw.println("</div><div class=\"bottomright\"><a href=\"mailto:sushovanpan2003@gmail.com\" ><img src=\"image/logo.jpg\"  alt=\"logo\" title=\"click here to mail me\"></a></div>");
				pw.println("</body></html>");
				
	}
}