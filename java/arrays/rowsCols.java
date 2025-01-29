//2d arrays
class rowsCols
{
public static void main(String args[])
	{
	int b[][]=new int[][]{{1,2,3,4},{9,8},{7},{3,4,5},{1,2,3}};
	System.out.println("Using for Loop");
	for(int r=0;r<b.length;r++)
		{
		for(int c=0;c<b[r].length;c++)
			{
			System.out.print(b[r][c]+" ");
			}
		System.out.println();
		}
	System.out.println("Using for-each-enhanced Loop");
	for(int k[]:b)
		{
		for(int j:k)
			{
			System.out.print(j+" ");
			}
		System.out.println();
		}
	
	}
}