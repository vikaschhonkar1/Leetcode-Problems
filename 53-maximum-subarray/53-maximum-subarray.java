class Solution {
    public int maxSubArray(int[] nums) {
        int globalMaxSum = nums[0], currMaxSum = nums[0];
        for (int ind = 1; ind < nums.length; ind++) {
            currMaxSum = Math.max(currMaxSum + nums[ind], nums[ind]);
            globalMaxSum = Math.max(globalMaxSum, currMaxSum);
        }
        return globalMaxSum;
    }
}