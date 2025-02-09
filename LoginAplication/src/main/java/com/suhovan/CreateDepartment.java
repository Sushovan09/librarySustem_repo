package com.suhovan;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/createD")
public class CreateDepartment extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException {

				PrintWriter pw = resp.getWriter();
				pw.println("<html><head>");
				pw.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"LogIn.css\">");
				pw.println("<head><body>");
				pw.println("<br><div class=\"logHere\">");
				pw.println("<form action=\"createDeptDatabase\" method = \"POST\">");
				pw.println("<h2>Provide Required Fields</h2>");
				pw.println("<input type = \"text\" class =\"text\" name= \"Department\" placeholder = \"Enter New Department Name\"><br><br>");
				pw.println("<input type = \"Text\" class =\"text\" name= \"ImageSource\" placeholder = \"Enter An Image Source of the Subject\"><br><br>");
				pw.println("<input type = \"submit\" class =\"signin\" value = \"Add\">");	
				pw.println("<br><a href = \"CreateDorT\">Go back</a>");
				pw.println("</div><div class=\"bottomright\"><a href=\"mailto:sushovanpan2003@gmail.com\" ><img src=\"image/logo.jpg\"  alt=\"logo\" title=\"click here to mail me\"></a></div>");
				pw.println("</body></html>");
				
	}
}

