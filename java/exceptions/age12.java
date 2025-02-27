import java.util.Scanner;
class age12
{
    public static void main(String args[])
	{
	Scanner sc=new Scanner(System.in);
        int age=sc.nextInt();
        if(age >= 60)
	{
	throw new ArithmeticException("ae1");
	}
        else
	{
	System.out.println("throw"); 
	}
    }
}