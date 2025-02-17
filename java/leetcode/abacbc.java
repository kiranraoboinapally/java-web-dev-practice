class abacbc 
{
public static void main(String[] args) 
	{
        String s = "abaXbcc"; 
        boolean result=false;
        for (int x=0;x<s.length();x++) 
		{
            	char c=s.charAt(x);
		if(s.indexOf(c)!=s.lastIndexOf(c)) 
			{
                	result=true;
			break;
			}
		}
	System.out.println(result);
    	}
}
