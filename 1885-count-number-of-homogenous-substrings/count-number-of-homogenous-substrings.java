class Solution {
    public static final int MOD = 1_000_000_007; 
    public int countHomogenous(String s) {
        int count = 0;
        int temp = 0;
        int curr = 0;
        for(int i = 0; i < s.length(); i++) {
            temp = s.charAt(i) == curr ? temp + 1 : 1;
            curr = s.charAt(i);
            count = (count + temp) % MOD;
        }
        return count;
    }
}