class rowp2
{
public static void main(String args[])
	{
	int a[][]=new int[][]{{1,2,3},{4,5},{7}};
	int b[][]=new int[a.length][a.length];
	for(int r=0;r<a.length;r++)
		{
		for(int c=0;c<a[r].length;c++)
			{
			b[r][c]=a[r][c]+a[r][c];
			if(b[r][c]<10)
			System.out.print(b[r][c]+" ");
			}
		System.out.println();
		}
	}
}