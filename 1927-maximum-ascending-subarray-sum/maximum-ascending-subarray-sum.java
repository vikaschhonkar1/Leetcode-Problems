class Solution {
    public int maxAscendingSum(int[] nums) {
        int ans = nums[0];
        int tempSum = nums[0];
        int n = nums.length;

        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i - 1]) {
                tempSum += nums[i];
            } else {
                tempSum = nums[i];
            }
            ans = Math.max(tempSum, ans);
        }
        return ans;
    }
}