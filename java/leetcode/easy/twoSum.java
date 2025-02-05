
class Solution {
    public int[] twoSum(int[] nums, int target) {
        for(int x=0;x<nums.length;x++)
        {
            for(int y=x+1;y<nums.length;y++)
            {
                if(nums[x]+nums[y]==target)
                {
                return new int[] {x, y};
                }
            }
        }return new int[] {}; 
    }
}


/*

class Solution {
    public static void main(String[] args) {
        int[] a = {1, 2, -3, 2, 7, 1, -2, 5, 0, 1, 9, 4};
        int K = 5;
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] + a[j] == K) {
                    System.out.println(a[i] + "," + a[j]);
                }
            }
        }
    }
}
*/