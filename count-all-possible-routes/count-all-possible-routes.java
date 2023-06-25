class Solution {
    private static final int MOD = 1000000007;

    public int solve(int[] locations, int city, int finish, int remainFuel, Integer[][] dp) {
        if (remainFuel < 0) return 0;
        if (dp[city][remainFuel] != null) return dp[city][remainFuel];
        
        int total;
        if(city == finish) total = 1;
        else total = 0;
        
        for (int i=0; i<locations.length; i++) {
            if (i!=city && remainFuel>=Math.abs(locations[i]-locations[city])) {
                total += solve(locations, i, finish, remainFuel-Math.abs(locations[i]-locations[city]), dp);
                total %= MOD;
            }
        }
        
        return dp[city][remainFuel] = total;
    }
    public int countRoutes(int[] locations, int start, int finish, int fuel) {
        int n = locations.length;
        Integer dp[][] = new Integer[n][fuel+1];
        return solve(locations, start, finish, fuel, dp);
    }
}