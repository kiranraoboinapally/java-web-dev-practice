class primeArray 
{
    public static void main(String args[])
    {
        int[] arr=new int[]{13,10,5,11,2,7,9};
        for(int i=0;i<arr.length;i++)
        {   int num=arr[i];
            boolean b=true;
            for(int start=2;start<=num/2;start++)
            {
                if(num%start==0)
                {
                    b=false;
                    break;
                }
            }
            if(b && num>=2)
            {
                System.out.println(num+" is prime");
            }
        }
    }
}
