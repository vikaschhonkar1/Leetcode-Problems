class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int n = nums.length;
        int pre[] = new int[n];
        int suff[] = new int[n];
        int ans[] = new int[n];

        pre[0] = nums[0];
        for(int i = 1; i < n; i++) pre[i] = pre[i - 1] + nums[i];

        suff[n - 1] = nums[n - 1];
        for(int i = n - 2; i >= 0; i--) suff[i] = suff[i + 1] + nums[i];

        for(int i = 0; i < n; i++) {
            if(i == 0) ans[i] =  suff[i + 1] - (n - i - 1) * nums[i];
            else if (i == n - 1) ans [i] = i * nums[i] - pre[i - 1];
            else ans[i] = i * nums[i] - pre[i - 1] + suff[i + 1] - (n - i - 1) * nums[i];
        }

        return ans;
    }
}