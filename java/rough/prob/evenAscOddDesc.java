class evenAscOddDesc 
{
public static void main(String args[])
	{
	evenAscOddDesc eo=new evenAscOddDesc();
	int a[]=new int[]{9,5,2,8,3,6,1,7,4};	
	eo.evenAsc(a);
	}
void evenAsc(int []b)
	{
	int c[]=new int[b.length];
	for(int x=0;x<b.length;x++)
		{
		if(b[x]%2==0)//2,8,6,4
			{int j=0;
			for(int y=0;y<b.length;y++)
				{
				c[j++]=b[x];
				}
			}
		}
	for(int k:c)
	System.out.print(k+" ");
	}
}