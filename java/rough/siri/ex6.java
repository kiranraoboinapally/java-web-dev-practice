import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
class Main
{
	public static void main(String[] args) throws Throwable
	{
		sub();
		Thread.sleep(1000);

	}
	static void sub() throws Exception

	{
		add();
		Scanner s = new Scanner(new File("C:/Users/hp/OneDrive/Desktop/hi.txt"));
		System.out.println(s.nextLine());

	}
	static void add() throws ClassNotFoundException
	{
		Class.forName("java.util.Scanner");
		System.out.println("hello");

	}


}