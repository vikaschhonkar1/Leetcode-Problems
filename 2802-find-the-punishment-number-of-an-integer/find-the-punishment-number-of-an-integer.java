class Solution {
    
    private boolean canBePartitioned (String str, int target, int sum) {
        if (str.isEmpty() && target == sum) return true;
        if (sum > target) return false;

        for (int i = 0; i < str.length(); i++) {
            String left = str.substring(0, i + 1);
            String right = str.substring(i + 1);

            if (canBePartitioned(right, target, sum + Integer.parseInt(left))) return true;
        }
        return false;
    }

    public int punishmentNumber(int n) {
        long ans = 0L;
        for (int i = 1; i <= n; i++) {
            if (canBePartitioned(String.valueOf(i * i), i, 0)) {
                ans += i * i;
            }
        }
        return (int) ans;
    }
}