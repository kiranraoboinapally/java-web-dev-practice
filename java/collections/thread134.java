iimport java.util.*;

public class practice {

	public static void main(String[] args) {
		Demo demo1=new Demo();
		Thread t1=new Thread(demo1,"One");
		Thread t2=new Thread(demo1,"Two");
		t1.start();
		t2.start();
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



