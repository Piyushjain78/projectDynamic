

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class update extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String pass=request.getParameter("pass");
		String mob=request.getParameter("mob");
		String gmailadd=request.getParameter("gmail");
		String ad=request.getParameter("address");
		database db=new database();
		try {
			db.conn();
			db.update1(pass, mob, gmailadd, ad,serv3.s);
			if(db.result==1)
			{
				out.println("<h1>Successfully updated</h1>");
			}
			if(db.result==0)
			{
				out.println("<h1>Fail to updated</h1>");
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}

}
