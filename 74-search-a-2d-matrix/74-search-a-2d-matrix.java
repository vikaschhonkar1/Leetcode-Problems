class Solution {
    public boolean searchMatrix(int[][] nums, int target) {
        int n = nums.length;
        int m = nums[0].length;
        int low = 0;
        int high = m*n - 1;
        while (low<high){
            int mid = (low + high - 1) >> 1;
            if (nums[mid / m][mid % m] < target)
                low = mid + 1;
            else 
                high = mid;
        }
        return nums[high/m][high%m] == target;
    }
}