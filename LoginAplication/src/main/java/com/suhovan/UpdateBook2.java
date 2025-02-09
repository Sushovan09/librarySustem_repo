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

@WebServlet("/updateBook2")
public class UpdateBook2 extends HttpServlet{
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException {

				PrintWriter pw = resp.getWriter();
				pw.println("<html><head>");
				pw.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"LogIn.css\">");
				pw.println("<head><body>");
				pw.println("<br><div class=\"logHere\">");
				pw.println("<form action=\"UpdateBookDatabase\" method = \"POST\">");
				pw.println("<h2>Provide Required Fields</h2>");
				pw.println("<input type = \"text\" class =\"text\" name= \"bookname\" placeholder = \"Enter Book Name\"><br><br>");
				
				String option = req.getParameter("field"); 
				String o1 = "BookImageURL";
				String o2 = "BookDownloadURL";
				String o3 = "TotalPage";
				String o4 = "TId";

				if(option.equals(o1)||option.equals(o2)) {
					pw.println("<input type = \"url\" class =\"text\" name= \""+option+"\" placeholder = \"Enter new "+option+"\"><br><br>");
				}
				else if(option.equals(o3)) {
					pw.println("<input type = \"number\" class =\"text\" name= \""+option+"\" placeholder = \"Enter new "+option+"\"><br><br>");
				}
				else if(option.equals(o4)) {
					String url = "jdbc:mysql://localhost:3306/library";
					String user_name = "root";
					String password = "1234";
					try {
						Class.forName("com.mysql.jdbc.Driver");
						Connection con = DriverManager.getConnection(url, user_name, password);
				
						String query = String.format("SELECT TId,SubjectName,TopicName FROM subject_topic");
						Statement st = con.createStatement();
						ResultSet rs = st.executeQuery(query);

						if(rs.next()) {
							pw.println("Select Subject Name And Topic");
							pw.println("<select name=\"TId\" id=\"subject\">");	
							pw.println("<option value=\""+rs.getString(1)+"\">"+rs.getString(2)+"/"+rs.getString(3)+"</option>");
							while(rs.next()) {
								pw.println("<option value=\""+rs.getString(1)+"\">"+rs.getString(2)+"/"+rs.getString(3)+"</option>");
							}
							pw.println("<br><br>");
						}	
					}		
					catch(Exception ex) {
						ex.printStackTrace();
					}
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

