public class raceCondition {
	static int count;
	public static void main(String[] args) {
	Runnable r=()->
		{
		for(int x=0;x<10;x++)
		System.out.println(Thread.currentThread().getName()+" "+(++count));
		};
		Thread t1=new Thread(r,"One");
		Thread t2=new Thread(r,"Two");
		t1.start();
		t2.start();
	}
}

//using lambda expression
