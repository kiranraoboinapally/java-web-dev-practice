class constructorInside
{
public static void main(String[] args) 
	{
	Demo demo=new Demo();
	demo.display();
    	}
}
class Demo
{
int empId;
double empSalary;
String empName,empJob;
Demo()
	{
	this("Anvitha",50000);/*this is used to access below constructor by passing paramenters and it should be used first of the statement*/
	empId=17441007;	      //only one constructor can be used inside a constructor.
	}
Demo(String empName,double empSalary)
	{
	this("Data Analyst");
	this.empName=empName;
	this.empSalary=empSalary;
	}
Demo(String empJob)
	{
	this.empJob=empJob;
	}
void display()
	{
	System.out.println("Employee Id is: "+empId+"\nEmployee Name is: "+empName+"\nEmployee Job is: "+empJob+"\nEmployee Salary is: "+empSalary);
	}
}
