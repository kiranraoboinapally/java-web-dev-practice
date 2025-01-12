class storingABc 
{
    public static void main(String[] args) 
    {
        int a[]={1,2,3,4,5}
        int b[]={6,7,8,9}
        int c[]=new int[a.length+b.length]; 
        for(int x=0;x<a.length;x++)
        {
            c[x]=a[x];
        }
        for(int x=0;x<b.length;x++)
        {
            c[a.length+x]=b[x]; 
        } 
        for(int x=0;x<c.length;x++)
        {
            System.out.println(c[x]);
        }
    }
}
