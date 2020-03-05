import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.*;
import java.text.SimpleDateFormat;  
import java.util.Date;  

class Simple{  
    public static void main(String args[]) throws Exception{  
     
String file = "E:\\1.txt";
Path filepath = Paths.get(file);
        BasicFileAttributes attr = Files.readAttributes(filepath, BasicFileAttributes.class);
        FileTime date = attr.creationTime();
        SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        String dateCreated = df.format(date.toMillis());
        System.out.println(dateCreated);
 
    }  
}  