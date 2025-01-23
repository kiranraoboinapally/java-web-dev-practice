class User
{
public static void main(String args[])
	{
	User us=new User();
	int[] a=new int[]{10,20,30,40,50,60,70,80,90};
	int rotate=2;
        for(int x=1;x<=rotate;x++)
	{
	int[] r=us.leftRotate(a);
	for(int z:r)
	System.out.print(z+" ");
        System.out.println();
	}
	
	}
int[] leftRotate(int[] a)
	{
	int x,temp=a[0];
	for(x=0;x<a.length-1;x++)
		{
		a[x]=a[x+1];
		}
	a[x]=temp;
	return a;
	}
}