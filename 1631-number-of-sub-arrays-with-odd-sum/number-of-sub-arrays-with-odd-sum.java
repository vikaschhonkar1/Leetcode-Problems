class Solution {
    public int numOfSubarrays(int[] arr) {
        long ans = 0L;
        int tempSum = 0;
        int odd = 0;
        int even = 1;

        for(int num: arr) {
            tempSum += num;

            if ((tempSum & 1) == 1) {
                ans += even;
                odd++;
            } else {
                ans += odd;
                even++;
            }
        }

        return (int)(ans % 1000000007);
    }
}