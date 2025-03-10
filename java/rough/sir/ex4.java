class Main
{
	public static void main(String[]args)
	{
		Student m = new Student();
		m.add();
		
	}
	
}
class Student
{
	void add()
	{
		try
		{
			System.out.println(10/0);
		}
		catch(ArithmeticException e)
		{
			System.out.println("catched");
			e.printStackTrace();//to trace the stack where exception ocurred
			System.out.println("Message: "+e.getMessage());//to display the only description of the exception.
		}




	}
	


}
