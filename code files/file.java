import java.io.File;
import java.text.SimpleDateFormat;
import java.nio.file.*;
import java.nio.file.attribute.*;
import java.util.Calendar;
import java.util.Scanner;
import java.util.Date;  

class Simple
{
    public static void main(String[] args)
    throws Exception{
        Path path = Paths.get("E:\\2.txt");
        BasicFileAttributeView view = Files.getFileAttributeView(path,BasicFileAttributeView.class);

        BasicFileAttributes attributes = view.readAttributes();
        
        // calculate time of modification and creation.
        FileTime lastModifedTime = attributes.lastModifiedTime();
        FileTime createTime = attributes.creationTime();

        long currentTime = Calendar.getInstance().getTimeInMillis();
        FileTime lastAccessTime = FileTime.fromMillis(currentTime);

        view.setTimes(lastModifedTime, lastAccessTime, createTime);
        
       // System.out.println("Creation time of file is : " +attributes.creationTime());
       // System.out.println("Last modification time of file is : " +attributes.lastModifiedTime());
       // System.out.println("Last access time of file is : " +attributes.lastAccessTime());
		
		javaxt.io.File file = new javaxt.io.File("E:\\1.txt");
		System.out.println(file.getName()+" is last accessed at "+file.getLastAccessTime());
		System.out.println(file.getName()+" is last modified at "+file.getLastModifiedTime());
 		
	}
}
