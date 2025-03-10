//Try with resources

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class Main
{
	public static void main(String[] args)
	{
		try(Scanner s = new Scanner(new File("C:/Users/hp/OneDrive/Desktop/hi.txt")); )
		{
         		System.out.println(s.nextLine());

       		}
 		catch (FileNotFoundException e)
		{
           			 System.out.println("catched");
       		}
			
	}

}
