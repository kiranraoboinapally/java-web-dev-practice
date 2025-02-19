/*name roll collegename(static) section(final) instance variables
display()*/
class Demo
{
public static void main(String args[])
	{
	Student student1=new Student("Aryan","Badruka College",123,'A');
	student1.display();
	
	}
}
class Student
{
static String collegeName="";
String name="";
int rollNumber;
final char section='A';
Student(String name,String collegeName,int rollNumber,char section)
	{
	this.name=name;
	this.collegeName=collegeName;
	this.rollNumber=rollNumber;
	this.section=section;
	}
void display()
	{
	System.out.println("Name is "+name+" Section is "+section+" Roll Number is "+rollNumber+" College Name is "+collegeName);
	}
}


