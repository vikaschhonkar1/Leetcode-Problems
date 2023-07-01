class Solution {
    int ans = Integer.MAX_VALUE;

    private void solve(int idx, int[] cookies, int k, int[] dp) {
        // pruning
        if (idx > cookies.length) {
            return;
        }
            
        // base case
        if (idx == cookies.length) {
            // find maximum in dp array
            int max = Integer.MIN_VALUE;

            for (int i = 0; i < k; i++) {
                max = Math.max(max, dp[i]);
            }

            // since we have to minimise the maximum
           
            ans = Math.min(max, ans);
          
            return;
        }

        // checking and looping all possibilities
        for (int i = 0; i < k; i++) {
            // choosing 
            dp[i] += cookies[idx];
            // moving
            solve(idx + 1, cookies, k, dp);
            // revert
            dp[i] -= cookies[idx];
        }

    }

    public int distributeCookies(int[] cookies, int k) {
        // we will use simple dp as constraints are very low
        int dp[] = new int[k];
        
        solve(0, cookies, k, dp);
        return ans;
    }
}