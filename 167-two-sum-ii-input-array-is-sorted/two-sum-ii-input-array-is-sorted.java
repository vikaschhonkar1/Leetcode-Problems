class Solution {
    public int[] twoSum(int[] arr, int target) {
        int i = 0;
        int j = arr.length - 1;
        int ans[] = new int[2];

        while(i < j) {
            if(arr[i] + arr[j] == target) {
                ans[0] = i + 1;
                ans[1] = j + 1;
                break;
            } else if (arr[i] + arr[j] > target) {
                j--;
            } else {
                i++;
            }
        }

        return ans;
    }
}