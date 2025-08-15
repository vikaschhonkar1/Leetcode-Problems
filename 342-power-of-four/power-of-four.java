class Solution {
    public boolean isPowerOfFour(int n) {
        double power = Math.log(n) / Math.log(4);
        int powerInt = (int) power;
        return power - powerInt == 0.0;
    }
}