class per
{
    public static void main(String[] args)
    {
        int factorsOfNum=6,factors=1,perfectNumber=0;
        while(factors<factorsOfNum)
        {
            if(factorsOfNum%factors==0)
            {
                perfectNumber+=factors; //1,2,3 are factorsOfNum 6 Not including 6
            }                           //adding result 1+2+3==6 then its a perfect number
        factors++;
        }
    System.out.println(perfectNumber==factorsOfNum?+factorsOfNum+" is a perfect Number":" Not a perfect Number");
    }
}
