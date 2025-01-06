class persq 
{
    public static void main(String[] args)
    {   
        int start = 1, end = 100;
        
        while (start <= end)
        {
            int sq = start * start;
            if (sq <= end)  // Only print if the perfect square is within the given range
            {
                System.out.println(sq + " is a perfect square of " + start);
            }
            start++;
        }
    }    
}

