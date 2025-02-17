class Demo
{
public static void main(String args[])
	{
	SubClass subclass=new SubClass(10);
	}
}
class SuperClass
{
int x=10;
SuperClass(int x)
	{
	this.x=x;
	System.out.println(this.x);
	}
SuperClass()
	{
	System.out.println("SuPerClass");
	}
}
class SubClass extends SuperClass
{
SubClass(int y)
	{
	super();
	System.out.println("SubClass");
	System.out.println(x);
	SuperClass superclass=new SuperClass(50);
	}
}