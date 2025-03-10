class thread138
{
public static void main(String args[])
	{
	Runnable r1=()->
		{
		for(int x=0;x<5;x++)
			System.out.println(Thread.currentThread().getName()+"==>"+Thread.currentThread().getPriority());
		};
	Thread t1=new Thread(r1,"abc");
	Thread t2=new Thread(r1,"xyz");
	Thread t3=new Thread(r1,"pqr");
	t1.start();
	t2.start();
	t3.start();
	}
}

