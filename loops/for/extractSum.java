class extractSum 
{
    public static void main(String[] args)
    {   
        int extract=1432,rem=0,extractSum=0;
        for(;extract!=0;extract/=10)
        {
            rem=extract%10;
            extractSum+=rem;
            System.out.print(rem+"+");
        }
    System.out.println("="+extractSum);
    }    
}
