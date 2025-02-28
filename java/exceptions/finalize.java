class finalize 
{
public static void main(String  args[])
    {
        finalize f = new finalize();
        f = null;
        System.gc();
    }
    protected void finalize()
    {
        System.out.println("finalize method called");
    }
}

//finalize method is from Object class. It is called by garbage collector when object is no longer in use. when its triggered, it will print "finalize method called" to the console.
//finalize method is called by garbage collector before destroying the object.