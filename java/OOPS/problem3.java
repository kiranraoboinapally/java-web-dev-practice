/*Can we overload the final method in java? */
class P3 
{
//Final method
final void display(int x) 
	{
        System.out.println("Displaying: " + x);
    	}
//Overloaded final method with a different parameter
final void display(String s) 
	{
        System.out.println("Displaying: " + s);
        }
public static void main(String[] args) 
	{
        P3 obj = new P3();
        obj.display(10);      //Calls display(int x)
        obj.display("Hello"); //Calls display(String s)
    	}
}
//using final we cant override it in subclass