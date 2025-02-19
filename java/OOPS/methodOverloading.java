class MethodOverloading 
{
public static void main(String args[]) 
	{
        Demo demo = new Demo();
        //Calling the overloaded methods
        demo.display(10); //Calls the method with an integer argument
        demo.display("Hello, World!"); //Calls the method with a string argument
        demo.display(5,"Java"); //Calls the method with both integer and string arguments
    }
}
class Demo 
{
//Method with one integer parameter
void display(int x) 
	{
        System.out.println("Display integer: " + x);
    	}
// Method with one string parameter
void display(String str) 
	{
        System.out.println("Display string: " + str);
    	}
//Method with both integer and string parameters
void display(int x, String str) 
	{
        System.out.println("Display integer and string: " + x + ", " + str);
    	}
}

