class Solution {
    public int maxDepth(String str) {
        Stack<Character> stack = new Stack<Character>();
        int n = str.length();
        int count = 0;
        for(int i=0; i<n; i++){
            if(str.charAt(i)=='('){
                stack.push('(');
            } else if(str.charAt(i)==')'){
                stack.pop();
            }
            count = Math.max(stack.size(), count);
        }
        return count;
    }
}