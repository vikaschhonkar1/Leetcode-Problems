class Solution {
    private static int check (long mid, int x) {
        if(mid * mid > x ) {
            return 1;
        }
        return 0;
    } 

    public int mySqrt(int x) {
        // edge cases
        if(x <= 1) {
            return x;
        } 

        long lo = 1;
        long hi = x;
        long ans = 1;

        while (lo <= hi) {
            long mid = (long)(lo + (hi - lo) / 2);
            if (check(mid, x) == 1) {
                ans = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
            
            System.out.println(lo +" " + hi + " " + mid + " " + ans);
        }

        return (int)ans - 1;
    }
}