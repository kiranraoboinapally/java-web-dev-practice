class nullPointer 
{
    int x=10;
public static void main(String args[])
    {      
    nullPointer obj=new nullPointer();
    System.out.println(obj.x);
    obj=null;
    System.out.println(obj.x);
    }
}
