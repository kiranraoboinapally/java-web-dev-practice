//"a man & a plan, a canal & panama 1".
//in above string output as 
//amanaplanacanalpanama.
//check above is plaindrome or not?.

class palindrome
{
	public static void main(String args[])
	{
	String s1="a man & a plan, a canal & panama 1";
	String s2="";
	for(int x=0;x<s1.length();x++)
		{
		char c=s1.charAt(x);
		if(c>='a' && c<='z'||c>='A' && c<='Z'){
		s2=s2+c;}
		}
	System.out.println("before reversing: \n"+s2);
	String rev="";
	for(int x=s2.length()-1;x>=0;x--)
		{
		char c=s2.charAt(x);
		rev=rev+c;
		}
	System.out.println("after reversing: \n"+rev);
	if(s2.equalsIgnoreCase(rev))
	System.out.println("Its a palindrome");
	else
	System.out.println("Its not a palindrome");
	}

}