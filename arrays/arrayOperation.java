class arrayOperation 
{
    public static void main(String[] args)
    {
        int sum=0;
        int a[]=new int[]{10,20,30,40,50};
        int b[]=new int[a.length];
        for(int i=0; i<a.length; i++)
        {
            sum+=a[i];
        }
        for(int i=0; i<a.length; i++)
        {
            b[i]=(sum-a[i])/a[i];
        }
        for(int i=0; i<a.length; i++)
        {
            System.out.print(b[i]+" ");
        }
    }
}
