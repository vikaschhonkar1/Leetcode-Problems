class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int idx = 0 ;
        int arr[] = new int[n*n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                arr[idx++] = matrix[i][j];
            }
        }
        Arrays.sort(arr);
        return arr[k-1];
    }
}