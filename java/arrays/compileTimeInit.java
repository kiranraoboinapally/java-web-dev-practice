class compileTimeInit
{
    public static void main(String[] args)
    {
        int[] arr = new int[5]; // or int[] arr = new int[]{10, 20, 30, 40, 50};
        arr[0] = 10;            //dont mention size of array in compile time in  above commented part
        arr[1] = 20;            //or int arr[]={10,20,30,40,50}; or int[] arr={10,20,30,40,50};
        arr[2] = 30;
        arr[3] = 40;
        arr[4] = 50;

        for(int i = 0; i < arr.length; i++) //arr.length is used to get the size of array as 5
        {
            System.out.println(arr[i]);
        }
    }
}