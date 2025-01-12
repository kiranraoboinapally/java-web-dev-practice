class removeDuplicates 
{
    public static void main(String args[]) 
    {
        int a[]=new int[]{0,1,1,1,2,3,3,4};
        int index=0;
        for (int i=0;i<a.length;i++) 
        {
            boolean isDuplicate=false;
            for (int j=0;j<index;j++) 
            {
                if (a[i]==a[j]) 
                {
                    isDuplicate=true;
                    break;
                }
            }
            if (!isDuplicate) 
            {
                a[index++]=a[i];
            }
        }
        System.out.print("Array after removing duplicates: ");
        for (int i=0;i<index;i++) 
        {
            System.out.print(a[i] + " ");
        }
        System.out.println("\nNo.of Elements after removing duplicates are : "+index);
    }
}
