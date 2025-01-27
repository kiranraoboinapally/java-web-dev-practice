import java.util.Scanner;
class bubbleSort
{
public static void main(String args[])
	{
	Scanner sc=new Scanner(System.in);
	System.out.println("ENTER AN ARRAY SIZE");
	int size=sc.nextInt();
	int b[]=new int[size];
	System.out.println("ENTER AN ARRAY ELEMENTS");
	for(int x=0;x<size;x++)
	{
	b[x]=sc.nextInt();
	}
	bubbleSort bs=new bubbleSort();
	for(int k:b)
	System.out.println(k);
	//int b[]=new int[]{10,15,2,13,5,12,17};
	bs.bubbleSort(b);
	}
void bubbleSort(int a[])
	{
	for(int x=0;x<a.length;x++)
		{
		for(int y=0;y<a.length-1-x;y++)//condition -x to decrease no.of iterations half of it
			{		      //i.e.actually 7 length has 42 iterations it decre to 21
			if(a[y]>a[y+1])	      
				{
				int temp=a[y];
				a[y]=a[y+1];
				a[y+1]=temp;
				}
			}
		}
	System.out.println("After Sorting: ");
	for(int t:a)
	System.out.print(t+" ");
	}
}