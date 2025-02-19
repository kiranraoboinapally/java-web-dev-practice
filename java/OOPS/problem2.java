/*Can we overload the static method in java? */
class P2 
{
//Static method with one integer parameter
public static void display(int x) 
	{
        System.out.println("Display integer: " + x);
    	}
//Static method with one string parameter
public static void display(String str) 
	{
        System.out.println("Display string: " + str);
    	}
//Static method with two parameters (one integer and one string)
public static void display(int x, String str) 
	{
        System.out.println("Display integer and string: " + x + ", " + str);
    	}
public static void main(String[] args) 
	{
//Calling the overloaded static methods
        display(10);
        display("Hello, World!");
        display(5, "Java");
    }
}
//static only works within that class cannot be accessed to further class i.e inheritnace cannot be done it 
//method overriding cannot be done in it
//if static int x=10; x=20 then it stors only last value in class area
//static can given to instance variables not for local variables its memory management.
//static can be called with its class name if its in another class