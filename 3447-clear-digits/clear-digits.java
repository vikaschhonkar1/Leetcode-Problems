class Solution {
    public String clearDigits(String s) {
        Stack<Character> st = new Stack<>();

        for (char ch: s.toCharArray()) {
            if (ch <= '9' && ch >= '0') {
                st.pop();
            } else {
                st.push(ch);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) {
            sb.insert(0, st.pop());
        }

        return sb.toString();
    }
}