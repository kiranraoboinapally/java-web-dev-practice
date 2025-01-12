class pre1
{
    public static void main(String args[])
    {
        int a=5;
        int b=a++ + --a + ++a;
        int c=b++ + a + a--;
        System.out.println("a value is "+a+" b value is "+b+" c value is "+c);
    }
}