class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int maxSum = 0;
        int minSum = 0;

        int currMax = 0;
        int currMin = 0;

        for (int num: nums) {
            currMax += num;
            currMin += num;

            maxSum = Math.max(maxSum, currMax);
            currMax = Math.max(currMax, 0);

            minSum = Math.min(minSum, currMin);
            currMin = Math.min(currMin, 0);
        }

        return Math.max(maxSum, -minSum);
    }
}