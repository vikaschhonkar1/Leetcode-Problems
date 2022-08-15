class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int freqRansomNote[] = new int[26];
        int freqMagazine[] = new int[26];
        for(int i=0; i<ransomNote.length(); i++) freqRansomNote[ransomNote.charAt(i)-'a']++;
        for(int i=0; i<magazine.length(); i++) freqMagazine[magazine.charAt(i)-'a']++;
        
        for(int i=0; i<26; i++) if(freqRansomNote[i]>freqMagazine[i]) return false;
        return true;
    }
}