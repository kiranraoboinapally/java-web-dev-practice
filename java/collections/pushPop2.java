import java.util.List;
import java.util.*;
public class practice
{
	private static final int CAPACITY=5;
	private final List<Integer> list=new ArrayList<>();
	public static void main(String args[])
	{
		practice practice=new practice();
		Runnable r1=()->
		{
			for(int x=0;x<5;x++)
				try {
					practice.produce(x);
				}catch(InterruptedException e)
			{
					Thread.currentThread().interrupt();
					System.out.println("Producer was interrupted");
			}
		};
		Runnable r2=()->
		{
			for(int x=0;x<5;x++)
				try {
					practice.consume();
				}catch(InterruptedException e)
			{
					Thread.currentThread().interrupt();
					System.out.println("Producer was interrupted");
			}
		};
		Thread t1=new Thread(r1);
		Thread t2=new Thread(r2);
		t1.start();
		t2.start();
	}
		
		private synchronized void produce(int item) throws InterruptedException
		{
			while(list.size()==CAPACITY)
			{
				System.out.println("Prdoucer is waiting list is full " +list);
				wait();
			}
			list.add(item);
			System.out.println("Produced "+item);
			notify();
		}
		private synchronized void consume()throws InterruptedException
		{
			while(list.isEmpty())
			{
				System.out.println("Consumer is waiting list is empty " +list);
				wait();
			}
			int item=list.remove(0);
			System.out.println("consumed: "+item);
			notify();
		}
		
	}

