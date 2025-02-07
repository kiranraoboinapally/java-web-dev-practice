//input taken as a1b2c3
//output as abbccc

class p87
{
public static void main(String args[])
	{
	String s="a1b2c3";
	String n="";//123
	String k="";//abc
	for(int x=0;x<s.length();x++)
		{
		char c=s.charAt(x);
		if(Character.isDigit(c))
			n=n+c;
		else if(Character.isAlphabetic(c))
			k=k+c; 
		}
	for(int x=0,y=0;x<n.length();x++,y++)
		{
		char c1=n.charAt(x);
		char c2=k.charAt(y);
		}
	}
}