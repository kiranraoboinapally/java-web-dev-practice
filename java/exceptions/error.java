class error
{
public static void main(String[] args) 
	{
        // Trying to allocate an enormous array that exceeds memory limits
        // This will cause an OutOfMemoryError
        int[] largeArray = new int[Integer.MAX_VALUE];  // This will likely throw an error
        System.out.println("Array allocated successfully!");
    	}
}
//out  of memory error