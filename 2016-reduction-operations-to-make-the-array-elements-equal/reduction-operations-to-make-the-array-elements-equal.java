class Solution {
    public int reductionOperations(int[] nums) {
        int ans = 0;
        int n = nums.length;

        Arrays.sort(nums);

        for (int j = n - 1; j > 0; j--)
            if (nums[j - 1] != nums[j])
                ans += n - j;
        return ans;
    }
}