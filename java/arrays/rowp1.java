class rowp1
{
public static void main(String args[])
	{
	int a[][]=new int[][]{{1,2,3},{4,5,6},{7,8,9}};
	for(int r=0;r<a.length;r++)
		{
		for(int c=0;c<a[r].length;c++)
			{
			if(r==c||r+c==a.length-1)
			System.out.print(a[r][c]+" ");
			else
			System.out.print("  ");
			}
		System.out.println();
		}
	}
}