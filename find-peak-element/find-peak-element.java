class Solution {
    public int ans(int arr[], int l, int r){
        int mid = l - (l-r)/2;
        if((mid==0 || arr[mid-1]<=arr[mid]) && (mid == arr.length-1 || arr[mid+1]<=arr[mid])){
            return mid;
        }
        else if(mid-1>=0 &&  arr[mid-1]>arr[mid]){
            return ans(arr, l, mid-1);
        }
        else{
            return ans(arr, mid+1, r);
        }
    }
    public int findPeakElement(int[] nums) {
        if(nums==null || nums.length==0){
            return -1;
        }
        return ans(nums, 0, nums.length);
    }
}