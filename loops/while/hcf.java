class hcf
{ 
    public static void main(String[] args)
    {
        int num1=12,num2=18; // factors of 12 are 1,2,3,4,6,12 and factors of 18 are 1,2,3,6,9,18;
        int start=1,hcf=0;
        while(start<=num1)  //num1 is less than num2 so factors will be only upto num1;
        {
            if(num1%start==0  && num2%start==0)
                {           //if wanted second hcf then shcf=hcf exact here to be written;
                    hcf=start;
                }
            start++;
        }
        System.out.println(hcf);
    }
}