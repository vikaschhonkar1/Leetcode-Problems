class Solution {
    public String mergeAlternately(String word1, String word2) {
        String ans = "";

        int i = 0; 
        int j = 0;

        int m = word1.length();
        int n = word2.length();

        int turn = 1;

        while (i < m && j < n) {
            if(turn == 1) {
                ans += word1.charAt(i);
                i++;
                turn = 2;
            } else {
                ans += word2.charAt(j);
                j++;
                turn = 1;
            }
        }

        while (i < m) {
            ans += word1.charAt(i);
            i++;
        }

        while (j < n) {
            ans += word2.charAt(j);
            j++;
        } 

        return ans;
    }
}