package easy;
class searchInsert 
{
    public static void main(String[] args)
    {
        int nums[] = {2,3,5,6};
        int target = 7;
        int index = 0;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]==target)
            {
                index = i;
                break;
            }
            else if(nums[i]>target)
            {
                index = i;
                break;
            }
            else
            {
                index = i+1;
            }
        }
        System.out.println(index);
    }    
}






















class Solution {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        
        // Binary search approach
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] == target) {
                return mid;  // Target found, return the index
            }
            else if (nums[mid] < target) {
                left = mid + 1;  // Target is in the right half
            }
            else {
                right = mid - 1;  // Target is in the left half
            }
        }
        
        // If not found, left will be the insertion point
        return left;
    }
}

