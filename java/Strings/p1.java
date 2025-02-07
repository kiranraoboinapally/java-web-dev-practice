//p1
//write java program to find length of a string?

class p1
{
public static void main(String args[])
	{
	int count=0;
	String s="Hello everyone";
	System.out.println(s.length());
	
	char c[]=s.toCharArray();//converitng a string toCharArray
	for(char t:c)
		{
		count++;
		System.out.print(t);
		}
	System.out.println();
	System.out.println("length by using for-each loop with count: "+count);
	for(String k:s)
		{
		System.out.print(k);
		}
	}
}