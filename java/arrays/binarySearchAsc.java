class binarySearchAsc
{
public static void main(String args[])
	{
	int a[]=new int[]{40,10,50,30,20};
	for(int x=0;x<a.length-1;x++)
		{
		for(int y=x+1;y<a.length;y++)
			{
			if(a[x]>a[y])
				{
				int temp=a[x];
				a[x]=a[y];
				a[y]=temp;
				}
			}
		}
	for(int x=0;x<a.length;x++)
		{
		System.out.print(a[x]+" ");
		}
	int f=0,l=a.length-1,m,search=30;
	for(;f<=l;)
		{
		m=(f+l)/2;
		if(search==a[m])
			{
			System.out.println("\nElement found");
			break;
			}
		else if(search>a[m])
			f=m+1;
		else if(search<a[m])
			l=m-1;
		}
	if(f>l)
	System.out.println("\nElement not found");
	}
}