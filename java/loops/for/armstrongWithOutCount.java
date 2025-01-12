class armstrongWithOutCount 
{
    public static void main(String[] args)
    {
        int extractNum=370,sumPowerExtractNum=0,temp=extractNum,powerExtractNum=0;
        for(;extractNum!=0;extractNum/=10)
        {
            int rem=extractNum%10;
            powerExtractNum=(int)Math.pow(rem,3);
            sumPowerExtractNum+=powerExtractNum;
        }
        System.out.println(temp==sumPowerExtractNum?temp+" is an armstrong Number":temp+" is not an Armstrong Number");
    }    
}
