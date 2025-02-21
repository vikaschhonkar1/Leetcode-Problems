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
class FindElements {
    private HashSet<Integer> set = new HashSet<>();

    private void solve(TreeNode root, int val, boolean left) {
        if (root == null) return;

        root.val = left ? 2 * val + 1 : 2 * val + 2;
        set.add(root.val);
        solve(root.left, root.val, true);
        solve(root.right, root.val, false);
    }

    public FindElements(TreeNode root) {
        root.val = 0;
        set.add(0);
        solve(root.left, 0, true);
        solve(root.right, 0, false);
    }
    
    public boolean find(int target) {
        return set.contains(target);
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */