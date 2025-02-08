//compile time init String

import java.util.Scanner;

class a2
{
public static void main(String args[]) 
	{
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number of strings: ");
        int size=sc.nextInt();
	sc.nextLine();
        String[] s=new String[size];
        for (int x=0;x<s.length;x++) 
		{
            	System.out.println("Enter a string: ");
           	s[x]=sc.nextLine(); 
        	}
        System.out.println("String Array is: ");
        for(String t:s)
        System.out.print(t+" ");
    	}
}
