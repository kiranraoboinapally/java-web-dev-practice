//divide array into two equal halves 
//sort odd indexed arrays in ascending order and even indexed arrays in descedning order
//7 5 2 9 10 ascend it 2 5 7 9 10 and 8 1 6 3 4 descend it 8 6 4 3 1
//ouput as 2 5 7 9 10 8 6 4 3 1

class p9
{
public static void main(String args[])
	{
	int a[]=new int[]{8,7,1,5,6,2,3,9,4,10};//8 5 1 2 6 7 3 9 4 10
	int a_size=0;
	if(a.length%2!=0)
	a_size=(a.length/2)+1;
	else
	a_size=a.length/2;
	for(int x=0;x<=a_size;x++)
		{
		if(x%2!=0)
			{
			if(a[x]>a[x+2])
				{
				int temp=a[x];
				a[x]=a[x+2];
				a[x+2]=temp;
				}
			}
		}
	for(int t:a)
	System.out.print(t+" ");
	}
}