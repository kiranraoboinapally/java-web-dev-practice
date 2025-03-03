//compile time init char

import java.util.Scanner;
class a1
{
public static void main(String args[])
	{
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter an array size: ");
	int size=sc.nextInt();
	char c[]=new char[size];
	for(int x=0;x<c.length;x++)
		{
		System.out.println("Enter a character: ");
		c[x]=sc.next().charAt(0);
		}
	System.out.println("Character Array is: ");
	for(char t:c)
	System.out.print(t+" ");
	}
}