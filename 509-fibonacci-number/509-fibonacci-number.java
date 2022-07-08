class Solution {
    public int fibFunction(int n, int dp[]){
        if(n==0) return dp[0] = 0;
        if(n==1) return dp[1] = 1;
        
        if(dp[n]!=0) return dp[n];
        
        return dp[n] = fibFunction(n-1, dp) + fibFunction(n-2, dp);
    }
    public int fib(int n) {
        int dp[] = new int[n+1];
        return fibFunction(n, dp);
    }
}