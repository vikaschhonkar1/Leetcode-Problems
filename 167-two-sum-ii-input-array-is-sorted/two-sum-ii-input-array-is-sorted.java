class Solution {
    public int[] twoSum(int[] nums, int target) {
        int ans[] = new int[2];
        int n = nums.length;
        int left = 0; 
        int right = n - 1;

        while (left < right) {
            int tempSum = nums[left] + nums[right];
            if (tempSum == target) {
                ans[0] = left + 1;
                ans[1] = right + 1;
                return ans;
            } else if (tempSum > target) {
                right--;
            } else {
                left++;
            }
        }
        return ans;
    }
}