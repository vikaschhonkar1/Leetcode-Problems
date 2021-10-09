class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int arr[] = new int[m+n];
        for(int i=0; i<m+n; i++){
            if(i<m){
                arr[i] = nums1[i];
            }
            else{
                arr[i] = nums2[i-m];
            }
        }
        Arrays.sort(arr);
        for(int i=0; i<m+n; i++){
            nums1[i] = arr[i];
        }
    }
}