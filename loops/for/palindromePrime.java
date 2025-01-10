class palindromePrime 
{
    public static void main(String[] args)
    {
      int palindromePrime = 11,rev=0,temp=palindromePrime;
      for(;palindromePrime!=0;palindromePrime/=10)
      {
        int rem=palindromePrime%10;
        rev=rev*10+rem;
      }  
      palindromePrime = temp;
      int factor=1;
      boolean isPrime=false;
      for(;factor<=palindromePrime/2;factor++)
      {
        if(palindromePrime%factor==0)
        isPrime=true;
        break;
      }
      if(isPrime && temp==rev && palindromePrime>=2)
      {
        System.out.println("Its a palindrome prime");
      }
      else
      System.out.println("Its not a palindrome prime");
    }    
}
