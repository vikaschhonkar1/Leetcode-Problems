class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int curr = 0;
        int maxPrefix = 0;
        int minPrefix = 0;

        for (int num: nums) {
            curr += num;
            maxPrefix = Math.max(maxPrefix, curr);
            minPrefix = Math.min(minPrefix, curr);
        }
        return maxPrefix - minPrefix;
    }
}