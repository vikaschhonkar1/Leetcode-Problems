class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> positive = new Stack<Integer>();
        Stack<Integer> neagative = new Stack<Integer>();

        for(int i = 0; i < asteroids.length; i++){
            int n = asteroids[i];
            if(n>0){
                positive.push(n);
            }else{
                while(!positive.isEmpty() && positive.peek() < -n){
                    positive.pop();
                }
                if(!positive.isEmpty() && positive.peek() == -n){
                    positive.pop();
                    continue;
                }
                if(positive.isEmpty()){
                    neagative.push(n);
                }
            }
        }

        int size = positive.size() + neagative.size();
        asteroids = new int[size];
        int i = size-1;
        
        while(positive.size()>0){
            asteroids[i] = positive.pop();
            i--;
        }

        while(neagative.size()>0){
            asteroids[i] = neagative.pop();
            i--;
        }

        return asteroids;
    }
}