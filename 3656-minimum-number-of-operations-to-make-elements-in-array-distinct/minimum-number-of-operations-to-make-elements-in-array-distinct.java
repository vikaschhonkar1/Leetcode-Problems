class Solution {
    Set<Integer> set = new HashSet<>();
    public int minimumOperations(int[] nums) {
        for(int i = nums.length - 1; i >= 0; i--){
            if(set.contains(nums[i])){
                return (i + 3) / 3;
            }
            set.add(nums[i]);
        }
        return 0;
    }
}