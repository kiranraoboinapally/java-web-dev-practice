class evenSum 
{
   public static void main(String[] args)
   {
    int num=8765876,count=0,temp=num,sum=0,prod=1;
    for(;num!=0;num/=10)
    {
        int rem=num%10;
        if(rem%2==0)
        {
            sum+=rem;
        }
        else
        {
            prod*=rem;
        }
    }
    System.out.println("Sum of even digits is: " + sum);
    System.out.println("Product of odd digits is: " + prod);
   } 
}
