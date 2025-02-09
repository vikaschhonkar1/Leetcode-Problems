class Solution {
    public long countBadPairs(int[] nums) {
        int n = nums.length;
        long goodPairs = 0L;
        Map<Integer, Long> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int diff = nums[i] - i;
            goodPairs += map.getOrDefault(diff, 0L);
            map.put(diff, map.getOrDefault(diff, 0L) + 1); 
        }

        long totalPairs = (long) n * (n - 1)/2;

        return  totalPairs - goodPairs;
    }
}