class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int ans = 1;

        int increasingLength = 1;
        int decreasingLength = 1;

        int prev = nums[0];

        for (int i : nums) {
            if (i > prev) {
                decreasingLength++;
                increasingLength = 1;
            } else if (i < prev) {
                increasingLength++;
                decreasingLength = 1;
            } else {
                decreasingLength = 1;
                increasingLength = 1;
            }

            ans = Math.max(ans, Math.max(decreasingLength, increasingLength));

            prev = i;
        }
        return ans;
    }
}