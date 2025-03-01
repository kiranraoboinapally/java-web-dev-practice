import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class fnfe
{
    public static void main(String[] args) 
    {
        String path="C:/Users/arunk/Desktop/chub/java/exceptions/age789.java";
        try
        {
            Scanner sc=new Scanner(new File(path));
            while(sc.hasNextLine())
            {
                System.out.println(sc.nextLine());
            }
        }
        catch(FileNotFoundException e) //or Exception its parent class
        	{
            System.out.println("File not found");
        	}
	finally 
		{
            // Manually close the resource to avoid resource leak
            if (sc != null) 
			{
                	sc.close();
            		}
        	}
    }
}

//if file found then it will print the content of the file i.e try block will execute
//if file not found then it will print "File not found" i.e catch block will execute
//if we don't write catch block then it will give compile time error i.e its checked exception

