class minElement
{
    public static void main(String[] args) 
    {
        int min=Integer.MAX_VALUE;
        int[] arr = {1,8,2,4,5,9,-9,8};
        for(int x=0;x<arr.length;x++)
        {
            if(arr[x]<min)
            {
                min=arr[x];
            }
        }    
        System.out.println("The minimum element in the array is: "+min);
    }
}