class Solution {
    public int nthUglyNumber(int n) {
        int dp[] = new int[n+1];
        dp[1] = 1;
        
        int p2 = 1; 
        int p3 = 1; 
        int p5 = 1;
        
        for(int i=2; i<=n; i++){
            int f2 = 2 * dp[p2];
            int f3 = 3 * dp[p3];
            int f5 = 5 * dp[p5];
            
            int min = Math.min(f2, Math.min(f3, f5));
            
            if(f2 == min) p2++;
            if(f3 == min) p3++;
            if(f5 == min) p5++;
            
            dp[i] = min;
        }
        
        return dp[n];
    }
}