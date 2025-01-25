import java.util.Arrays;
class missingElements 
{
public static void main(String[] args) 
	{
        int[] a=new int[]{1,5,9,0}; 
        Arrays.sort(a);
        System.out.println("Sorted Array:");
        for(int temp:a) 
		{
            	System.out.print(temp + " ");//0 1 5 9
       		}			     //f     l
        System.out.println();
        int f=a[0];
        int l=a[a.length-1];
        System.out.println("Missing elements:");
        for(int i=f;i<l;i++) 
		{
            		boolean found=false;
            		for(int j=0;j<a.length;j++) 
				{
                		if(a[j]==i)
					{
                    			found = true;
                    			break;
                			}
				}
            		if(!found)
			{
                	System.out.print(i + " ");
            		}
        	}
    	}
}
