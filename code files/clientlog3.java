import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.sql.*;
public class clientlog3 extends HttpServlet{

 public void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

	 PrintWriter out=response.getWriter();
	 try{
   response.setContentType("text/html");
   
   Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db","root","root");  
		 PreparedStatement st=null;
		 Class.forName("com.mysql.jdbc.Driver");
   String direction=request.getParameter("log3direction");
   String orgUname=request.getParameter("orgUname");
   String username=request.getParameter("username");
   String password=request.getParameter("password");
   ResultSet rs=null;

   out.print("<html> <body background=img.jpg text=white>");
   if(direction.equals("create"))
   {
	   out.print("<h3>create</h3>");
	   String cname= request.getParameter("orgUname");
	   int minamnt=Integer.parseInt(request.getParameter("minamnt"));
	   //int tyear= Integer.parseInt(request.getParameter("tyear"));
	   int tmonth= Integer.parseInt(request.getParameter("tmonth"));
	   int tday= Integer.parseInt(request.getParameter("tday"));
	   int tyear=2020;
	   //require tid??
     
   //sttmp=null;
		int cnt=1;
	   st = con.prepareStatement("SELECT * FROM tenderinfo"); 
	   rs=st.executeQuery();
	   while(rs.next())
						{
		   
					cnt++;
						   
						}
		String tdesc= request.getParameter("tdesc").replaceAll("","-");
	   
	   String tname= request.getParameter("tname");
		st.executeUpdate("insert into tenderinfo values('"+tname+"', '"+cnt+"' , '"+tdesc+"','"+tday+"','"+tmonth+"','"+tyear+"', '"+minamnt+"', '"+cname+"')");

   }
   else if(direction.equals("update"))
   {               out.print("<h3>update</h3>");
					int htmlid=Integer.parseInt(request.getParameter("htmlid"));
					String q="SELECT * FROM tenderinfo where tid=?";
					st = con.prepareStatement(q); 
					st.setInt(1,htmlid);//SETINT//SETINT//SETINT//SETINT//SETINT//SETINT

					/* PreparedStatement st=null;
		 
		 String q="update table tenderinfo set tname=? tdesc=? tday=? tmonth=? tyear=? minamount=? where tid=?";
				st=con.prepareStatement(q);*/
					
   					
   				//st = con.prepareStatement("SELECT * FROM tenderinfo where cname=?");
				//	st.setString(1,orgUname);	//we hav orgUname				
					rs=st.executeQuery();
					out.print("<form action=cupdate.com method=post>");
					out.print("<h3>@log client2  update</h3>");
					
					out.print("<input type=hidden name=orgUname value="+orgUname+">");
					out.print("<input type=hidden name=username value="+username+">");
					out.print("<input type=hidden name=direction value=update>");
					out.print("<input type=hidden name=password value="+password+">");
					out.print("<input type=hidden name=htmlid value="+htmlid+">");
					while(rs.next())
						{
	  
						 	out.print("<table align=center border=0>");///////////////////without name
							out.print("<tr><td>TENDER NAME : </td>	   <td><input type=text name=tname value="+rs.getString(1)+">  </td></tr>");
							out.print("<tr><td>CLOSEDATE(dd/mm/yyyy) : </td>	   <td> <input type=text name=tday value="+rs.getString("tday")+">/<input type=text name=tmonth value="+rs.getString("tmonth")+">/<input type=text name=tyear value="+rs.getString("tyear")+" >  </td></tr>");
							out.print("<tr><td>TENDER ID : </td>	   <td><input type=text name=tid value="+rs.getString(2)+">  </td></tr>");
							out.print("<tr><td>TENDER DESCRIPTION : </td>	   <td><input type=text name=tdesc value="+rs.getString(3)+">  </td></tr>");
							out.print("<tr><td>MINIMUM AMOUNT : </td>	   <td><input type=text name=minamnt value="+rs.getString(7)+">  </td></tr>");
						}
						out.print("<input type=submit value=update quote>");
					out.print("</form>");  
	   
					
   }
   out.print("</body></html>"); 		
   
	 }//try
	 catch(Exception e)
	 {
		out.print(e);
	 }
	  }//dopost
}//clientlog3

					