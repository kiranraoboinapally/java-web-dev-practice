/*Can we overload the main method in java? */
class P1 
{
//Original main method
public static void main(String[] args) 
	{
        System.out.println("Original main method");
        main(10); //Calling overloaded main method
    	}
    	//Overloaded main method with an integer parameter
public static void main(int x) 
	{
        System.out.println("Overloaded main method with int: " + x);
    	}
    	//Overloaded main method with a double parameter
public static void main(double y) 
	{
        System.out.println("Overloaded main method with double: " + y);
    }
}
