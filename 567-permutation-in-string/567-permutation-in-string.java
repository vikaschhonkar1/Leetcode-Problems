class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int freq[] = new int[26];
        for(int i=0; i<s1.length(); i++) freq[s1.charAt(i)-'a']++;
        
        int i = 0;
        int j = 0;
        int len = s1.length();
        
        while(j<s2.length()){
            if(freq[s2.charAt(j++)-'a']-- > 0)
                len--;
            if(len == 0) return true;
            if(j - i == s1.length() && freq[s2.charAt(i++)-'a']++>=0)
                len++;
        }
        
        return false;
    }
}