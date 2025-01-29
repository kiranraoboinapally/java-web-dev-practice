class rowp3
{
public static void main(String args[])
	{
	int a[][]=new int[][]{{1,2,3},{5,6},{7,8,9,10}};
	int max=0;
	for(int r=0;r<a.length;r++)
		{
		for(int c=0;c<a[r].length;c++)
			{
			if(a[r][c]>max);
				{
				max=a[r][c];
				}
			}
		System.out.println("Max Element in "+(r+1)+" row is  "+max);
		}
	}
}