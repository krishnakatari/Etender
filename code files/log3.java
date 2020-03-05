import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.sql.*;
import javax.crypto.*;
import javax.crypto.spec.*;

import java.util.*;
import java.security.*;

import java.math.BigInteger;

public class log3 extends HttpServlet{

 public void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
		  String orgUname,tid,price,tname,minamt,experience;
		  
		  PrintWriter out=response.getWriter();
		  //PreparedStatement pt=null;
		  try{ 
		        			
				response.setContentType("text/html");
   				orgUname=request.getParameter("orgUname");
				tid=request.getParameter("htmlid");
				price=request.getParameter("price");
				tname=request.getParameter("tname");
				minamt=request.getParameter("minamt");
				experience=request.getParameter("experience");
				java.sql.Timestamp timestamp = new java.sql.Timestamp(System.currentTimeMillis());
				//Directory and file creation
				
				File dir=new File("D:\\"+orgUname);//change the directory name to some different folder
					 if (!dir.exists())
					    {
           					if (dir.mkdir())
							 {
               						   //System.out.println("Directory is created!");
           						 }
							else 
							 {
               					out.println("Failed to create directory!");
         					      }
       				     }//directory creation	

					  if(dir.isDirectory())
						 {  
							 File[] files = dir.listFiles();
							 int flen=files.length/2+1;  
							 	 //file name
								 String filetextname="F"+flen+".txt";
								 String hashcode="";
								 String nodetextname="N"+flen+".txt";
								 File file2=new File("D:\\"+orgUname+"\\"+nodetextname);    
								 File file=new File("D:\\"+orgUname+"\\"+filetextname);             //path name should be changed
								 if (file.createNewFile()&&file2.createNewFile())
								 {
									//the tender details should be kept here in this file
									FileWriter writer = new FileWriter(file);
									writer.write("Username:"+orgUname);
									writer.write("\nTender Id:"+tid);
									writer.write("\nTender Name:"+tname);
									writer.write("\nQuotation Price:"+price);
									writer.write("\nMinimum amount:"+minamt);
									writer.write("\nCompany experience:"+experience);
									writer.write("\nTimestamp:"+timestamp);
									writer.close();
									
									String key = "This is a secret";
								  File inputFile     = new File("D:\\"+orgUname+"\\"+filetextname);
								File encryptedFile = new File("D:\\"+orgUname+"\\"+filetextname);
								//File decryptedFile = new File("D:\\"+orgUname+"\\"+"decrypt"+filetextname);
								Crypto crypto=new Crypto();
								crypto.fileProcessor(Cipher.ENCRYPT_MODE,key,inputFile,encryptedFile);
	                            //crypto.fileProcessor(Cipher.DECRYPT_MODE,key,encryptedFile,decryptedFile);
	     

									 Hash hashobj=new Hash();
									hashcode=hashobj.main1("D:\\"+orgUname+"\\"+filetextname);
								
									FileWriter writer2 = new FileWriter(file2);
									writer2.write("Filename:"+filetextname);
									writer2.write("\nHash code:"+hashcode);
									writer2.write("\nTimestamp:"+timestamp);
								    writer2.close();
								 	
									
								 }
								 //encrypting 1.txt
								 
								 //creating hash  hashcode
								
									
							if(files.length==0)
							 {   
								 
								 
							 }
							 else
							 { boolean haslink=true;
							   String nodetempname="N1.txt";
							   File file3=new File("D:\\"+orgUname+"\\"+nodetempname);    
							   
								 while(haslink)
								 {
									String[] words=null;  //Intialize the word Array
									FileReader fr = new FileReader("D:\\"+orgUname+"\\"+nodetempname);  //Creation of File Reader object
									BufferedReader br = new BufferedReader(fr); //Creation of BufferedReader object
									String s="";     
									String fieldhashcode="";//tp is used to store the timestamp
									String fieldfilename="";
									String fieldnextlink="";
									while((s=br.readLine())!=null)   //Reading Content from the file
								  { 
									  //System.out.println(s);
									 words=s.split(":");  //Split the word using space
									for (int index=0;index<words.length;index++)
									{   
										if(words[index].equals("Nextlink"))
										{ 
											fieldnextlink=words[words.length-1];
											//System.out.println(nodetempname+"Next link"+fieldnextlink);
										}
										if(words[index].equals("Hash code"))
										{ 
											fieldhashcode=words[words.length-1];
											//System.out.println(nodetempname+"hash code"+fieldhashcode);
										}
										if(words[index].equals("Filename"))
										{ 
											fieldfilename=words[words.length-1];
											//System.out.println(nodetempname+"file name"+fieldfilename);
										}
									}
								  }
								  br.close();//imp
								  //checking fieldhashcode with filename and produce error;
								  String hashcode1="";
								  Hash hashobj1=new Hash();
									hashcode1=hashobj1.main1("D:\\"+orgUname+"\\"+fieldfilename);
									if(!hashcode1.equals(fieldhashcode))
									 {out.println("error");}



								  if(fieldnextlink=="")
									  {
									 // System.out.println(nodetempname+" in if filed next link not exists");
									  haslink=false;
									  /*//change done here
									  File f4=new File("D:\\"+orgUname+"\\"+nodetempname);
									  FileWriter writer3 = new FileWriter(f4);
									  */
									  BufferedWriter out1 = new BufferedWriter( 
																	new FileWriter("D:\\"+orgUname+"\\"+nodetempname, true)); 
										out1.write("\nNextlink:"+nodetextname); 
										out1.close(); 
									  //writer3.write("\nNextlink:"+nodetextname);
									  //writer3.close(); 
								      }
								  else
									  {
									  nodetempname=fieldnextlink;
									 

								      }

								  }
								 }
						 
					     }
					 
					 
			out.println("<h3>successfully updated</h3>");	
			out.print("<form action=http://localhost:8080/1/login.html method=get>");
			out.print("<input type=submit value=Logout>");
		  }//try
		  catch(Exception e)
		  {
			  out.println(e);
		  }
   }//doget
   // timestamp creation....
   //

}//log3


	



class Hash
{
	public String main1(String f1) 
	{ String hsh=""; 
    
		
		try{byte[] buffer= new byte[8192];
    int count=0;
    MessageDigest digest = MessageDigest.getInstance("SHA-256");
    BufferedInputStream bis = new BufferedInputStream(new FileInputStream(f1));
    while ((count = bis.read(buffer)) > 0) {
        digest.update(buffer, 0, count);
    }
    bis.close();
	byte[] hash = digest.digest();
	for(int i=0;i<hash.length;i++)
			{
				hsh+=hash[i];	
			}
			
			//// System.out.println(new Base64Encoder().Encoder(hash));//
		}
	catch(Exception e)
			{
e.printStackTrace();
			}
			return hsh;
	}
}//hash class




