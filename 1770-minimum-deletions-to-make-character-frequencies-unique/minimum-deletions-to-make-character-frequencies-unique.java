class Solution {
    public int minDeletions(String s) {
        int freq[] = new int[26];
        for(int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }

        HashSet<Integer> set = new HashSet<Integer>();
        int ans = 0;
        for(int i = 0; i < 26; i++) {
            int val = freq[i];
            if(val != 0) {
                if(set.contains(val)) {
                    // System.out.println(set);
                    while(val > 0) {
                        // System.out.print(val);
                        val--;
                        ans++;
                        if(set.contains(val)) {
                            continue;
                        } else {
                            set.add(val);
                            break;
                        }
                    }
                } else {
                    set.add(val);
                }
            }
        }

        return ans;
    }
}