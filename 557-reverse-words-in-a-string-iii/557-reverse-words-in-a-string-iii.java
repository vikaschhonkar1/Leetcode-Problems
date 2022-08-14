class Solution {
    public void reverseString(char[] s) {
        int n = s.length;
        for(int i=0; i<n/2; i++){
            char temp = s[i];
            s[i] = s[n-i-1];
            s[n-i-1] = temp;
        }
    }
    
    public String reverseWords(String s) {
        String[] str = s.split(" ");
        String ans = "";
        for (int i = 0; i < str.length; i++) {
            str[i] = new StringBuilder(str[i]).reverse().toString();
        //     ans = ans + String.valueOf(reverseString(str[i].toCharArray())) + " ";
        }
        StringBuilder result = new StringBuilder();
        for (String st : str) result.append(st + " ");
        return result.toString().trim();
    }
}