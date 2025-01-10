class secondMin 
{
    public static void main(String[] args) 
    {
    int digits=9256374,min=Integer.MAX_VALUE,secondMin=Integer.MAX_VALUE,temp=digits;
    for(;digits!=0;digits/=10)
    {
        int rem=digits%10;
        if(min>rem)
        {
            secondMin=min;
            min=rem;
        }
        else if(secondMin>rem && rem!=min)
        {
            secondMin=rem;
        }
    } 
    System.out.println("Min digit "+temp+" is "+min);
    System.out.println("Second Min digit "+temp+" is "+secondMin);  
    }    
}
