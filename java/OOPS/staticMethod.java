//method hiding
//static method data will be different to each class i.e., cannot be override.
class Demo
{
public static void main(String ars[])
	{
	Parent child1=new child();
	Parent.add();
	child1.add();
	}
}
class Parent{
static void add()
	{
	System.out.println("Add of Parent");
	}
}
class child extends Parent
{
//@Override errors for it 
static void add()
	{ // it will be hided and gives above class method
	System.out.println("Add of Child");
	}
}


