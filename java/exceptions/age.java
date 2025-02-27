class age123
{
public static void main(String[] args) 
	{
	Demo demo=new Demo();
	Demo demo1=new Demo(10,20);
    	}
}
class Demo
{
Demo()
	{
	System.out.println("No parameters");
	throw new NullPointerException("ne");
	}
int x,y;
Demo(int a,int b)
	{
	System.out.println(x+" "+y);
	throw new ArithmeticException("ae1");
	}
Demo(int p,char q)
	{
	System.out.println("Char and int parameter");
	}
}
