class constructor 
{
public static void main(String[] args) 
	{
	Demo demo=new Demo();
	Demo demo1=new Demo(10,20);
	System.out.println(demo.z);
	}
}
	class Demo
	{
	Demo()
		{
		System.out.println("No parameters");
		}
	int x,y;
	int z=10;
Demo(int a,int b)
	{
	System.out.println("Two Parameters");
	System.out.println(this.x+" "+this.y);/* 0 0 as instance variable.If its from another class then we make className.x or className.y */
	System.out.println(a+" "+b);//local variable
	}
//Demo(int p,int q) cannot be created as before one because already created.
Demo(int p,char q)
	{
	System.out.println("Char and int parameter");
	}
//Demo(char q,int p) can be created as both are reverse parameterized i.e.,order is different.
//Demo(int a,int b, int c)can be created its 3 parameters of all are int types.

}
