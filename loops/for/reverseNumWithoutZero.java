class reverseNumWithoutZero 
{
    public static void main(String[] args)
    {
        int reverseNum=123,rev=0,temp=reverseNum,rev2=0;
        for(;reverseNum!=0;reverseNum/=10)
        {
            int rem=reverseNum%10;
            rev=rev*10+rem;
        }
        reverseNum=rev;
        for(;reverseNum!=0;reverseNum/=10)
        {
            int rem=reverseNum%10;
            rev2=rev2*10+rem;
        }
    System.out.println(rev2);
    }    
}
