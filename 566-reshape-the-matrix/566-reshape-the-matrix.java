class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        if(mat == null || mat.length == 0) return null;
        
        int row_nums = mat.length;
        int col_nums = mat[0].length;
        
        if(row_nums*col_nums != r * c) return mat;
        
        int[][] res = new int[r][c];
        List<Integer> list = new ArrayList<>();
        for(int[] row : mat){
            for(int col : row){
                list.add(col);
            }
        }
        
        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                int index = i*c + j;
                res[i][j] = list.get(index);
            }
        }
        return res;
    }
}