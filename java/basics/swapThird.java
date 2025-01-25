/*Swapping two numbers using third variable*/
class swapThird
{
    public static void main(String args[])
    {
        int a= 10,b=20,c=0;      //initailiation of two variables and //c variable taken as zero
        System.out.println("Before Swapping a and b using third variable values are "+a+" and "+b);
        c=a;                     //a value stored in c
        a=b;                    //b value stored in a 
        b=c;                    //c value stored in b
        System.out.println("After Swapping a and b using third variable values are "+a+" and "+b);
    }
}