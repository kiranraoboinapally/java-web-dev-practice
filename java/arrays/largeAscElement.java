class largeAscElement 
{
public static void main(String[] args) 
    {
        int[] arr = new int[]{5, 2, 8,7,8,8,7, 1};
        int temp = 0;
        for (int i = 0; i < arr.length; i++) 
        {
            for (int j = i + 1; j < arr.length; j++) 
            {
                if (arr[i] > arr[j]) 
                {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        System.out.println("Elements of array sorted in ascending order: ");
        for (int i = 0; i < arr.length; i++) 
        {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
        System.out.println("The largest element of the array is: "+arr[arr.length-1]);
        for (int i = arr.length-2; i >= 0; i--)
        {
            if( arr[i]!=arr[arr.length-1])
            {
                System.out.println("The second largest element of the array is: "+arr[i]);
                break;
            }
        } 
    }    
}

