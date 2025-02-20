class Demo
{
public static void main(String args[])
	{
	AbstractParent p=new Child();
	p.add();
	p.sub();
	p.mul();
	p.div();
	}
}
abstract class AbstractGrandParent
{
void add()
	{
	System.out.println("add in GP");
	}
abstract void sub();
abstract void mul();
abstract void div();
}
abstract class AbstractParent extends AbstractGrandParent
{
@Override
void sub()
	{
	System.out.println("sub in P");
	}
}
class Child extends AbstractParent
{
@Override
void mul()
	{
	System.out.println("mul in C");
	}
@Override
void div()
	{
	System.out.println("div in C");
	}	
}