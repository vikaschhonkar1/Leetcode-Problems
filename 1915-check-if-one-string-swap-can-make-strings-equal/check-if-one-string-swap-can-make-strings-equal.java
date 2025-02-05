class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        int count = 0;
        
        for (int i = 0; i < s1.length(); i++) 
            if (s1.charAt(i) != s2.charAt(i)) count++;

        if (count == 0) return true;
        else if (count == 2) {
            int freq[] = new int[26];

            for (int i = 0; i < s1.length(); i++) {
                freq[s1.charAt(i) - 'a']++;
                freq[s2.charAt(i) - 'a']--;
            }

            for (int i = 0; i < 26; i++) {
                if (freq[i] != 0) return false; 
            }

            return true;
        }
        return false;
    }
}