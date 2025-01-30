import java.util.Scanner;
class p1
{
public static void main(String args[])
	{
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter an Array Size: ");
	int size=sc.nextInt();
	int a[]=new int[size];
	System.out.println("Enter an Array Elements: ");
	for(int x=0;x<a.length;x++)
		{
		a[x]=sc.nextInt();
		}
	System.out.println("Array of Elements are Printing");
	for(int k:a)
		{
		System.out.print(k+" ");	
		}
	}
}