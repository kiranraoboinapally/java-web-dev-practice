class Sort
{
public static void main(String args[])
	{
	Sort s=new Sort();
	int[] a=new int[]{50,60,-20,30,10,40};
	int[] r=s.sortingUsingSingleLoop(a);
	for(int x=0;x<a.length-1;x++)
	{
	System.out.println(a[x]);
	}
	for(int temp:r)
		{
		System.out.print(temp+" ");
		}
	}
	int[] sortingUsingSingleLoop(int b[])
	{
	for(int x=0;x<b.length-1;x++)
		{
		if(b[x]>b[x+1])
			{
			int t=b[x];
			b[x]=b[x+1];
			b[x+1]=t;
			x=-1;
			}
		}
	return b;
	}
}