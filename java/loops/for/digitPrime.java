class digitPrime {
    public static void main(String[] args) 
    {
        int digits=987635,factor,digitPrime=0;
        boolean isPrime;
        for (;digits!=0;digits/=10) 
        {
            int rem=digits % 10;
            digitPrime=rem;
            isPrime=true;
            factor=2;
            for(;factor<=digitPrime/2;factor++) 
            {
                if (digitPrime%factor==0) 
                {
                    isPrime=false;
                    break;
                }
            }
            if(isPrime && digitPrime>=2) 
            {
                System.out.println(digitPrime + " is prime");
            }
        }
    }
}

