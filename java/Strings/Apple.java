//in apple only repeated should not print one vowel should be in it.
//outputs: a ap ple le e
class Apple
{
public static void main(String args[])
	{
	String s="apple";
	Apple ae=new Apple();
	String s2=ae.sub_String(s);
	String a[]=s2.split(" ");
	}
	int vowels(String s)
	{
	int count=0;
	for(int x=0;x<s.length();x++)
		{
		char c=s.charAt(x);
		if(c=='a'||c=='e'||c=='i'||c=='o'||c=='u'||c=='A'||c=='E'||c=='I'||c=='O'||c=='U'){
		count++;}
		}
	return count;
	}
	String sub_String(String s)
	{
	String res="";
	for(int x=0;x<s.length();x++)
		{
		for(int y=x+1;y<s.length()-1;y++)
			{
			String s2=s.substring(x+y);
			res=res+s2+" ";
			}
		}
	res=res.trim();
	return res;
	}
	int duplicates(String s)
	{
	String s2="";
	for(int x=0;x<s.length();x++)
		{
		char c=s.charAt(x);
		if(s.indexOf(c)!=s.lastIndexOf(c))
			{
			if(s2.indexOf(c)==-1)
				{
				s2=s2+c;
				}
			}
		}
	return s2.length();
	}
}