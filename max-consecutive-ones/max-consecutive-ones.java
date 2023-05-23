class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int n = nums.length;

        int maxConsecutiveOnes = 0;
        int currentConsecutiveOnes = 0;

        for(int i=0; i<n; i++){
            if(nums[i] == 0){
                currentConsecutiveOnes = 0;
            } else {
                currentConsecutiveOnes++;
                maxConsecutiveOnes = Math.max(maxConsecutiveOnes, currentConsecutiveOnes);
            }
        }
        return maxConsecutiveOnes;
    }
}