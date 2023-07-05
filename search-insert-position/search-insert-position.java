class Solution {
    private int check(int mid, int[] arr, int target) {
        if(arr[mid] >= target) {
            return 1;
        }
        return 0;
    }
    public int searchInsert(int[] nums, int target) {
        int n = nums.length;

        int lo = 0;
        int hi = n - 1;
        int ans = n;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if(check(mid, nums, target) == 1) {
                ans = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        return ans;
    }
}