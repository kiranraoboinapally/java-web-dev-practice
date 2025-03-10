class Main
{
	public static void main(String[]args)
	{
		Main main = new Main();
		main.add();
		try
		{
			System.out.println(10/0);

		}
		catch(ArithmeticException e)
		{
			System.out.println("catched");


		}
		main.sub();


	}
	void add()
	{
		System.out.println("add method");

	}
	void sub()
	{
		System.out.println("sub method");

	}

}