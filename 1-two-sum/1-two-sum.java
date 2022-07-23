class Solution {
    public int[] twoSum(int[] nums, int target) {
        //Given : each input would have exactly one solution and 
        //        we cannot use the same element twice
        
        // So we will use a HashMap approach to solve this
        
        //First Declare the array of size 2 which needs to be return
        int ans[] = new int[2];
        
        //Declare a HashMap which will Store 
        //values of array as key and their index as the value
        HashMap<Integer, Integer> map = new HashMap<>();
        
        //First pass: Putting every element in array and their respective Position
        for(int i=0; i<nums.length; i++){
            map.put(nums[i], i);
        }
    
        //Second Pass : Iterate over each value and check whether
        //              the (target-nums[i]) is present in array or not(using map)
        for(int i=0; i<nums.length; i++){
            //check whether value "target-nums[i]" is present as key in map or not
            //and simultaneously checking whether the two numbers are not the same
            if(map.containsKey(target-nums[i])  && i!=map.get(target-nums[i])){
                ans[0] = i;
                ans[1] = map.get(target-nums[i]);
                break;
            } 
        }
        
        //return the array "ans"
        return ans;
    }
}


//Time Complexity : O(n+n) = O(2n) = O(n)
//Space Complexity: O(n)