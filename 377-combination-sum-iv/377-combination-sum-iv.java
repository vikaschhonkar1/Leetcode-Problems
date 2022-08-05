class Solution {
    public int combinationSum4(int[] nums, final int Target) {
        if (nums == null || nums.length == 0)   return 0;

        int dp[] = new int[Target + 1];
        dp[0] = 1;

        for (int target = 1; target <= Target; target++) {
            for (int j = 0; j < nums.length; j++) {
                if (target >= nums[j])
                    dp[target] += dp[target - nums[j]];
            }
        }
        return dp[Target];
    }
}