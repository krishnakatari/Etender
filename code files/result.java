import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.sql.*;
import javax.crypto.*;
import javax.crypto.spec.*;
import java.util.*;
import java.security.*;
import java.math.BigInteger;

public class result{

 public static void main(String x[])
       {
		  try{
   ResultSet rs=null;
   Class.forName("com.mysql.jdbc.Driver");
	
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db","root","root");    
	PreparedStatement st=null;
					st = con.prepareStatement("SELECT uname FROM tenderer");
					rs=st.executeQuery();
					String twinner="";
					int tprice=100000;
					int lastupdateprice=100000;
					while(rs.next())
						{
						String tmpuname=rs.getString("uname");
						File dir=new File("D:\\"+tmpuname);//change the directory name to some different folder
						  if(dir.isDirectory())
					  {
						File[] files = dir.listFiles();
						int flen=files.length/2+1;
						

						for(int i=1;i<flen;i++)
						{
							//decrypting
						String key = "This is a secret";
								//  File inputFile     = new File("D:\\"+tmpuname+"\\"+filetextname);
								File encryptedFile = new File("D:\\"+tmpuname+"\\"+"F"+i+".txt");
								File decryptedFile = new File("D:\\"+tmpuname+"\\"+"F"+i+".txt");
								Crypto crypto=new Crypto();
								//crypto.fileProcessor(Cipher.ENCRYPT_MODE,key,inputFile,encryptedFile);
	                            crypto.fileProcessor(Cipher.DECRYPT_MODE,key,encryptedFile,decryptedFile);
	     
//over

							FileReader fr = new FileReader("D:\\"+tmpuname+"\\"+"F"+i+".txt");  //Creation of File Reader object
									BufferedReader br = new BufferedReader(fr); //Creation of BufferedReader object
									String[] words=null;
									String s="";//tp is used to store the timestamp
									while((s=br.readLine())!=null)   //Reading Content from the file
								  { 
									  //System.out.println(s);
									 words=s.split(":");  //Split the word using space
									for (int index=0;index<words.length;index++)
									{   
										if(words[index].equals("Timestamp"))
										{ 
											System.out.println("Quoted at Time stamp:"+words[words.length-3]+" : "+words[words.length-2]+" : "+words[words.length-1]);
										}
										if(words[index].equals("Quoataion Price"))
										{ 
											System.out.println("Quoted price:"+words[words.length-1]);
											lastupdateprice=Integer.parseInt(words[words.length-1]);
										}
									}
								  }
								  br.close();
						
							
						}
						if(tprice>lastupdateprice)
											{
											tprice=lastupdateprice;
											twinner=tmpuname;
											}
					  }
							   
						
					    }
						System.out.println("Minimum Amount:"+tprice+"\nTender Approved to:"+twinner);
						
		  }//try
		  
		  catch(Exception e)
		  {e.printStackTrace();}
	  }//doGet
}//clientlog2

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