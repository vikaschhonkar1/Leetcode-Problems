class Solution {
    public int reverse(int x) {
        int ans = 0;

        while(x!=0){
            int temp = x%10;
            int newTemp = ans*10 + temp;
            if((newTemp-temp)/10 != ans ) return 0;
            ans = newTemp;
            x/=10;
        }
        return ans;
    }
}