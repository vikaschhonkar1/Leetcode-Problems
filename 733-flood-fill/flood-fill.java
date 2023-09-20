class Solution {
    private void helper(int[][] image, int row, int col, int color, int target) {
        if(row < 0 || row >= image.length || col < 0 || col >= image[0].length) {
            return;
        }

        if(image[row][col] != target) {
            return;
        }

        image[row][col] = color;

        helper(image, row - 1, col, color, target);
        helper(image, row, col + 1 , color, target);
        helper(image, row + 1, col, color, target);
        helper(image, row, col - 1, color, target);
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int target = image[sr][sc];

        if(target == color) {
            return image;
        }

        helper(image, sr, sc, color, target);

        return image;
    }
}