package easy;
class removeElement 
{
    public static void main(String[] args)
    {
        int a[]=new int[]{0,1,2,2,3,0,4,2};
        int max=a[0];
        int index=0;
        for (int i=0;i<a.length;i++) 
        {
            if(max<a[i])
            {
                max=a[i];
            }
        }
        System.out.println("Max element in the array is : "+max);
    }
}