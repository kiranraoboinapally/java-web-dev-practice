//string to check its a palindrome or not? using equals and IgnoreCase.

class p4
{
public static void main(String args[])
	{
	String name="Malayalam";
	String s2="";
	for(int x=name.length()-1;x>=0;x--)
		{
		char c=name.charAt(x);
		s2=s2+c;
		}
	System.out.println(name);
	System.out.println(s2);
	System.out.println(s2.equals(name)?"Palindrome":"Not a Palindrome");
	System.out.println(s2.equalsIgnoreCase(name)?"Palindrome":"Not a Palindrome");
	}
}