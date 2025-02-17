

class evenOddSort 
{
    public static void main(String[] args)
    {
       int a[] = {10,21,4,15,6};
       for(int x=0;x<a.length;x++)
       {
        if(a[x]%2==0)
        {
            System.out.print(a[x]+" ");
        }
       }
       for(int x=0;x<a.length;x++)
       {
        if(a[x]%2!=0)
        {
            System.out.print(a[x]+" ");
        }
       }
    }    
}
