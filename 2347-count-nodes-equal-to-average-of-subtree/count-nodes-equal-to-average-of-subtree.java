/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private int count = 0;

    private int[] averageOfTree(TreeNode node) {
        if(node == null) {
            return new int[] {0,0};
        }

        int[] leftTree = averageOfTree(node.left);
        int[] rightTree = averageOfTree(node.right);

        int currentSum = leftTree[0] + rightTree[0] + node.val;
        int currentCount = leftTree[1] + rightTree[1] + 1;

        if(currentSum / currentCount == node.val) {
            count++;
        }

        return new int[] {currentSum, currentCount};
    }

    public int averageOfSubtree(TreeNode root) {
        averageOfTree(root);
        return count;
    }
}