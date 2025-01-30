 //in Ma1laya2lam5
//check 125 is palindorme or not?

class p5
{
public static void main(String args[])
	{
	String name="Ma1laya2lam5";
	String s2="";
	for(int x=0;x<name.length();x++)
		{
		char c=name.charAt(x);
			{
			if(c>='0' && c<='9')
				{
				s2=s2+c;
				}
			}
		}
	System.out.println(s2);
	String s3="";
	for(int x=s2.length()-1;x>=0;x--)
		{
		char c=s2.charAt(x);
		s3=s3+c;
		}
	System.out.println(s3.equals(s2)?"Palindrome":"Not a Palindrome");
	}
}