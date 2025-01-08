class reverseNumWithZero 
{
    public static void main(String[] args)
    {
        int reverseNum=12300,rev=0,rev2=0,count1=0,count2=0,diff=0;
        for(;reverseNum!=0;reverseNum/=10)
        {
            int rem=reverseNum%10;
            rev=rev*10+rem;
            count1++;
        }
        reverseNum=rev;
        for(;reverseNum!=0;reverseNum/=10)
        {
            int rem=reverseNum%10;
            rev2=rev2*10+rem;
            count2++;
        }
    diff=count1-count2;
    int powe=(int)Math.pow(10,diff);
    int original=rev2*powe;
    System.out.println(original);
    }    
}
