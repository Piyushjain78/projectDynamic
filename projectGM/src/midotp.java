

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class midotp extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public static String p;
	public static String s2,s,s1;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		s=request.getParameter("us");
	    s1=request.getParameter("em");
		s2 = request.getParameter("pas");
		database db=new database();		
		try {
			db.conn();
			db.checkemail(s,s1);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(db.bo3==true)
		{
		p=String.valueOf((int)(Math.random()*100000));
		gmail.send("replymailtoany@gmail.com","noreplymailtoany12345",s1,"Piyush jain",p);
		RequestDispatcher rd=request.getRequestDispatcher("/forgetpass");
		rd.forward(request, response);
		}
		else
		{
		out.println("Kindly Please check your Entered Username And Email Address");	
		}
	}

}
