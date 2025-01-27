class p2
{
public static void main(String args[])
	{
	int a[]=new int[]{1,2,3,4,5,6,7,8,9,10};
	int size=a.length/2;
	for(int x=size-1;x>=0;x--)
		{
		System.out.print(a[x]+" ");
		}
	for(int x=size;x<=a.length-1;x++)
		{
		System.out.print(a[x]+" ");
		}
	}
}