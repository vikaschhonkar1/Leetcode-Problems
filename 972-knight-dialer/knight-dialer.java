class Solution {
    public static final int MOD = 1_000_000_007;

    public int knightDialer(int n) {
        if(n == 1) {
            return 10;
        }

        int[][] dx = {{4, 6}, {6, 8}, {7, 9}, {4, 8}, {3, 9, 0}, {}, {1, 7, 0}, {2, 6}, {1, 3}, {2, 4}};
        int[] dp = new int[10];
        Arrays.fill(dp, 1);

        for(int val = n; val > 1; val--){
            int[] temp = new int[10];
            for(int i = 0; i < dx.length; i++){
                for(int j = 0; j < dx[i].length; j++){
                    int curr = dx[i][j];
                    temp[curr] = (temp[curr] % MOD + dp[i] % MOD) % MOD;
                }
            }
            dp = temp;
        }

        int ans = 0;

        for(int i = 0; i < dp.length; i++) {
            ans = (ans % MOD + dp[i] % MOD) % MOD;
        }
        return ans;
    }
}