class Solution {
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Long> minHeap = new PriorityQueue<>();
        for (int num: nums) minHeap.add((long)num);

        int ans = 0;

        while (minHeap.peek() < k) {
            long minElement = minHeap.poll();
            long secondMinElement = minHeap.poll();
            minHeap.add(2 * minElement + secondMinElement);
            ans++;
        }

        return ans;
    }
}