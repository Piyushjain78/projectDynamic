

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class beforeotp extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public String so;
	public String so1;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<head><link rel='stylesheet' href='styles.css'");
		out.println("<body bgcolor='#C0C0C0'><center>");
		out.println("<form action='./midotp' method='POST'>");
		out.println("<table>");
		out.println("<tr><td>Enter Regestered Username</td>");
		out.println("<td><input type='text' name='us'></td></tr>");
		out.println("<tr><td>Enter Regestered Email Address</td>");
		out.println("<td><input type='text' name='em'></td></tr>");
		out.println("<tr><td>Enter New Password</td>");
		out.println("<td><input type='password' name='pas'></td></tr>");
		out.println("<td><br></td>");
		out.println("<tr><td><input id='p02' type='submit' value='Submit'></td></tr>");
		out.println("</table>");
		out.println("</form>");
		out.println("</center></body>");
	
	}

}
