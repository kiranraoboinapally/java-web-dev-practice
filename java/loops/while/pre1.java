class pre1
{
    public static void main(String args[])
    {
        int a=5;
        int b=a++ + --a + ++a; //5+5+6 16=>17
        int c=b++ + a + a--;   //16+6+6 28
        System.out.println("a value is "+a+" b value is "+b+" c value is "+c);
    }
}