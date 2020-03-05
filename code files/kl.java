import java.io.*;
import java.util.*;
class kl
{
 public static void main(String ar[])
 {
	
	try{
		String st="sdsdgug",st1="etrytu";
	    File file=new File("D:\\Major Project\\html\\1\\hj.txt");
								 if (file.createNewFile())
								 {
									//the tender details should be kept here in this file
									FileWriter writer = new FileWriter(file);
									writer.write("Username:"+st);
									writer.write("\ndfggg:"+st1);
									writer.close();
								 }						
								 }
								 catch(Exception e)
								 {
									 System.out.println(e);
								 }
 }
}