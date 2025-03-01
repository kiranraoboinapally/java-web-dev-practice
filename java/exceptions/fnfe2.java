import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class TryWithResourcesExample 
{
public static void main(String[] args) 
	{
        String path = "C:/path/to/your/file.txt";        
// Try-with-resources ensures Scanner is closed automatically after use
        try (Scanner sc = new Scanner(new File(path))) 
		{
           	while (sc.hasNextLine()) 
			{
                	System.out.println(sc.nextLine());
            		}
        	} 
	catch (FileNotFoundException e) 
		{
           	System.out.println("File not found");
       		}
    	}
}
/*
->Try-With-Resources simplifies resource management by automatically closing resources, reducing code complexity, and preventing resource leaks.
->Normal Try-Catch requires manual handling of resource closure, which increases the potential for errors and resource management issues.

*/