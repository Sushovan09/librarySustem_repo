package com.suhovan;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/updateA")
public class UpdateAdmin extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException {
			resp.setContentType("text/html");
				
			PrintWriter pw = resp.getWriter();
			pw.println("<html><head>");
			pw.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"LogIn.css\">");
			pw.println("<head><body>");
			pw.println("<br><br><br><br><br><br><br><div class=\"log\"><br>");
			pw.println("<h2><b>Select filds To Update</b></h2>");
			pw.println("<form action=\"updateAdmin2\" method =\"POST\">");
			pw.println("<select name=\"field\" id=\"subject\">");	
			pw.println("<option value=\"AdminName\">Admin Name</option>");
			pw.println("<option value=\"UserName\">UserName</option>");
			pw.println("<option value=\"Password\">Password</option>");
			pw.println("<option value=\"AdminSubject\">Admin Subject</option>");
			pw.println("<option value=\"Email\">Email</option>");
			pw.println("<option value=\"mobileNumber\">mobile Number</option>");
			pw.println("<option value=\"residentialAddress\">residential Address</option>");
			pw.println("</select><br><input type = \"submit\" class = \"signin\" value = \"Continue\"></form></div><br>");
			pw.println("<div class=\"bottomright\"><a href=\"mailto:sushovanpan2003@gmail.com\" ><img src=\"image/logo.jpg\"  alt=\"logo\" title=\"click here to mail me\"></a></div>");
			pw.println("<body></html>");

	}
}

