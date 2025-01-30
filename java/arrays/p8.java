//divide array into two equal halves 
//first half in ascending order,second half in //descending order
import java.util.Arrays;
class p8
{
public static void main(String args[])
	{
	int a[]=new int[]{8,7,1,5,6,2,3,9,4,10};
	int size;
	Arrays.sort(a);
	if(a.length%2==0)
		{
		size=a.length/2;
		}
	else
		{
		size=a.length/2+1;
		}
	for(int x=0;x<size;x++)
		{
		System.out.print(a[x]+" ");
		}
	for(int x=a.length-1;x>=size;x--)
		{
		System.out.print(a[x]+" ");
		}
	}
}