//sum from String only one digits to be added
//input as: hello 1 and 2&3 and 34
//output as: 1+2+3+3+4=13 i.e., return 13

class sumOneString
{
public static void main(String args[])
	{
	String s="hello 1 and 2&3 and 34";
	int sum=0;
	for(int x=0;x<s.length();x++)
		{
		char c=s.charAt(x);
		if(Character.isDigit(c))
		sum=sum+Character.getNumericValue(c);
		}
	System.out.println(sum);
	}
}