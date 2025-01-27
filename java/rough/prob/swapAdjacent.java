class swapAdjacent
{
public static void main(String args[])
	{
	int a[]=new int[]{1,2,3,4,5,6,7,8,9};
	for(int x=0;x<a.length;x++)
	{
		for(x=0;x<a.length-1;x++)
		{
		int temp=a[x];
		a[x]=a[x+1];
		a[x+1]=temp;
		break;
		}
	}
	for(int t:a)
	System.out.print(t+" ");
	}
}