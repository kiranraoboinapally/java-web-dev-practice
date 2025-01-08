class palindrome 
{
    public static void main(String[] args)
    {
        int originalInteger=121, reversedInteger=0, remainder,temp=originalInteger;
        for(;originalInteger!=0;originalInteger/=10)
        {
            remainder=originalInteger%10;
            reversedInteger=reversedInteger*10+remainder;
        }
        if (temp==reversedInteger)
            System.out.println(temp + " is a palindrome.");
        else
            System.out.println(temp + " is not a palindrome.");
    }
}
