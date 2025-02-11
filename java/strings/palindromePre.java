//"a man & a plan, a canal & panama 1".
//in above string output as 
//amanaplanacanalpanama.
//check above is plaindrome or not?.

class palindromePre
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
	StringBuffer sb=new StringBuffer(s2);
	sb.reverse();
	//or String rev=""; we can use rev=sb.toString(); for this in if we s2.equals(rev)
	System.out.println(sb);
	if(s2.contentEquals(sb)) 
	//contentEquals for comparing two differnet types of data having same or not the data in it?
	//sb is different from s2 string class
	System.out.println("Its a palindrome");
	else
	System.out.println("Its not a palindrome");
	}

}