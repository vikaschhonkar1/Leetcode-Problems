class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        int count = 0;
        int firstDiffIdx = 0;
        int secondDiffIdx = 0;
        
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                count++;

                if (count > 2) return false;
                else if (count == 1) firstDiffIdx = i;
                else secondDiffIdx = i;  
            }
        }

        return s1.charAt(firstDiffIdx) == s2.charAt(secondDiffIdx) &&
               s1.charAt(secondDiffIdx) == s2.charAt(firstDiffIdx);
    }
}