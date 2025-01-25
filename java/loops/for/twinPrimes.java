class twinPrimes 
{
   public static void main(String[] args)
  {
    int a = 11, b = 13;
    if (a - b == 2 || b - a == 2)
    { 
      boolean isPrime = true;
      for (int start = 2; start <= a / 2; start++) 
      {
        if (a % start == 0) 
        {
          isPrime = false;
          break;
        }
      }
      if (isPrime && a >= 2)
      {
        for (int start = 2; start <= b / 2; start++) 
        {
          if (b % start == 0) 
          {
            isPrime = false;
            break;
          }
        }
        if (isPrime && b >= 2) 
        {
          System.out.println("Twin Primes");
        }
        else
        {
          System.out.println("Not Twin Primes");
        }
      }
      else
      {
        System.out.println("Not Twin Primes");
      }
    }
    else
    {
      System.out.println("Not Twin Primes");
    }
  }
}

