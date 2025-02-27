import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class throws

{
public static void main(String[] args) throws Exception
	{
	sub();
	Thread.sleep(1000);
	}
	static void sub() throws Exception
	{
	String path="C:/Users/arunk/Desktop/chub/java/exceptions/age789.java";
	Scanner sc=new Scanner(new File(path));
	add();
	}
	static void add() throws Exception
	{
	Class.forName("java.util.scanner");
	}
}

/*
if we write in sub(child) as throws Exception then we cant give main method(its parent) childs as throws ClassNotFoundException,FileNotFoundException,InterruptedException
//its applicable only for checked exceptions
//multiple throws can be done at a time but its carryforward to another method
//instead of writing ClassNotFoundException,FileNotFoundException,InterruptedException these we can write as Exception
*/