class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int n = nums.length;
        int pre[] = new int[n];
        pre[0] = nums[0];
        for(int i = 1; i < n; i++) pre[i] = pre[i - 1] + nums[i];
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int rem = (pre[i] % k + k) % k;
            if(map.containsKey(rem)) {
                ans+=map.get(rem);
                map.put(rem, map.get(rem)+1);
            } else {
                map.put(rem, 1);
            }
            
        }
        return ans;
    }
}