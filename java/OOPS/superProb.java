class Demo
{
public static void main(String args[])
	{
	Child child=new Child(10);
	}
}
class GrandParent
{
GrandParent(int x)
	{
	System.out.println("Grand Parent with int");
	}
}
class Parent extends GrandParent
{
Parent(int x)
	{
	this();
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
	super();
	System.out.println("Child with int");
	}
}