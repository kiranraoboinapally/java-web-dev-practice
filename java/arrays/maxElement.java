class maxElement 
{
    public static void main(String[] args) 
    {
        int max=Integer.MIN_VALUE;
        int[] arr = {1,8,2,4,5,9,-9,8};
        for(int x=0;x<arr.length;x++)
        {
            if(arr[x]>max)
            {
                max=arr[x];
            }
        }    
        System.out.println("The maximum element in the array is: "+max);    
    }    
}
