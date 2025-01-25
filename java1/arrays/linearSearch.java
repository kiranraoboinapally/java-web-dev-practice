class linearSearch 
{
    public static void main(String[] args) 
    {
        int searchElement = 30;
        int[] arr = {10, 20, 30, 40, 50};
        int count = 0;
        for(int i = 0; i < arr.length; i++)
        {
            if(arr[i] == searchElement)
            {
                System.out.println("Element found at index: " + i);
                count++;
                break;
            }
        }
    if(count == 0)
        {
    System.out.println("Element not found");
        }    
    }    
}
