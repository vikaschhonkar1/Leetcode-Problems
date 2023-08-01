class Solution {
    private void combineFunction(List<List<Integer>> combinations, int i, int n, int k, ArrayList<Integer> currList) {
        
        if (k == 0) {
            // System.out.println(combinations);
            combinations.add(new ArrayList(currList));
            return;
        }

        if (i > n) {
            return;
        }

        currList.add(i);
        combineFunction(combinations, i + 1, n, k - 1, currList);
        currList.remove(currList.size() - 1);

        combineFunction(combinations, i + 1, n, k, currList);
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> combinations = new ArrayList<List<Integer>>();
        combineFunction(combinations, 1, n, k, new ArrayList<Integer>());
        return combinations;
    }
}