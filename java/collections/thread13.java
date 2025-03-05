import java.util.*;

public class practice {

	public static void main(String[] args) {
		Demo demo1=new Demo();
		Thread t1=new Thread(demo1,"t1 One");
		Thread t2=new Thread(demo1,"t2 Two");
		Runnable t3=new Thread(demo1,"t3 One");
		t1.start();
		t2.start();
		t3.run();
	}
}
class Demo implements Runnable
{
	@Override
	public void run()
	{
		for(int x=0;x<=5;x++)
		{
			System.out.println("in run "+Thread.currentThread().getName());
		}
	}
}



