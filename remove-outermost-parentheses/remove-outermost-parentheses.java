class Solution {
    public String removeOuterParentheses(String s) {
        String ans = "";
        int n = s.length();

        int openBracket = 1;
        int closingBracket = 0;

        for(int i=1; i<n; i++){
            if(s.charAt(i)=='(') openBracket++;
            else closingBracket++;

            if(openBracket==closingBracket) {
                openBracket++;
                i++;
                continue;
            }
            ans = ans + s.charAt(i);
        }
        return ans;
    }
}