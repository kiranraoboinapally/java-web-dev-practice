class Main
{
	public static void main(String[]args)
	{
		Main m = new Main();
		m.sub();
		m.mul();
		m.div();
		m.m1();
		m.m2();
		m.add();
	
	}
	void add()
	{
		System.out.println(10/0);//Arithmetic exception
	}
	void sub()
	{
		System.out.println(10.0/0);//Infinity
	}
	void mul()
	{
		System.out.println(10/0.0);//Infinity

	}
	void div()
	{
		System.out.println(10.0/0.0);//Infinity

	}
	void m1()
	{
		System.out.println(-10.0/0.0);//-Infinity

	}
	void m2()
	{
		System.out.println(0.0/0.0);//NaN
	}







}