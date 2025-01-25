class Solution
{
public static void main(String args[])
	{
	Demo demo=new Demo();
	System.out.println("Case 1 for ODD Length:");	
	demo.method(new int[]{10,20,30,40,50,60,70,80,90},0,0);
	System.out.println("Case 2 for EVEN Length:");
	demo.method(new int[]{1,2,3,4,5,6},0,0);
	}
}

class Demo
{
void method(int a[],int j,int k)
	{
	int size;
	int[] b;
		if(a.length%2!=0)
		{	
		size=a.length/2+1;
		 //b=new int[size];
		}
	else
		{
		size=a.length/2;
		 //b=new int[size];
		}
		
	for(int i=0;i<a.length;i++)
		{
		if(i%2==0)
			{
			b[j++]=a[i];
			}
		}
	System.out.print("b[] Array elements are ");
      	for(int i=0;i<b.length;i++)
		{
		System.out.print(b[i]+" ");
		}
	System.out.println();
	int c[]=new int[a.length-j];
	for(int i=0;i<a.length;i++)
		{
			if(i%2!=0){
			c[k++]=a[i];}
		}
	System.out.print("c[] Array elements are ");
      	for(int i=0;i<c.length;i++)
		{
		System.out.print(c[i]+" ");
		}
	System.out.println();

	}
}