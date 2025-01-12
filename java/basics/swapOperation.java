class swapOperation 
{
    public static void main(String[] args) 
    {
        int a= 10,b=20;      //initailiation of two variables
        System.out.println("Before Swapping a and b values are "+a+" and "+b);
        a=a+b;               //a value is added to b and stored in a
        b=a-b;               //a value is subtracted from b and stored in b
        a=a-b;               //b value is subtracted from a and stored in a
        System.out.println("After Swapping a and b values are "+a+" and "+b);
    }    
}
