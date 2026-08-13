class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int tempSum = 0;
            for (int j = i; j < n; j++) {
                tempSum += nums[j];

                if (tempSum == k) {
                    count++;
                    // break;
                }
            }
        }

        return count;
    }
}