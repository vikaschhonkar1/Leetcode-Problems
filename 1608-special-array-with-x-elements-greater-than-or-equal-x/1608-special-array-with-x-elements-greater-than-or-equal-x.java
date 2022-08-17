class Solution {
    public int specialArray(int[] nums) {
        Arrays.sort(nums);
        int end=nums.length;
        for (int i = 0; i <end; i++) {
            if(nums[i]>=end-i){ 
                if(i==0) return end-i;
                if (nums[i-1]<end-i ) return end-i;
            }
        }
        return -1;
    }
}