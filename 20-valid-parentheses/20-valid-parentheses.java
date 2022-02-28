class Solution {
    public boolean isValid(String str) {
        Stack<Character> stack = new Stack<Character>();
        for(int i=0; i<str.length(); i++){
            char ch = str.charAt(i);
            if(ch=='(' || ch=='{' || ch=='['){
                stack.push(ch);
            } else if(ch==')'){
                if(stack.size()==0){
                    return false;
                } else if(stack.peek()!='('){
                    return false;
                } else{
                    stack.pop();
                }
            } else if(ch=='}'){
                if(stack.size()==0){
                    return false;
                } else if(stack.peek()!='{'){
                    return false;
                } else{
                    stack.pop();
                }
            } else if(ch==']'){
                if(stack.size()==0){
                    return false;
                } else if(stack.peek()!='['){
                    return false;
                } else{
                    stack.pop();
                }
            }
        }
        if(stack.size()==0){
            return true;
        } else{
            return false;
        }
    }
}