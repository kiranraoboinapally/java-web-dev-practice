class factorsCount 
{
    public static void main(String[] args)
    {
        int factorsOfNum=18,factorsCount=0,factors=1;
        while(factors<=factorsOfNum)
        {
            if(factorsOfNum%factors==0)
            {
                factorsCount++;
            }                           
        factors++;
        }
    System.out.println(factorsOfNum+" factors count is "+factorsCount);
    }
}
