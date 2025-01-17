class firstTen
{
    public static void main(String[] args) 
    {
        int n = 10;
        int count = 0;
        int num = 2;
        System.out.print("First " + n + " prime numbers: ");
        do
        {
            boolean isPrime = true;
            for (int i = 2; i <= num / 2; i++)
            {
                if (num % i == 0)
                {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime)
            {
                System.out.print(num + " ");
                count++;
            }
            num++;
        } while (count < n);
    }    
}
