class Main
{
	public static void main(String[] args)
	{
		try
		{
			System.out.println(10/0);
		}
		catch(ArithmeticException e)
		{
			System.out.println("catched");

		}
		finally
		{
			System.out.println("finally");//execute irrespective of exception occured or not occured.
						     //If exception not occured finally will execute first and next exception throw by jvm 

		}


	}


}
