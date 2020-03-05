import java.math.*; 
import java.security.*;
import java.io.*;
import java.util.*;
import java.sql.*;
import javax.crypto.spec.*;

class Hash
{
	public static void main1(String[] args) 
	{
		
		try{byte[] buffer= new byte[8192];
    int count=0;
    MessageDigest digest = MessageDigest.getInstance("SHA-256");
    BufferedInputStream bis = new BufferedInputStream(new FileInputStream("D:\\Tdaka\\1.txt"));
    while ((count = bis.read(buffer)) > 0) {
        digest.update(buffer, 0, count);
    }
    bis.close();
	String hsh=""; 
    byte[] hash = digest.digest();
	for(int i=0;i<hash.length;i++)
			{
				hsh+=hash[i];	
			}
			System.out.println(hsh);
			//// System.out.println(new Base64Encoder().Encoder(hash));//
		}
	catch(Exception e)
			{
e.printStackTrace();
			}
	}
}
