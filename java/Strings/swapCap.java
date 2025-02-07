//swapCap
//converting input : Hello All Good Morning
// to output as: Morning aLL gOOD Hello

class swapCap
{
public static void main(String args[])
	{
	String s="Hello All Good Morning";
	String s2="",word="";
	String a[]=s.split(" ");
	s2=s2+a[a.length-1]+" ";
	for(int x=1;x<a.length-1;x++)
		{
		word=a[x];
		for(int y=0;y<word.length();y++)
			{
			char c=word.charAt(y);
			if(c>='a'&&c<='z')
			c=(char)(c-32);
			else if(c>='A'&&c<='Z')
			c=(char)(c+32);
			s2=s2+c;
			}
		s2=s2+" ";
		}
	s2=s2+a[0];
	System.out.println(s2);
	}
}