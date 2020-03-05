import java.io.*;
import java.util.*;
class Node
{
	
	File f1;
	String tp1="",hash1="";
	LinkedList<Node> link= new LinkedList<Node>();
	public Node(File f,String hash,String tp)
	{
		f1=f;
		hash1=hash;
		tp1=tp;
		
	}
	LinkedList createNode(File f,String hash,String tp)
	{
	
    Node nn = new Node(f,hash,tp);
    link.add(nn);
	return link;
	}
	
}
class Hi
{
 public static void main(String ab[])
 {
	File f=null;
	String a="shfg";
	String b="sfsf";
	LinkedList<Node> link1= new LinkedList<Node>();
	Node n=new Node(f,a,b);
	
	link1=n.createNode(f,a,b);
	link1=n.createNode(f,b,a);
	System.out.println(link1.get(1).hash1);
 }
}
 