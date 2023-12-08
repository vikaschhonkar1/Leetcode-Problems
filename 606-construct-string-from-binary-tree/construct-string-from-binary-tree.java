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
    private void helper (StringBuilder sb, TreeNode root) {
        if(root != null) {
            sb.append (root.val);
            if(root.left != null || root.right != null) {
                sb.append("(");
                helper(sb, root.left);
                sb.append(")");
                if(root.right != null) {
                    sb.append("(");
                    helper(sb, root.right);
                    sb.append(")");
                }
            }
        }
    }
    
    public String tree2str(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        helper(sb, root);
        return sb.toString();
    }
}