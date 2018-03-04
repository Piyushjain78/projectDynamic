import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class database {
	
	 Connection c;
	 PreparedStatement ss,ss1,ss3,ss4;
	 Statement ss2;
	 int i,ii;
	 ResultSet rs,rs1,rs3,rs4;
	 boolean bo,exist,bo1,bo3;
	 int result=0,upp=0;
	 String p,q,r,t;
		
	public void conn() throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
	    c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","piyush12345"); 
	}
	
	public int signup(String s,String s1,String s2,String s3,String s4)
	{
		try {
			ss=c.prepareStatement("insert into signup values(?,?,?,?,?)");
			ss.setString(1, s);
			ss.setString(2, s1);
			ss.setString(3, s2);
			ss.setString(4, s3);
			ss.setString(5, s4);
		    i=ss.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		 return i;
	}
	
	public int update1(String pass,String mob,String gmailadd,String ad,String username)
	{
	
		try {
			ss=c.prepareStatement("update signup set pass=?,mobile=?,gmail=?,address=? where username=?");
			ss.setString(1, pass);
			ss.setString(2, mob);
			ss.setString(3, gmailadd);
			ss.setString(4, ad);
			ss.setString(5,username );
		    ii=ss.executeUpdate();
		   
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		if(ii>=1)
		{
		 //return ii;
			result=1;
		}
		else
		{
			result=0;
		}
		return result;
	}
	public boolean check(String s)
	{
		try {
			ss1=c.prepareStatement("select * from signup where username=?");
			ss1.setString(1, s);
			rs=ss1.executeQuery();	
			bo=rs.next();		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bo;
		
	}
	
	public void setdetail(String s)
	{
		try {
			ss2=c.createStatement();
			rs1=ss2.executeQuery("select * from signup where username='"+s+"'");
			//ss2.setString(1, s);
			//rs1=ss2.executeQuery();	
			bo1=rs1.next();
			if(bo1==true)
			{
				/*gs=new getset();
				gs.setPassword(rs1.getString(2));
				//gs.setPassword("p");
				//System.out.print(gs.setPassword(rs1.getString(2)));
				gs.setMobile_Num(rs1.getString(3));
				//System.out.println(rs1.getString(3));
				gs.setGmail_Add(rs1.getString(4));
				//System.out.println(rs1.getString(4));
				gs.setAddress(rs1.getString(5));
				//System.out.println(rs1.getString(5));*/
				p=rs1.getString(2);
				q=rs1.getString(3);
				r=rs1.getString(4);
				t=rs1.getString(5);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//return gs;
		
	}
	
	
	public boolean checklog(String s,String s1)
	{
		try {
			ss1=c.prepareStatement("select * from signup where username=? and pass=?");
			ss1.setString(1, s);
			ss1.setString(2, s1);
			rs=ss1.executeQuery();	
			bo=rs.next();		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bo;
		
	}
	
	
	public boolean checkemail(String s,String s1)
	{
		try {
			ss3=c.prepareStatement("select * from signup where username=? and gmail=?");
			ss3.setString(1, s);
			ss3.setString(2, s1);
			rs3=ss3.executeQuery();	
			bo3=rs3.next();		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bo3;
		
	}
	
	public int updatepass(String s,String s1,String s2)
	{
	   	try {
			ss4=c.prepareStatement("update signup set pass=? where username=? and gmail=?");
			ss4.setString(1, s);
			ss4.setString(2, s1);
			ss4.setString(3, s2);
			upp=ss4.executeUpdate();
			if(upp>=1)
			{
				return i=1;
			}
			else
			{
				return i=0;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   	
		return i;
		
	}

}
