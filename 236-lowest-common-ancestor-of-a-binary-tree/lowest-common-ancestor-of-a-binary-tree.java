/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // if we reach null (base case)
        if(root == null) {
            return null;
        }

        // we get one of the nodes
        if(root == p) return p;
        if(root == q) return q;

        // traversing left and right 
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if(left == null) {
            return right;
        } else if (right == null) {
            return left;
        } else {
            return root;
        }
    }
}