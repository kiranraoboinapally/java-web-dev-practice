class thisVsSuper
{
int x;
thisVsSuper(int x)
	{
	this.x=x;
	}
public void method1()
	{
	System.out.println("Method1 of thisVsSuper");
	}
}
class diff extends thisVsSuper
{
int x;
diff(int x)
	{
	super(5);
	this.x=x;
	}
public void method1()
	{
	super.method1();
	System.out.println("Method 1 of diff");
	System.out.println("Variable of thisvssuper class"+super.x);
	System.out.println("Variable of diff class "+this.x);
	}
}
public class Demo
{
public static void main(String args[])
	{
	diff obj=new thisVsSuper(10);
	obj.method1();
	}
}

