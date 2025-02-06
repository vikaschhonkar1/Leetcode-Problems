class Solution {
    public int tupleSameProduct(int[] nums) {
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();

        int n = nums.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int tempProd = nums[i] * nums[j];
                ans += map.getOrDefault(tempProd, 0);
                map.put(tempProd, map.getOrDefault(tempProd, 0) + 1);
            }
        }

        return ans * 8;
    }
}