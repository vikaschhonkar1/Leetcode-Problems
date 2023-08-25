class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length();
        int n = s2.length();
        int t = s3.length();
        
        if (m + n != t) {
            return false;
        }
        
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        char[] c3 = s3.toCharArray();
        
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[m][n] = true; // Base case: Empty strings match
            
        for (int i = m; i >= 0; i--) {
            for (int j = n; j >= 0; j--) {
                if (i < m && c1[i] == c3[i + j] && dp[i + 1][j]) {
                    dp[i][j] = true;
                }
                if (j < n && c2[j] == c3[i + j] && dp[i][j + 1]) {
                    dp[i][j] = true;
                }
            }
        }
        
        return dp[0][0];
    }
}
