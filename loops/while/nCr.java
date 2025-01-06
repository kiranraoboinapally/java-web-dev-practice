class nCr 
{
    public static void main(String[] args)
    {
        int n=5,r=2,n_fact=1,r_fact=1,start=n,diff=n-r;
        int diff_fact=1;
        while(start>0)
        {
            n_fact*=start;
            start--;
        }
        System.out.println(n_fact);
        start=r;
        while(start>0)
        {
            r_fact*=start;
            start--;
        }
        System.out.println(r_fact);
        start=diff;
        while(start>0)
        {
            diff_fact*=start;
            start--;
        }
        System.out.println(diff_fact);

        // Calculate nCr
        int nCr = n_fact / (r_fact * diff_fact);
        System.out.println("nCr = " + nCr);
    }    
}
