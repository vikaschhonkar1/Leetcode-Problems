class Pair {
    int first;
    int second;

    Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

class StockSpanner {
    Stack<Pair> stack;

    public StockSpanner() {
        stack = new Stack<>();
    }
    
    public int next(int price) {
        int span = 1;
        while(stack.isEmpty() == false && stack.peek().first <= price) {
            span += stack.peek().second;
            stack.pop();
        }
        stack.push(new Pair(price, span));
        return span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */