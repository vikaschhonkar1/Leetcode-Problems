class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int result = 0;
        
        for(int i=0; i<nums.length; i++){
            if(nums[i]==1)
                count++;
            else{
                if(count>result)
                    result = count;
                count = 0;
            }
        }
        return(Math.max(count, result));
    }
}