class Solution {
    public static int firstOccurence(int[] nums, int target){
        int start = 0;
        int end = nums.length - 1;
        int result = -1;
        while(start<=end){
            int mid = start + (end - start)/2;
            if(nums[mid]==target){
                result = mid;
                end = mid - 1;
            }
            else if(nums[mid]<target){
                start = mid + 1;
            }
            else{
                end = mid - 1;
            }
        }
        return result;
    }
    
    public static int lastOccurence(int[] nums, int target){
        int start = 0;
        int end = nums.length - 1;
        int result = -1;
        while(start<=end){
            int mid = start + (end - start)/2;
            if(nums[mid]==target){
                result = mid;
                start = mid + 1;
            }
            else if(nums[mid]<target){
                start = mid + 1;
            }
            else{
                end = mid - 1;
            }
        }
        return result;
    }
    
    public int[] searchRange(int[] nums, int target) {
        int arr[] = new int[2];
        arr[0] = firstOccurence(nums, target);
        arr[1] = lastOccurence(nums, target);
        return arr;
    }
}