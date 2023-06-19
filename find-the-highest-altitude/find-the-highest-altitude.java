class Solution {
    public int largestAltitude(int[] gain) {
        int largestAltitude = 0;
        int netGain = 0;
        for(int i=0; i<gain.length; i++){
            netGain+=gain[i];
            if(netGain>largestAltitude)
                largestAltitude = netGain;
        }
        return largestAltitude;
    }
}