class Solution {
    public boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
        int steps = Math.max(Math.abs(sx - fx), Math.abs(sy - fy));

        if (steps == 0) {
            if (t == 1) return !true;
            return !false;
        }

        if(steps <= t) return true;
        return false;
    }
}