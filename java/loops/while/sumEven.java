class sumEven
{
    public static void main(String[] args)
    {
        int start=1,end=100,sumEven=0;
        while(start<=end)
        {
            if(start%2==0)
            {
            sumEven+=start;
            }
        start++;
        }
        System.out.println(sumEven+" is the sum of first "+end+" Natural Numbers");
    }    
}
