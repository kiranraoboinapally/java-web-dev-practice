import java.util.*;

public class practice {

	public static void main(String[] args) {
		Demo demo1=new Demo();
		Demo demo2=new Demo();
		Demo demo3=new Demo();
		Demo demo4=new Demo();
		demo1.setName("One");
		demo2.setName("Two");
		demo3.setName("Three");
		demo4.setName("Four");
		demo1.start();//only one time thread start we cant start multiple times it throws exception
		demo2.start();
		demo1.run();//it only print in run main that's it 5times

	}
}
class Demo extends Thread
{
	@Override
	public void run()
	{
		for(int x=0;x<=5;x++)
		{
			System.out.println("in run "+Thread.currentThread().getName());
			Thread.sleep(10000);
		}
		//throw new ArithmeticException(); its independent abnormal termination is not done 
	}
}
/*
threads can be 1.Runnable Interface it has only run method
2.Thread Class implements Runnable it has start method and remaining more in thread class but run method is only one from runnable interface
3.
*/

