import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.sql.*;
public class clientlog extends HttpServlet{

 public void doGet(HttpServletRequest req, HttpServletResponse response)
      throws ServletException, IOException {
   response.setContentType("text/html");
   PrintWriter out=response.getWriter();
   String direction=req.getParameter("clientOpt");
   out.print("<html> <body background=img.jpg text=white>");
   if(direction.equals("create"))
   {
	   out.print("<form action=log3.com method=post>");
					//out.print(<table align=center border=0>);
					out.print("<input type=hidden name=orgUname value="+request.getParameter("orgUname")+">");
					
							out.print("<table align=center border=0>");
							out.print("<tr><td>TENDER NAME :</td>	   <td> <input type=text name=tname > </td></tr>");
							out.print("<tr><td>TENDER DESCRIPTION : </td>	   <td> <input type=text name=tdesc > </td></tr>");
							out.print("<tr><td>CLOSEDATE(dd/mm/yyyy) : </td>	   <td> <input type=text name=tday>/<input type=text name=tmonth >/<input type=text name=tyear >  </td></tr>");
							out.print("<tr><td>MINIMUM AMOUNT: </td>   <td> <input type=text name=minamnt> </td></tr>");
							out.print("<tr><td>EXPERIENCE: </td>   <td> <input type=text name=exp > </td></tr>");
							out.print("<tr><td></td><td><input type=submit value=submit> </td></tr>");
							out.print("</table></form></body></html>"); 		
   }
   else if(direction.equals("update"))
   {
	   
   }
   else if(direction.equals("update"))
   {
	   
   }
   
   
   
	  }//doGet
}//clientOp