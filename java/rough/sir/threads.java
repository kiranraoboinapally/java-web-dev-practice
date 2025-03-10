public class Main4 
{
  static int count;
  public static void main(String[] args) 
  {
    Demo t1 = new Demo();
    System.out.println(t1.getState());
    t1.start();
    System.out.println(t1.getState());
    try 
    {
      t1.join();
      System.out.println("main try");
    } 
    catch (InterruptedException e)
    {
      // TODO Auto-generated catch block
      e.printStackTrace();
      System.out.println("main catch");
    }
    System.out.println(t1.getState());
    Demo t2 = new Demo();
    Demo t3 = new Demo();
    
    System.out.println("main thread");
    System.out.println(t1.getState());
    
    //t1.interrupt();
  }

}
class Demo extends Thread 
{
  
  public synchronized void run() 
  {
    try {
      Thread.sleep(1000);
      System.out.println("try");
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      System.out.println("catch");
      e.printStackTrace();
    }
  }
  
  
}