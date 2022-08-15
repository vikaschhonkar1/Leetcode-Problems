class Solution {
    public int findStartPosition(int[] a, int target){
	    int left = 0;
        int right = a.length-1;
	    int start = -1;
	
	    while(left<=right){
		    int mid = left + (right-left)/2;
		    if (a[mid] == target){
				start = mid; 
				right = mid-1; 
		    }else if (target > a[mid]) left = mid+1;
		    else right = mid-1; 
	    }
	    return start;
    }

    public int findEndPosition(int[] a, int target){
	    int left = 0;
	    int right = a.length-1;
	    int end = -1;
	
	    while(left <= right){
		int mid = left + (right-left)/2;
		if (a[mid] == target){
			end = mid;	
			left = mid+1;
		}else if (target > a[mid]) left = mid +1;
		else right = mid -1;
	    }
	    return end;
    }
    
    public int[] searchRange(int[] a, int target){
		int[] ans = {-1, -1};
		if (a == null || a.length == 0) return ans;
		
		ans[0] = findStartPosition(a, target);
		ans[1] = findEndPosition(a, target);
		
		return ans;
    }
}