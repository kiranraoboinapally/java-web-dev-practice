class mergeSorted {
    public static void main(String args[]) 
    {
        Solution sol=new Solution();
        sol.merge(new int[]{1,2,3,0,0,0},3,new int[]{2,5,6},3); //1,2,2,3,5,6
        sol.merge(new int[]{1},1,new int[]{},0); //1
        sol.merge(new int[]{0},0,new int[]{1},1); //1
    }
}

class Solution {
    public void merge(int[] nums1,int m,int[] nums2,int n)
	{
        int i=m-1;//Last element of nums1's actual data
        int j=n-1;//Last element of nums2
        int k=m+n-1;//Last position in nums1's total size
	// Merge nums1 and nums2 starting from the end
        while(i>=0 && j>=0)
		{
            	if(nums1[i]>nums2[j])
			{
                	nums1[k]=nums1[i];
                	i--;
			}
		else
			{
                	nums1[k] = nums2[j];
			j--;
			}
		k--;
		}

        // If any elements left in nums2, move them to nums1
        while(j>=0) 
		{
            	nums1[k] = nums2[j];
            	j--;
            	k--;
        	}
        // No need to handle nums1 elements, as they are already in place
        for (int x = 0; x < nums1.length; x++) 
	{
            System.out.print(nums1[x] + " ");
        }
	System.out.println();
    }
}
