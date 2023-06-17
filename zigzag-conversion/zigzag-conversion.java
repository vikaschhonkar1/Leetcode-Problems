class Solution {
    public String convert(String s, int numRows) {
        int n = s.length();
        String ans = "";

        if(numRows == 1) return s;

        int interval = 2*numRows - 2;
        for(int i=0; i<numRows; i++){
            int j = i;
            while(j<n){
                if(interval != 0) ans+=s.charAt(j);
                j+=interval;

                if(i!=0 && j<n) ans+=s.charAt(j);
                j+=2*i;
            }
            interval -= 2;
        }
        return ans;
    }
}