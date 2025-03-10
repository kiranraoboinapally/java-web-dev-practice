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
		catch(RuntimeException e)
		{
			System.out.println("catched");

		}



	}


}
