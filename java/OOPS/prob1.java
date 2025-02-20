/*
create class called Person with name ,age attribute
two instances of person class 
set their attributes using the constructor and print name age
*/
class Person
{
int age;
String name;
public static void main(String args[])
	{
	Person p=new Person(25,"Varun");
	System.out.println(p.age+" "+p.name);
	}
	Person(int age,String name)
	{
	this.age=age;
	this.name=name;
	}
	
}



