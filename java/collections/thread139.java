class practice
{
public static void main(String args[])
	{
	Runnable r1=()->
		{
		for(int x=0;x<5;x++)
			System.out.println(Thread.currentThread().getName());
		};
	Thread t1=new Thread(r1,"abc");
	Runnable r2=()->
		{
			try {
				//System.out.println(Thread.currentThread().getName()+" I am abc"); if we write above join it will be printed
				t1.join();
			for(int x=0;x<10;x++)
				System.out.println(Thread.currentThread().getName());
			}
			catch(InterruptedException e)
			{
				e.printStackTrace();
			}
		};
		Thread t2=new Thread(r2,"xyz");
		t1.start();
		t2.start();
		Runnable r3=()->
		{
			try {
			t2.join();
			for(int x=0;x<3;x++)
				System.out.println(Thread.currentThread().getName());
			}
			catch(InterruptedException e){
				e.printStackTrace();
			}
		};
		Thread t3=new Thread(r3,"pqr");
		t3.start();
	}
}



/*
 join concepts first join will be executed next it will execute nextt statement where it is present the code
 
 in r1(
 {
 t3.join()
 }
 )
 
 
 in r2(
 {
 t1.join()
 }
 )
 
 in r3(
 {
 t2.join()
 }
 )
 
 its deadlock because infinte waiting loop among those
 */

