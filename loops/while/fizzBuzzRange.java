class fizzBuzzRange 
{
    public static void main(String[] args)
    {
        int start=1000,end=100;
        while(start>=end)
        {
            if(start%3==0 && start%5==0)
                
                {
                    System.out.println(start+" FizzBuzz");
                }
            start--;
        }
    }    
}
