class fizzBuzz{
    public static void main(String[] args)
    {
        int num=15;
        if(num%3==0 && num%5==0)        //1st priority
        System.out.println("Fizz and Buzz");
        else if(num%3==0)
        System.out.println("Fizz");
        else 
        System.out.println("Buzz");
    }
}