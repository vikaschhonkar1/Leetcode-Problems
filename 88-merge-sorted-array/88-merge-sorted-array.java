class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i=0, j=0, idx=0;
        int ans[] = new int[m+n];
        while(i<m && j<n){
            if(nums1[i]<nums2[j])   ans[idx++] = nums1[i++];
            else    ans[idx++] = nums2[j++];
        }
        
        if(i<m)    while(i<m) ans[idx++] = nums1[i++];
        if(j<n)    while(j<n) ans[idx++] = nums2[j++];
    
        for(int x=0; x<m+n; x++)    nums1[x] = ans[x];
        
    }
}