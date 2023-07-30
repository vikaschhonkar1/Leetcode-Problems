import java.util.ArrayList;

/**
 * DisjointSet
 */
public class DisjointSet {
    ArrayList<Integer> rank = new ArrayList<Integer>();
    ArrayList<Integer> parent = new ArrayList<Integer>();
    ArrayList<Integer> size = new ArrayList<Integer>();

    public DisjointSet(int n) {
        for (int i = 0; i <= n; i++) {
            rank.add(0);
            parent.add(i);
            size.add(1);
        }
    }
    
    public int findUltimateParent(int node) {
        if(parent.get(node) == node) {
            return node;
        }

        int ultimateParent = findUltimateParent(parent.get(node));
        parent.set(node, ultimateParent); // Path Compression

        return ultimateParent;
    }


    public void unionByRank(int u, int v) {
        int ultimateParentU = findUltimateParent(u);
        int ultimateParentV = findUltimateParent(v);

        if(ultimateParentU == ultimateParentV) {
            return;
        }

        if(rank.get(ultimateParentU) < rank.get(ultimateParentV)) {
            parent.set(ultimateParentU, ultimateParentV);
        } else if (rank.get(ultimateParentU) > rank.get(ultimateParentV)) {
            parent.set(ultimateParentV, ultimateParentU);
        } else {
            parent.set(ultimateParentV, ultimateParentU);
            rank.set(ultimateParentU, rank.get(ultimateParentU) + 1);
        }
    }

    public void unionBySize(int u, int v) {
        int ultimateParentU = findUltimateParent(u);
        int ultimateParentV = findUltimateParent(v);

        if(ultimateParentU == ultimateParentV) {
            return;
        }

        if(size.get(ultimateParentU) < size.get(ultimateParentV)) {
            parent.set(ultimateParentU, ultimateParentV);
            size.set(ultimateParentV, size.get(ultimateParentV) + size.get(ultimateParentU));
        } else {
            parent.set(ultimateParentV, ultimateParentU);
            size.set(ultimateParentU, size.get(ultimateParentV) + size.get(ultimateParentU));
        }
    }

    public int getMaximumSize() {
        int maxSize = 0;

        for(int i = 0; i < size.size(); i++) {
            maxSize = Math.max(maxSize, size.get(i));
        }

        return maxSize;
    }
}

class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if(n == 0) {
            return 0;
        }

        int maxSize = 0;

        DisjointSet ds = new DisjointSet(n);
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        for(int i = 0; i < n; i++) {
            if(map.containsKey(nums[i])) {
                continue;
            } 
            if(map.containsKey(nums[i] + 1)) {
                ds.unionBySize(i, map.get(nums[i] + 1));
            } 
            if(map.containsKey(nums[i] - 1)) {
                ds.unionBySize(i, map.get(nums[i] - 1));
            }

            map.put(nums[i], i);
        }

        maxSize = ds.getMaximumSize();
        return maxSize;
    }
}