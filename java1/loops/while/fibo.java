class fibonacci
{
    public static void main(String[] args)
    {   int start=1,n=13,a=0,b=1,c=0;
        while(start<n)
            {
            c=a+b;
            System.out.print(a+" ");
            a=b;
            b=c;
            start++;    
            }
    }
} 