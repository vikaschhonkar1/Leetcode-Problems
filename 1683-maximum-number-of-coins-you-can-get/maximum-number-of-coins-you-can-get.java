class Solution {
    public int maxCoins(int[] piles) {
        int ans = 0;
        Arrays.sort(piles);
        int n = piles.length;
        for(int i = n / 3; i < n; i+=2) {
            ans += piles[i];
        }
        return ans;
    }
}

// {1,2,3,4,5,6,7,8,9}

// {9,8,1} = 8
// {7,6,2} = 6
// {5,4,3} = 4
//         = 18