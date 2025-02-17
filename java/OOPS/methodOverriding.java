//run time polymorphism

class methodOverriding
{
public static void main(String args[])
	{
	Demo demo=new Demo();
	demo.add();
	}
}
class GrandParent
{
void add()
	{
	System.out.println("I am add of Grand Parent");
	}
}
class Parent extends GrandParent
{
void sub()
	{
	System.out.println("I am sub of parent");
	}
@Override
void add()
	{
	System.out.println("I am add of parent");
	}
}
