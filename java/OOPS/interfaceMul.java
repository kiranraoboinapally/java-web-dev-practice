
class Demo
{
public static void main(String args[])
	{
	AbstractAbcImpl ab=new Xyz();
	System.out.println(One.x);
	ab.add();
	ab.sub();
	}	
}
interface One
{
	int x=10;
	void add();
}
interface Two
{
	abstract public void sub();
}
abstract class AbstractAbcImpl implements One,Two
{
@Override
public void add()
	{
		System.out.println("Add in Abc");
	}
}
class Xyz extends AbstractAbcImpl
{
@Override
public void sub()
	{
		System.out.println("Sub in Xyz");	
	}
}