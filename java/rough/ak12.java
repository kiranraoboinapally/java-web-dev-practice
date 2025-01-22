class ak12
{
public static void main(String args[])
	{
	int a[]= new int[]{10,20,30,40,50,60,70,80,90};
	int size;	    
	int[] b;
		if(a.length%2!=0) //9%2!=0t
		{	
		size=a.length/2+1;//5
		 b=new int[size];
		}
	else
		{
		size=a.length/2; //10/2
		 b=new int[size];
		}
	int j=0;	
	for(int i=0;i<a.length;i++)
		{
		if(i%2==0)
			{
			b[j++]=a[i];//b[0]=10,b[1]=30,b[2]=40
			}
		}
	System.out.print("b[] Array elements are ");
      	for(int i=0;i<b.length;i++)
		{
		System.out.print(b[i]+" ");
		}
	System.out.println();
	int c[]=new int[a.length-j];//9-5=4
	int k=0;
	for(int i=0;i<a.length;i++)
		{
			if(i%2!=0){
			c[k++]=a[i];}
		}
	System.out.print("c[] Array elements are ");
      	for(int i=0;i<c.length;i++)
		{
		System.out.print(c[i]+" ");
		}
	System.out.println();

	}
}