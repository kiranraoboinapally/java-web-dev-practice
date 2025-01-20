class Solution
{
public static void main(String args[])
	{
	Demo demo=new Demo();
	demo.method1(new int[]{10,20,30,40,50,60,70,80,90});
	}
}


class Demo
{
void method1(int a[])
	{
	int b[]=new int[a.length/2+1];
	int j=0;
	for(int i=0;i<a.length;i++)
		{
		if(i%2==0)
			{
			b[j++]=a[i];
			}
		}
	for(int i=0;i<b.length;i++)
		{
		System.out.print(b[i]+" ");
		}
	System.out.println();
	int c[]=new int[a.length-j];
	int k=0;
	for(int i=0;i<a.length;i++)
		{
			if(i%2!=0){
			c[k++]=a[i];}
		}
	for(int i=0;i<c.length;i++)
		{
		System.out.print(c[i]+" ");
		}

	}
}