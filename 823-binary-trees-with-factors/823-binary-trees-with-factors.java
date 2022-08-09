class Solution {
    public int numFactoredBinaryTrees(int[] arr) {
        if (arr==null || arr.length==0) return 0;
        
        
        Arrays.sort(arr);
        Map<Integer, Long> map = new HashMap();
        long count = 1;
        map.put(arr[0], count);
        
        for (int i = 1; i < arr.length; i++) {
            count = 1;
            for (Integer n : map.keySet()) {
                if (arr[i] % n == 0 && map.containsKey(arr[i] / n)) {
                    count += map.get(n) * map.get(arr[i] / n);
                }
            }
            map.put(arr[i], count);
        }
        long sum = 0;
        for (Integer n : map.keySet()) {
            sum = (sum + map.get(n)) % ((int) Math.pow(10, 9) + 7) ;
        }
        return (int) sum;
    }
}