class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int maxLength = -1;
        int n = s.length();

        for(int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if(map.containsKey(ch)) {
                maxLength = Math.max(maxLength, i - map.get(ch) - 1);
            } else {
                map.put(ch, i);
            }
        }

        // if(maxLength == 0) 
        return maxLength;
    }
}