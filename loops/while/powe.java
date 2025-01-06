class powe 
{
    public static void main(String[] args)
    {   int m=2,n=10,powe=1,start=1;
        while(start<=n)
        {
            powe=m*powe;
            start++;
        }
        System.out.println(powe);
    }
}
