class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        if (k == nums.length) return nums;

        HashMap<Integer, Integer> count = new HashMap<Integer, Integer>();
        for (int n: nums) count.put(n, count.getOrDefault(n, 0) + 1);
        

        Queue<Integer> heap = new PriorityQueue<>(
            (n1, n2) -> count.get(n1) - count.get(n2));

        for (int n: count.keySet()) {
          heap.add(n);
          if (heap.size() > k) heap.poll();    
        }

        int[] ans = new int[k];
        for(int i = k - 1; i >= 0; --i) {
            ans[i] = heap.poll();
        }
        return ans;
    }
}