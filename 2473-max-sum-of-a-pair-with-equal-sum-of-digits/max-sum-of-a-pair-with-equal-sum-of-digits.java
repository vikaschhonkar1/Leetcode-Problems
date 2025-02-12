class Solution {
    public int maximumSum(int[] nums) {
        int freq[] = new int[90];

        for (int i = 0; i < 90; i++) {
            freq[i] = -1;
        }

        int ans = -1;

        for (int i = 0; i < nums.length; i++) {
            int currentSum = 0;
            int temp = nums[i];

            while (temp > 0) {
                currentSum += temp % 10;
                temp /= 10;
            }

            if (freq[currentSum] != -1) {
                ans = Math.max(ans, nums[i] + freq[currentSum]);
            }

            freq[currentSum] = Math.max(freq[currentSum], nums[i]);
        }
        return ans;
    }
}