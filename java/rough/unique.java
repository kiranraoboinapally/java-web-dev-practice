import java.util.Arrays;
class Unique
{
public static void main(String args[])
	{
	Unique ue=new Unique();
	int a[]=new int[]{1,9,2,1,9,3,0,2,5,2};
	ue.uniqueElements(a);
	String res=ue.missingElements(a);
	System.out.print(res+" ");
	}
void uniqueElements(int a[])
	{
	int b[]=new int[a.length];
	for(int x=0;x<=a.length-1;x++)
		{
		int count=1;
		if(b[x]==1){
		continue;}
		for(int y=x+1;y<a.length;y++)
			{
			if(a[x]==a[y])
				{
				count++;
				b[y]=1;
				}
			}
		if(count>1)
		System.out.print(a[x]+" ");
		}
	}

String missingElements(int[] a)
	{
	Arrays.sort(a);
	String res="";
	for(int x=a[0];x<=a[a.length-1];x++)
		{
		int count=0;
		for(int y=0;y<a.length;y++)
			{
			if(x==a[y])
				{
				count++;
				break;
				}
			}
		if(count==0)
			{
			res=res+x+" ";
			}
		}
	return res;
	}

void uniqueElementsSum(int a[])
	{
	int b[]=new int[a.length];
	for(int x=0;x<=a.length-1;x++)
		{
		int count=1;
		if(b[x]==1){
		continue;}
		for(int y=x+1;y<a.length;y++)
			{
			if(a[x]==a[y])
				{
				count++;
				b[y]=1;
				}
			}
		if(count>1)
		System.out.print(a[x]+" ");
		}
	}
}