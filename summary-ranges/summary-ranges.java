class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList<String>();

        for(int i=0; i<nums.length; i++){
            int temp = nums[i];

            while(i<nums.length-1 && nums[i+1]-nums[i]==1) i++;

            if(nums[i] != temp) ans.add(temp+"->"+nums[i]);
            else ans.add(String.valueOf(temp));
        }

        return ans;
    }
}