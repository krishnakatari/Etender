import java.io.*;
import java.util.*;
class lk
{
	public static void main(String args[])
	{
		try
		{
			File f1=new File("D:\\abhi\\MajorBC\\techSem\\1\\1\\input.txt"); //Creation of File Descriptor for input file
      String[] words=null;  //Intialize the word Array
      FileReader fr = new FileReader(f1);  //Creation of File Reader object
      BufferedReader br = new BufferedReader(fr); //Creation of BufferedReader object
      String s;     
	  String tp="";//tp is used to store the timestamp
       while((s=br.readLine())!=null)   //Reading Content from the file
      {
         words=s.split(":");  //Split the word using space
          for (int index=0;index<words.length;index++)
          {
               if(words[index].equals("TIMESTAMP"))
			   {
				   tp=words[words.length-1];
			   }
          }
      }
	  System.out.println(tp);
	  
		fr.close();}
		catch(Exception e)
		{
			System.out.println("hii u r an exception");
		}
	}
}