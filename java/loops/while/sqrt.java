class squareRoot
{   
    public static void main(String[] args)
    {
        int start=1,end=10;
        while(start<=end)
        {
        double sqrt=(int)Math.sqrt(start);   //if i keep int then it returns .0 to every number
        System.out.println(start+"'s Square Root Value is "+sqrt);
        start++;
        }
    }
}
