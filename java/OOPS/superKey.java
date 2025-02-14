class Demo
{
public static void main(String args[])
	{
	Child child=new Child();
	}
}
class GrandParent
{
GrandParent(int x)
	{
	System.out.println("Grand Parent with int");
	}
GrandParent(int x,double y)
	{
	System.out.println("Grand Parent with int,double");
	}
}
class Parent extends GrandParent
{
Parent(int x)
	{
	System.out.println("Parent with int");
	}
Parent()
	{
	super(10);
	System.out.println("Parent with Default");
	}
}
class Child extends Parent
{
Child(int x)
	{
	System.out.println("Child with int");
	}
Child()
	{
	System.out.println("Child with Default");
	}
Child(char c,int x)
	{
	System.out.println("Child with char,int");
	}
}