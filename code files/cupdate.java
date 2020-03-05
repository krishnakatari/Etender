
import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.sql.*;
public class cupdate extends HttpServlet{

 public void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
		  response.setContentType("text/html");
         PrintWriter out=response.getWriter();
		  try{
         
		 String tname1=request.getParameter("tname");
		 String tdesc1=request.getParameter("tdesc");
		 int tday1=Integer.parseInt(request.getParameter("tday"));
		 int tmonth1=Integer.parseInt(request.getParameter("tmonth"));
		 int tyear1=Integer.parseInt(request.getParameter("tyear"));
		 int minamnt1=Integer.parseInt(request.getParameter("minamnt"));
		 int tid1=Integer.parseInt(request.getParameter("tid"));
		 Class.forName("com.mysql.jdbc.Driver");
         Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db","root","root");  
		 PreparedStatement st=null;
		 
		 String q="update tenderinfo set tname=?, tdesc=?, tday=?, tmonth=?, tyear=?, minamount=? where tid=?";
				st=con.prepareStatement(q);
				
		 /* st = con.prepareStatement("SELECT * FROM tenderinfo"); 
	   rs=st.executeQuery();*/
		 //st.executeUpdate();
		 st.setString(1,tname1);
		 st.setString(2,tdesc1);
		 st.setInt(3,tday1);
		 st.setInt(4,tmonth1);
		 st.setInt(5,tyear1);
		 st.setInt(6,minamnt1);
		 st.setInt(7,tid1);
		 st.executeUpdate();
		 out.print("@cupdate");

		  }//try
		  catch(Exception e)
		  {
			out.println("Hii  error"+e.getMessage());
		  }
 }//doget
}// class