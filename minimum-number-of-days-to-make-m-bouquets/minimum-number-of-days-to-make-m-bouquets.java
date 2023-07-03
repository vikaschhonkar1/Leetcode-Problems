class Solution {
    private int check(int days, int[] bloomDay, int k, int m) {
        int n = bloomDay.length;

        int currentBouquets = 0;
        int flowersTaken = 0;

        for (int i = 0; i < n; i++) {
            if(bloomDay[i] > days) {
                flowersTaken = 0;
            } else {
                flowersTaken++;
            }

            if(flowersTaken == k) {
                flowersTaken = 0;
                currentBouquets++;
            }
        }

        if(currentBouquets < m) {
            return 0;
        } else {
            return 1;
        }
    }

    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;

        int lo = bloomDay[0];
        int hi = bloomDay[0];

        for(int i = 1; i < n; i++) {
            lo = Math.min(lo, bloomDay[i]);
            hi = Math.max(hi, bloomDay[i]);
        }

        int ans = -1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (check(mid, bloomDay, k, m) == 1) {
                hi = mid - 1;
                ans = mid;
            } else {
                lo = mid + 1;
            }
        }

        return ans;
    }
}