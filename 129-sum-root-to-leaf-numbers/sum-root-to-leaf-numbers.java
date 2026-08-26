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
    private int f(TreeNode root, int pathSoFar) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return pathSoFar * 10 + root.val;
        return f(root.left, pathSoFar * 10 + root.val) + f(root.right, pathSoFar * 10 + root.val);
    }
    public int sumNumbers(TreeNode root) {
        return f(root, 0);
    }
}