class Demo
{
public static void main(String args[])
	{
	final int num=10;
	Child c=new Child();
	//num=20;// outputs error
	final StringBuilder str=new StringBuilder("Hello");
	str.append(" World"); //This is allowed as the object itself is modified
	//str=new StringBuilder("New String"); //This will give a compile-time error
	}
}
class Parent 
{
public final void display() 
	{
        System.out.println("Display from Parent");
    	}
}
class Child extends Parent 
{
//Cannot override the display method because it's final
@Override
void display()
	{
	System.out.println("Display from child");
	}
}
