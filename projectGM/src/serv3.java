

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class serv3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	 public static String s;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
	    s=request.getParameter("UserN");
		database db=new database();
	
		try {
			db.conn();
			db.check(s);
			if(db.bo==false)
			{
				out.println("<h3>User Not Found Please Enter Valid UsenName to Update</h3>");
			}
			if(serv2.s.equals(s))
			{
			if(db.bo==true)
			{
				db.setdetail(serv3.s);
				out.println("<head><link rel='stylesheet' href='styles.css'></head>");
				out.println("<body bgcolor='#C0C0C0'>");
				out.println("<center>");
				out.println("<form method='POST' action='./update'>");
                out.print("<table border='8'><tr><td>UserName</td><td><input type='hidden' name='names'></td></tr>");
                out.print("<tr><td>Password</td><td><input type='password' name='pass' value='"+db.p+"'/></td></tr>");
                out.print("<tr><td>Mobile Number</td><td><input type='text' name='mob' value='"+db.q+"'/></td></tr>");
                out.print("<tr><td>Gmail Address</td><td><input type='text' name='gmail' value='"+db.r+"'/></td></tr>");
                out.print("<tr><td>Address</td><td><input type='text' name='address' value='"+db.t+"'/></td></tr>");             
                out.print("<tr><td><input type='Submit' value='Update'></td></tr>");
                out.println("</table>");
                out.println("</center>");
                out.println("</body>");
			}
			}
			else
			{
				out.println("<h1>Invalid Username</h1>");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
