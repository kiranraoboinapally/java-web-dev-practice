class Demo 
{
public static void main(String args[])
	{
	Parent p=new Child(); //Child but referencing it using the Parent type.
	p.add();
	Parent.add(); //for calling static methods
	}
}
class Parent
{
static void add()
	{
	System.out.println("add in Parent");
	}
}
class Child extends Parent
{
static void add()
	{
	System.out.println("add in Child");
	}
}
//static methods are bound at compile time.
/*The method that gets called depends on the reference type at compile-time, not the object type at runtime*/
/* When a static method is defined in both the parent and child classes with the same signature, it is not an overriding scenario. Instead, the method in the child class hides the method in the parent class. Static methods are not dynamically dispatched based on the object type. Instead, they are resolved at compile-time based on the reference type.*/