class Sort
{
public static void main(String args[])
	{
	Sort s=new Sort();
	int[] a=new int[]{50,60,-20,30,-10,40}
	int[] r=s.sortingUsingSingleLoop;
	for(int temp:r)
		{
		System.out.print(temp+" ");
		}
	}
	int[] sortingUsingSingleLoop(int b[])
	{
	for(int x:b)
		{
		if(x>x+1)
			{
			int t=x;
			x=x+1;
			x+1=t;
			}
		}
	return b;
	}
}