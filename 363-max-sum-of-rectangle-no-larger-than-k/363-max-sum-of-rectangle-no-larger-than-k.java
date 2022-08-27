class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
        return 0;
    int rows = matrix.length, cols = matrix[0].length;
    int[][] areas = new int[rows][cols];
    for (int r = 0; r < rows; r++) {
        for (int c = 0; c < cols; c++) {
            int area = matrix[r][c];
            if (r-1 >= 0)
                area += areas[r-1][c];
            if (c-1 >= 0)
                area += areas[r][c-1];
            if (r-1 >= 0 && c-1 >= 0)
                area -= areas[r-1][c-1];
            areas[r][c] = area;
        }
    }
    int max = Integer.MIN_VALUE;
    for (int r1 = 0; r1 < rows; r1++) {
        for (int c1 = 0; c1 < cols; c1++) {
            for (int r2 = r1; r2 < rows; r2++) {
                for (int c2 = c1; c2 < cols; c2++) {
                    int area = areas[r2][c2];
                    if (r1-1 >= 0)
                        area -= areas[r1-1][c2];
                    if (c1-1 >= 0)
                        area -= areas[r2][c1-1];
                    if (r1-1 >= 0 && c1 -1 >= 0)
                        area += areas[r1-1][c1-1];
                    if (area <= k)
                        max = Math.max(max, area);
                }
            }
        }
    }
    return max;
}
}