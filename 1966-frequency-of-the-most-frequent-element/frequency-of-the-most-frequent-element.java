class Solution {
    public int maxFrequency(int[] nums, long k) {
        int i = 0;
        int j;

        Arrays.sort(nums);

        for (j = 0; j < nums.length; ++j) {
            k += nums[j];
            if (k < (long)nums[j] * (j - i + 1))
                k -= nums[i++];
        }
        return j - i;
    }
}