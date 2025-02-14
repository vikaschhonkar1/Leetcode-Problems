class ProductOfNumbers {
    ArrayList<Integer> list;
    int prod = 1;

    public ProductOfNumbers() {
        list = new ArrayList<>();
    }
    
    public void add(int num) {
        if (num == 0) {
            list = new ArrayList<>();
            prod = 1;
            return;
        }
        prod *= num;
        list.add(prod);
    }
    
    public int getProduct(int k) {
        if (list.size() < k) return 0;
        if (list.size() == k) return list.get(list.size() - 1);
        return list.get(list.size() - 1) / list.get(list.size() - k - 1);
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */