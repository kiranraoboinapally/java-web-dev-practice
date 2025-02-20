//interface contaions only variables and methods.,no body
//in interface constructors cannot be created.
//only abstract methods to be written in interface
class Demo
{
public static void main(String args[])
	{
	One o=new Xyz();
	System.out.println(One.x);//classname.variable because its static no need of object
	o.add();
	o.sub();
	o.div();
	}	
}
interface One
{
	int x=10; //it has static+final+public as default
	void add();//it has abstract and public by default
	abstract public void sub();
	void div();
}
abstract class AbstractAbcImpl implements One
{
@Override
public void add()
	{
		System.out.println("Add in Abc");
	}
public void div()
	{
		System.out.println("Div in Abc");
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