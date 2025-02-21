class Demo 
{
public static void main(String args[]) 
	{
        //Example of declaring and initializing an object reference of a superclass type
        //SubClass2 subclass2=new SubClass2(); 
	//Direct object creation(commented out for explanation)
        
        //Also can write as:
        //SubClass2 subclass2;  //Declaration of SubClass2 reference
        //subclass2=new SubClass2(); //Initialization at runtime
        
        //Here, we are using upcasting. We declare a reference of type SuperClass
        //but instantiate it with an object of type SubClass2.
        SuperClass subclass2=new SubClass2(); //Object of SubClass2 assigned to SuperClass reference
        
        //Calling methods on the SuperClass reference pointing to a SubClass2 object.
        
        //This will call the `add()` method from SubClass2 because it's overridden there.
        subclass2.add(); //add of SubClass2
        
        //This will call the `div()` method from SubClass1 because it's overridden in SubClass1.
        subclass2.div(); //div of SubClass1
        
        //This will call the `mul()` method from SuperClass because it's not overridden anywhere else.
        subclass2.mul(); //mul of SuperClass
        
        //The next line would result in a compile-time error because `sub()` is not in SuperClass.
        //You can't call a method that doesn't exist in the reference type (SuperClass in this case).
        //subclass2.sub(); //Error: Cannot resolve method 'sub' in 'SuperClass'
    }
}

class SuperClass 
{
//SuperClass contains these methods which are inherited by subclasses.
void add() 
	{
        System.out.println("add of SuperClass");
    	} 
void div() 
	{
        System.out.println("div of SuperClass");
    	}
void mul() 
	{
        System.out.println("mul of SuperClass");
    	}
}
class SubClass1 extends SuperClass 
{
//SubClass1 inherits from SuperClass and overrides the div() method.
void sub() 
	{
        System.out.println("sub of SubClass1");
    	}
//Overriding the div() method to provide a new implementation in SubClass1.
@Override
void div() 
	{
        System.out.println("div of SubClass1");
    	}
}

class SubClass2 extends SubClass1 
{
//SubClass2 inherits from SubClass1 and overrides the add() method.
//Overriding the add() method to provide a new implementation in SubClass2.
@Override
void add() 
	{
        System.out.println("add of SubClass2");
 }
    	