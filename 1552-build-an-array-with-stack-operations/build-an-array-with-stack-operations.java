class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> operations = new ArrayList<>();

        int currValue = 1;
        
        for(int i = 0; i < target.length; i++) {
            operations.add("Push");

            if(currValue != target[i]) {
                operations.add("Pop");
                i--;
            }

            currValue++;
        }

        return operations;
    }
}