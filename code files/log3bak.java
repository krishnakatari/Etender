import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.sql.*;
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
				//Timestamp timestamp = new Timestamp(System.currentTimeMillis());
				//Directory and file creation
				
				File dir=new File("D:\\"+orgUname);//change the directory name to some different folder
					 if (!dir.exists())
					    {
           					if (dir.mkdir())
							 {
               						   out.println("Directory is created!");
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
								 File file=new File("D:\\"+orgUname+"\\"+filetextname);             //path name should be changed
								 if (file.createNewFile())
								 {
									//the tender details should be kept here in this file
									FileWriter writer = new FileWriter(file);
									writer.write("Username:"+orgUname);
									writer.write("\nTender Id:"+tid);
									writer.write("\nTender Name:"+tname);
									writer.write("\nQuoataion Price:"+price);
									writer.write("\nMinimum amount:"+minamt);
									writer.write("\nCompany experience:"+experience);
									writer.write("\nTimestamp:"+timestamp);
									writer.close();
								 }
								 //encrypting 1.txt
								 //creating hash  hashcode
								 String hashcode="not done";
								 String nodetextname="N"+flen+".txt";
								 File file2=new File("D:\\"+orgUname+"\\"+nodetextname);    
								 FileWriter writer2 = new FileWriter(file2);
									writer2.write("Filename:"+filetextname);
									writer2.write("\nHash code:"+hashcode);
									writer2.write("\nTimestamp:"+timestamp);
									//writer2.write("\nNextlink:"+price);
									writer2.close();

							if(files.length==0)
							 {   
								 
								 
							 }
							 else
							 { boolean haslink=true;
							   String nodetempname="N1.txt";
							   File file3=new File("D:\\"+orgUname+"\\"+nodetempname);    
							   FileWriter writer3 = new FileWriter(file3);
								
								 while(haslink)
								 {
									String[] words=null;  //Intialize the word Array
									FileReader fr = new FileReader(nodetempname);  //Creation of File Reader object
									BufferedReader br = new BufferedReader(fr); //Creation of BufferedReader object
									String s;     
									String fieldhashcode="";//tp is used to store the timestamp
									String fieldfilename="";
									String fieldnextlink="";
									while((s=br.readLine())!=null)   //Reading Content from the file
								  {
									 words=s.split(":");  //Split the word using space
									for (int index=0;index<words.length;index++)
									{
										if(words[index].equals("Nextlink"))
										{ 
											fieldnextlink=words[words.length-1];
										}
										if(words[index].equals("Hash code"))
										{ 
											fieldhashcode=words[words.length-1];
										}
										if(words[index].equals("Filename"))
										{ 
											fieldfilename=words[words.length-1];
										}
									}
								  }
								  //checking fieldhashcode with filename and produce error;


								  if(fieldnextlink=="")
									  {haslink=false;
									  writer3.write("\nNextlink:"+nodetextname);
								      }
								  else
									  {
									  nodetempname=fieldnextlink;
									  writer3 = new FileWriter(file3);


								      }

								  }
								  writer3.close();
							 }
						 
					     }
					 
						
		  }//try
		  catch(Exception e)
		  {
			  out.println(e);
		  }
   }//doget
   // timestamp creation....
   //

}//log3
class Crypto 
	{

   static void fileProcessor(int cipherMode,String key,File inputFile,File outputFile){
	 try {
	       Key secretKey = new SecretKeySpec(key.getBytes(), "AES");
	       Cipher cipher = Cipher.getInstance("AES");
	       cipher.init(cipherMode, secretKey);

	       FileInputStream inputStream = new FileInputStream(inputFile);
	       byte[] inputBytes = new byte[(int) inputFile.length()];
	       inputStream.read(inputBytes);

	       byte[] outputBytes = cipher.doFinal(inputBytes);

	       FileOutputStream outputStream = new FileOutputStream(outputFile);
	       outputStream.write(outputBytes);

	       inputStream.close();
	       outputStream.close();

	    } catch (Exception e) {
		e.printStackTrace();
            }
     }
	
     }
	



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

