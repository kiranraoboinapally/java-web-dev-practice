class factors 
{
public static void main(String[] args)
    {
        int num=12,start=1;
        while(start<=num)
            {
                if(num%start==0)
                {
                    System.out.println("Factors of "+num+" are "+start);
                }
                start++;
            }
    }
}
