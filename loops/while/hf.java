class hf 
{
    public static void main(String[] args)
    {
        int factorsOfNum=18,factors=1,highestFactor=0;
        while(factors<factorsOfNum)
        {
            if(factorsOfNum%factors==0)
            {
                //System.out.println(factors);
                highestFactor=factors;
            }
        factors++;
        }
        System.out.println(highestFactor);
    }
}
