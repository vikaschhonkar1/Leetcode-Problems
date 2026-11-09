class Solution {
    public int lengthOfLongestSubstring(String str) {
        int n = str.length();
        int maxLength = 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for(int i=0, j=0; i<n; i++){
            if(map.containsKey(str.charAt(i))){
                j = Math.max(j, map.get(str.charAt(i))+1);
            }
            map.put(str.charAt(i), i);
            maxLength = Math.max(maxLength, i-j+1);
        }
        return maxLength;
    }
}