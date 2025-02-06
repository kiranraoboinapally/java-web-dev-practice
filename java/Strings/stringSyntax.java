//Syntax for Strings

class stringSyntax
{
public static void main(String args[])
	{
	String s1=new String("Hello all");
	//its object creation in heap

	String s2="Hello all";
	//its a literal inside a heap inside a string constant pool

	String s3="Hello all";
	//this and s2 points towards same address it doesnt create new

	String s4=new String("Hello all");
	//it creates new with different address.
	
	System.out.println(s2==s3);
	//it checks address same or not i.e prints true or false => returns true
	//Hello all is data is same for both literals.

	System.out.println(s2.equals(s3));
	//it checks that data provided in it equal or not if both are same data type?.=>returns true

	System.out.println(s1==s4);
	System.out.println(s1+" "+s1.hashCode());
	System.out.println(s4+" "+s4.hashCode());
	//its a different address so returns false but hashcode returns same address Identity has to be used

	System.out.println(s1.equals(s4));
	System.out.println(s1+" "+s2.hashCode());
	System.out.println(s4+" "+s4.hashCode());
	//its value is same so it returns true

	StringBuffer sb1=new StringBuffer("I am Buffer");
	sb1.append(" one");
	System.out.println(sb1);
	s1=s1.concat(" bye");
	System.out.println(s1);
	}
}