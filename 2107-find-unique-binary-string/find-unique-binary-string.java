class Solution {
    public String findDifferentBinaryString(String[] nums) {
        int n = nums[0].length();
        long maxValue = (long)Math.pow(2, n);
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++) {
            String str = nums[i];
            set.add(Integer.parseInt(str, 2));
        }

        for(int i = 0; i < maxValue; i++) {
            if(set.contains(i)==false) 
                return String.format("%" + n + "s", Integer.toBinaryString(i)).replace(' ', '0');
                // return Integer.toBinaryString(i);
        }
        return "";
    }
}