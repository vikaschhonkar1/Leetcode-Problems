class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        TreeSet<Integer> treeSet = new TreeSet<>();
        for(int i=0; i<arr2.length; i++) treeSet.add(arr2[i]);
        
        int ans = 0;
        for(int i=0; i<arr1.length; i++){
           int left = arr1[i] - d;
           int right = arr1[i] + d;
            
           Set<Integer> set = treeSet.subSet(left, right+1);
           if(set.isEmpty()) ans++;  
        }
        return ans;
    }
}