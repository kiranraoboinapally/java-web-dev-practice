class selectionSort
{
public static void main(String args[])
	{
	int a[]=new int[]{50,40,30,20,10};
	for(int i=0;i<a.length-1;i++)
		{
		int m=i;
		for(int j=i+1;j<a.length;j++)
			{
			if(a[m]>a[j])
				{
				m=j;
				}
			}
		int temp=a[i];
		a[i]=a[m];
		a[m]=temp;
		}
	for(int k:a)
	System.out.print(k+" ");
	}
}