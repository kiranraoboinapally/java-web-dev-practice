class cnfe 
{
    public static void main(String[] args) 
    {
        try 
        {
            Class.forName("java.util.scanner");

        } 
        catch (ClassNotFoundException e) 
        {
            System.out.println("Class not found"+e);
        }
    
    }
}
//if java.util.scanner is not found then it will print "Class not found" i.e catch block will execute
