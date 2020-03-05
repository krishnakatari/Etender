import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.sql.*;
public class clientlog4 extends HttpServlet{

 public void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
	  response.setContentType("text/html");
   PrintWriter out=response.getWriter();
	 try{
   PreparedStatement st=null;
   ResultSet rs=null;
   Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db","root","root");  
		 //Statement st=con.createStatement();
		 Class.forName("com.mysql.jdbc.Driver");
   String direction=request.getParameter("direction");
   String orgUname=request.getParameter("orgUname");
   String username=request.getParameter("username");
   String password=request.getParameter("password");
   out.print("<html> <body background=img.jpg text=white>");
   /*if(direction.equals("create"))
   {
	   out.print("<h3>create</h3>");
	   String cname= request.getParameter("orgUname");//what is orgUname
	   int minamnt=Integer.parseInt(request.getParameter("minamnt"));
	   String tyear= request.getParameter("tyear");
	   String tmonth= request.getParameter("tmonth");
	   String tday= request.getParameter("tday");
	   //require tid??
 
  PreparedStatement sttmp=null;
		int cnt=1;
	   st = con.prepareStatement("SELECT * FROM tenderinfo"); 
	   rs=st.executeQuery();
	   while(rs.next())
						{
		   
					cnt++;
						   
						}
		String tdesc= request.getParameter("tdesc");
	   String tyear= request.getParameter("tyear");
	   String tname= request.getParameter("tname");
		stmt.executeUpdate("insert into tenderinfo values('"+tname+"', '"+cnt+"' , '"+tdesc+"','"+tday+"','"+tmonth+"','"+tyear+"', '"+minamnt+"', '"+cname+"')");

   }*/
    if(direction.equals("update"))
   {               out.print("<h3>update</h3>");
					int htmlid=Integer.parseInt(request.getParameter("htmlid"));
					st = con.prepareStatement("SELECT * FROM tenderinfo where tid=?"); 
					st.setInt(1,htmlid);
					//st = con.prepareStatement("SELECT * FROM tenderinfo"); 
	   rs=st.executeQuery();
					//SETINT
					out.print("<form action=cupdate.com method=post>");
					out.print("<h3>@log client2  update</h3>");
					
					out.print("<input type=hidden name=orgUname value="+orgUname+">");
					out.print("<input type=hidden name=tid value="+htmlid+">");
					out.print("<input type=hidden name=username value="+username+">");
					out.print("<input type=hidden name=password value="+password+">");
					out.print("<input type=hidden name=log3direction value= update>");
					while(rs.next())
						{
							out.print("in while");
						 	out.print("<table align=center border=0>");///////////////////without name
							out.print("<tr><td>TENDER NAME : </td>	   <td><input type=text name=tname value="+rs.getString(1)+">  </td></tr>");
							out.print("<tr><td>CLOSEDATE(dd/mm/yyyy) : </td>	   <td> <input type=text name=tday value="+rs.getString("tday")+">/<input type=text name=tmonth value="+rs.getString("tmonth")+">/<input type=text name=tyear value="+rs.getString("tyear")+" >  </td></tr>");
							out.print("<tr><td>TENDER ID : </td>	   <td><input type=text name=tid value="+rs.getString(2)+">  </td></tr>");
							out.print("<tr><td>TENDER DESCRIPTION : </td>	   <td><input type=text name=tdesc value="+rs.getString(3)+">  </td></tr>");
							out.print("<tr><td>MINIMUM AMOUNT : </td>	   <td><input type=text name=minamnt value="+rs.getString(7)+">  </td></tr>");
						}
						out.print("out while");
						out.print("<input type=submit value=update quote>");
					out.print("</form>");  
	   
					


   }
   else if(direction.equals("display"))
   {			out.print("<h3>error in coding</h3>");
   }
   else
	 {
	   out.print("<h3> got into else @ clientlog3</h3>");
   }
   out.print("</body></html>"); 		
   
	 }//try
	 catch(Exception e)
	 {
		out.print("Hii errror in clnt4"+ e);
	 }
	  }//doGet
}//clientlog3

/*while(rs.next())
						{
	  
						 	
							int id=rs.getInt(2);
							out.print("<input type=radio name=htmlid value="+id+">");
							out.print("Tender Name:"+rs.getString(1)+"Tender Id:"+id+"Description:"+rs.getString(3)+"Closing Day:"+rs.getInt(4)+"Closing month:"+rs.getInt(5)+"Closing year:"+rs.getInt(6)+"Minimum Amount:"+rs.getInt(7)+"Company Opened Tender:"+rs.getString("cname"));
							}
						out.print("<input type=submit value=update>");
					*/