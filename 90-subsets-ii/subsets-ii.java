class Solution {
    private static void findSubSetsWithDup(int[] nums, int i, ArrayList<Integer> tempList, List<List<Integer>> subsetList, int n) {
        if( i == n ) {
            subsetList.add(new ArrayList<>(tempList));
            return;
        }
        
        // not take
        findSubSetsWithDup(nums, i + 1, tempList, subsetList, n);

        // take
        tempList.add(nums[i]);
        findSubSetsWithDup(nums, i + 1, tempList, subsetList, n);
        tempList.remove(tempList.size() - 1);

    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> subsetList = new ArrayList<>();
        findSubSetsWithDup(nums, 0, new ArrayList<Integer>(), subsetList, n);
        HashSet<List<Integer>> set = new HashSet<>(subsetList);
        List<List<Integer>> subsetList1 = new ArrayList<>(set);
        
        return subsetList1;
    }
}