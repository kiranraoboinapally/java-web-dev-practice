class arrayTransformation 
{
    public static void main(String[] args)
    {
        int a[]=new int[]{10,20,30,40,50};
        int b[]=new int[a.length];
        for(int i=0; i<a.length; i++)
        {
            if(i==0)
            b[i]=a[i]+a[i+1];
            else if(i==a.length-1)
            b[i]=a[i]+a[i-1];
            else
            b[i]=a[i-1]+a[i+1]; 
        }
        for(int i=0; i<a.length; i++)
        {
            System.out.print(b[i]+" ");
        }
    }    
}
