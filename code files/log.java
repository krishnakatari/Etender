import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.sql.*;
public class log extends HttpServlet{

 public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
		  PrintWriter out=response.getWriter();
		  //PreparedStatement pt=null;
		  try{
   response.setContentType("text/html");
   
   out.print("<html> <body background=img.jpg text=green>");
	Class.forName("com.mysql.jdbc.Driver");
	
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db","root","root");  
		 PreparedStatement st=null;
		 String user= request.getParameter("username");
		 String password= request.getParameter("password");
		 if(user.charAt(0)=='C')
		 {
			 
			
			String q="select uname,Pan from clientcompany where uname=?";
				st=con.prepareStatement(q);
			st.setString(1,user);
			ResultSet rs=st.executeQuery();
            String orgUname = "", orPass = "";
            while (rs.next()) {
                orgUname = rs.getString("uname");
                orPass = rs.getString("Pan");
            } //end while
			//out.println(orPass+" "+password+" "+orgUname);
			if(orgUname!="")
			{
				if(orPass.equals(password))
				{
					//create,update,display
					out.print("<form action=clientlog2.com method=post>");
					out.print("<input type=hidden name=orgUname value="+orgUname+">");
					out.print("<input type=hidden name=username value="+user+">");
					out.print("<input type=hidden name=password value="+password+">");
					out.print("<h3>@log client</h3>");
					out.print("<input type=radio name=clientOpt value=create> create");
					out.print("<input type=radio name=clientOpt value=update> update");
					out.print("<input type=radio name=clientOpt value=display> display");
					out.print("<input type=submit value=next>");
					out.print("</form>");
					
				}
			    else
			    {
				   out.println("Invalid Password");
			    }
				
			}
			else
			{
				out.println("User Name Not found");
			}

		 }//Client
		 
		 else if(user.charAt(0)=='T')
		 {
			
String q="select uname,Pan from Tenderer where uname=?";
			
			st=con.prepareStatement(q);
			st.setString(1,user);
			ResultSet rs=st.executeQuery();
            String orgUname = "", orPass = "";
            while (rs.next()) {
                orgUname = rs.getString("uname");
                orPass = rs.getString("Pan");
            } //end while
			//out.println(orPass+" "+password+" "+orgUname);
			if(orgUname!="")
			{
				if(orPass.equals(password))
				{
					/*valid user
					//out.println("hii bro");
					
					*/
					
					st = con.prepareStatement("SELECT * FROM tenderinfo"); 
					rs=st.executeQuery();
					out.print("<form action=log2.com method=post>");
					//out.print(<table align=center border=0>);
					out.print("<input type=hidden name=orgUname value="+orgUname+">");
					while(rs.next())
						{
	  
						    String tname=rs.getString(1);
							int id=rs.getInt(2);
							String cname=rs.getString(6);
							out.print("<br/>");
							out.print("<input type=radio name=htmlid value="+id+">");
							out.print("Tender Name:"+tname+"Tender Id:"+id+"Description:"+rs.getString(3)+"Closing Date:"+rs.getDate(4)+"Minimum Amount:"+rs.getInt(5)+"Company Opened Tender:"+cname);
						}
						out.print("<input type=submit value=quote>");
					out.print("</form>");
				}
			    else
			    {
				   out.println("Invalid Password");
			    }
				
			}
			else
			{
				out.println("User Name Not found");
			}


		 }//Tenderer
		 else
		 {
			 out.println("yo");
		 }
		out.print("</body></html>");
		  }//try
		  catch(Exception e)
		  {
			  out.println(e);
		  }
   }//doget
   // timestamp creation....
   //Timestamp timestamp = new Timestamp(System.currentTimeMillis());

}//log

