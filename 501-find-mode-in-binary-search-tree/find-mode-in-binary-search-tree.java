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
    private static void dfsTraversal(TreeNode node, HashMap<Integer, Integer> freqMap) {
        if(node == null) {
            return;
        }

        freqMap.put(node.val, freqMap.getOrDefault(node.val, 0) + 1);
        dfsTraversal(node.left, freqMap);
        dfsTraversal(node.right, freqMap);

    }
    public int[] findMode(TreeNode root) {
        // map for storing frequencies of elements in BST
        HashMap<Integer, Integer> freqMap = new HashMap<Integer, Integer>();
        dfsTraversal(root, freqMap);

        // find max frequency
        int maxFrequency = 0;
        for(int key: freqMap.keySet()) {
            maxFrequency = Math.max(maxFrequency, freqMap.get(key));
        }

        // elements with max frequency
        ArrayList<Integer> modeList = new ArrayList<Integer>();
        for(int key: freqMap.keySet()) {
            if(freqMap.get(key) == maxFrequency) {
                modeList.add(key);
            }
        }

        int modeArray[] = new int[modeList.size()];
        for(int i = 0; i < modeList.size(); i++) {
            modeArray[i] = modeList.get(i);
        }

        return modeArray;
    }
}