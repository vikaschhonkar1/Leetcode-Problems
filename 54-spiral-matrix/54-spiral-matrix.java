class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new LinkedList<Integer>();
        if(matrix==null || matrix.length==0) return null;
        
        int r = matrix.length;
        int c = matrix[0].length;
        int turn = 0;
        int i_max = r - 1;
        int i_min = 0;
        int j_max = c - 1;
        int j_min = 0;
        int i = 0;
        int j = 0;
        for (i = 0, j = 0; i_min <= i_max && j_min <= j_max;) {
            if (turn % 4 == 0) {
                list.add(matrix[i][j]);
                j++;
                if (j > j_max) {
                    turn++;
                    i_min++;
                    j--;
                    i++;
                }
            } else if (turn % 4 == 1) {
                list.add(matrix[i][j]);
                i++;
                if (i > i_max) {
                    turn++;
                    j_max--;
                    i--;
                    j--;
                }
            } else if (turn % 4 == 2) {
                list.add(matrix[i][j]);
                j--;
                if (j < j_min) {
                    turn++;
                    i_max--;
                    j++;
                    i--;
                }
            } else {
                list.add(matrix[i][j]);
                i--;
                if (i < i_min) {
                    turn++;
                    j_min++;
                    i++;
                    j++;
                }
            }
        }
        return list;
    }
}