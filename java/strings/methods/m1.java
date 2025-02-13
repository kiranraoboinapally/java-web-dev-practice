
class m1
{
public static void main(String args[])
	{
	String s="Hello all";
	String s1=new String("Hello"); 
	System.out.println(s.length());
	System.out.println(s);
	for(int x=0;x<s.length();x++)
		{
		char c=s.charAt(x);
		System.out.print(c+" ");
		}
	System.out.println();
	char c[]=s.toCharArray();
	System.out.println(c.length);
	String k=" good";
	k+=" morning";
	System.out.println(s.concat(k));
	String num1="123";
	int num2=(Integer.parseInt(num1))+10;
	System.out.println(num2);
	String num3=Integer.toString(num2);
	System.out.println(num3+" 10");
	StringBuffer sb=new StringBuffer();
	Boolean b=true;
	String b1=Boolean.toString(!b);
	System.out.println(b1);
	}
}