class practice
{
public static void main(String args[])
	{
	Thread[] t=new Thread[3];
	Runnable r1=()->
		{
		try {
			t[1].join();
			for(int x=0;x<5;x++)
				System.out.println(Thread.currentThread().getName());
		}
		catch(InterruptedException e)
			{
			e.printStackTrace();
			}
		};
		Runnable r2=()->
		{
		try {
			t[0].join();
			for(int x=0;x<5;x++)
				System.out.println(Thread.currentThread().getName());
		}
		catch(InterruptedException e)
			{
			e.printStackTrace();
			}
		};
		Runnable r3=()->
		{
		try {
			t[3].join();
			for(int x=0;x<5;x++)
				System.out.println(Thread.currentThread().getName());
		}
		catch(InterruptedException e)
			{
			e.printStackTrace();
			}
		};
		t[1].start(r1,"abc");
		t[2].start(r2,"pqr");
		t[3].start(r3,"xyz");
	}
}

/*
why in java Object class has wait,notify,notify all,wait all methods why not in thread class

*/
