class prime {
    public static void main(String[] args) 
    {
        int prime = 17, factors = 2;
        boolean isPrime = true;
        while (factors <= prime / 2) 
        {
            if (prime%factors == 0) 
            {
            isPrime = false;
            break;
            }
        factors++; // Increment the factor
        }
    if (isPrime && prime >= 2)
    System.out.println(prime + " is prime");
    else 
    System.out.println(prime + " is not prime");
    }
}
