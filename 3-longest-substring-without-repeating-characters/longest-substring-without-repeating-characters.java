class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();

        int ans = 0;
        int freq[] = new int[256];
        

        for (int i = 0; i < n; i++) {
            for (int j = i ; j < n; j++) {
                char ch = s.charAt(j);
                if (freq[ch] != 0) {
                    break;
                }
                ans = Math.max(ans, j - i + 1);
                freq[ch]++;
            }
            for (int x= 0; x<256; x++) freq[x] = 0;
        }

        return ans;
    }
}