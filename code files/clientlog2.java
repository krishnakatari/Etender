import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.sql.*;
public class clientlog2 extends HttpServlet{

 public void doPost(HttpServletRequest req, HttpServletResponse response)
      throws ServletException, IOException {
		  try{
   response.setContentType("text/html");
   PrintWriter out=response.getWriter();
   String direction=req.getParameter("clientOpt");
   String orgUname=req.getParameter("orgUname");
   String username=req.getParameter("username");
   String password=req.getParameter("password");
   
   out.print("<html> <body background=img.jpg text=white>");
   
   ResultSet rs=null;
   Class.forName("com.mysql.jdbc.Driver");
	
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db","root","root");  
	PreparedStatement st=null;
	
   if(direction.equals("create"))
   {
	   out.print("<form action=clientlog3.com method=post>");
					out.print("<input type=hidden name=orgUname value="+orgUname+">");
					out.print("<input type=hidden name=username value="+username+">");
					out.print("<input type=hidden name=password value="+password+">");
					out.print("<input type=hidden name=log3direction value= create>");
					
							out.print("<table align=center border=0>");
							out.print("<tr><td>TENDER NAME :</td>	   <td> <input type=text name=tname > </td></tr>");
out.print("<h3>@log client2 create</h3>");
										
					out.print("<tr><td>TENDER DESCRIPTION : </td>	   <td> <input type=text name=tdesc > </td></tr>");
							out.print("<tr><td>CLOSETIME(HH/min) : </td>	   <td> <input type=text name=tday>/<input type=text name=tmonth >  </td></tr>");
							out.print("<tr><td>MINIMUM AMOUNT: </td>   <td> <input type=text name=minamnt> </td></tr>");
							out.print("<tr><td>EXPERIENCE: </td>   <td> <input type=text name=exp > </td></tr>");
							out.print("<tr><td></td><td><input type=submit value=submit> </td></tr>");
							out.print("</table></form>");
   }
   else if(direction.equals("update"))
   {   
              out.print("<h3> got into update @clientlog2</h3>");
					
	          st = con.prepareStatement("SELECT * FROM tenderinfo where cname=?");
					st.setString(1,orgUname);	//we hav orgUname				
					rs=st.executeQuery();
					out.print("<form action=clientlog3.com method=post>");
					out.print("<h3>@log client2  update</h3>");
					
					out.print("<input type=hidden name=orgUname value="+orgUname+">");
					out.print("<input type=hidden name=username value="+username+">");
					out.print("<input type=hidden name=password value="+password+">");
					out.print("<input type=hidden name=log3direction value= update>");
					while(rs.next())
						{
	  
							//out.print("In while loop");
 	
							int id=rs.getInt("tid");
							out.print("<input type=radio name=htmlid value="+id+">");
							out.print("Tender Name:"+rs.getString(1)+"Tender Id:"+id+"Description:"+rs.getString(3)+"Closing Hours:"+rs.getInt(4)+"Closing min:"+rs.getInt(5)+"Minimum Amount:"+rs.getInt(7)+"Company Opened Tender:"+rs.getString("cname"));
						}
							//out.print("outside while loop");

						out.print("<input type=submit value= update >");
						out.print("</form>");
                        

	   
   }
 else if(direction.equals("display"))
   {
					st = con.prepareStatement("SELECT * FROM tenderinfo where cname=?");
					st.setString(1,orgUname);					
					rs=st.executeQuery();
					//out.print("<form action=log.com method=post>");

					out.print("<h3>@log client2 display</h3>");
					
					out.print("<input type=hidden name=orgUname value="+orgUname+">");
					out.print("<input type=hidden name=username value="+username+">");
					out.print("<input type=hidden name=password value="+password+">");
					while(rs.next())
						{
							String ss=rs.getString(3);
							ss=ss.replaceAll("-"," ");
						 	out.print("<table align=center border=0>");///////////////////without name
							out.print("<tr><td>TENDER DESCRIPTION:</td><td>"+ss+"</td></tr>");
							out.print("<tr><td>TENDER NAME : </td>	   <td><input type=text value="+rs.getString(1)+" readonly>  </td></tr>");
							out.print("<tr><td>CLOSETIME(HH/min) : </td>	   <td> <input type=text value="+rs.getInt("tday")+" readonly>/<input type=text value="+rs.getInt("tmonth")+">  </td></tr>");
							out.print("<tr><td>TENDER ID : </td>	   <td><input type=text value="+rs.getString(2)+">  </td></tr>");
							//out.print("<tr><td>TENDER DESCRIPTION : </td>	   <td><input type=text value="+ss+"</td></tr>");
							out.print("<tr><td>MINIMUM AMOUNT : </td>	   <td><input type=text value="+rs.getString(7)+">  </td></tr>");
							out.println("================================");
						}
						out.print("<input type=submit value=quote>");
					//out.print("</form>"); 
   }
   else{out.print("<h3> got into else @clientlog2</h3>");}
   out.print("</body></html>"); 		
   
		  }//try
		  catch(Exception e)
		  {System.out.println(e+"clientlog2 catch block");}
	  }//doGet
}//clientlog2