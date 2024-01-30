class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        int n = tokens.length;
        int ans = 0;
        for(int i = 0; i < n; i++) {
            String curr = tokens[i];
            if(curr.equals("+") || curr.equals("-") || curr.equals("/") || curr.equals("*")) {
                int a = stack.pop();
                int b = stack.pop();
                if(curr.equals("+")) stack.push(b + a);
                if(curr.equals("-")) stack.push(b - a);
                if(curr.equals("*")) stack.push(b * a);
                if(curr.equals("/")) stack.push(b / a);
            } else {
                int curr_num = Integer.parseInt(curr);
                stack.push(curr_num);
            }
        }
        return stack.peek();
    }
}