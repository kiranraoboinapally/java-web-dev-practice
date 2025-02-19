/*
covariant return types
*/
class Demo
{
public static void main(String args[])
	{
	Parent p=new Child();
	p.add();
	}
}
class A
{}
class B extends A
{}
class Parent
{
A add()
	{
	System.out.println("add in Parent");
	return null;
	}
}
class Child extends Parent
{
B add()
	{
	System.out.println("add in Child");
	return null;
	}
}
