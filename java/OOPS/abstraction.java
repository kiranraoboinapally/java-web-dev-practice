
//hiding internal implementationhighlighting functonality
//Abstract method means has no implementation
//for an abstract class cannot create an object
//to do abstraction we need inheritance and override
//abstraction can be achieved by abstract class and interface
//if child is not providing implementation for the abstract method of parent then child class becomes abstract class
//this continues until all the abstract methods are overriden or implemented.
//abstract method of parent class need to be implemented by child class


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