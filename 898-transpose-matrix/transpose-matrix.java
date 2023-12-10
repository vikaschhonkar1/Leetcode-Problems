class Solution {
    public int[][] transpose(int[][] matrix) {
        int rows = matrix.length;
        int columns = matrix[0].length;
        int arr[][] = new int[columns][rows];
        for(int i=0; i<rows; i++){
            for(int j=0; j<columns; j++){
                arr[j][i] = matrix[i][j];
            }
        }
        return arr;
    }
}