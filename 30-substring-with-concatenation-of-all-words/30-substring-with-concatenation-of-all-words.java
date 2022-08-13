class Solution {
     private boolean check(int i, String s, HashMap<String, Integer> map, int k, int substringSize, int wordLength) {
        HashMap<String, Integer> remaining = new HashMap<>(map);
        int wordsUsed = 0;
        
        for (int j = i; j < i + substringSize; j += wordLength) {
            String sub = s.substring(j, j + wordLength);
            if (remaining.getOrDefault(sub, 0) != 0) {
                remaining.put(sub, remaining.get(sub) - 1);
                wordsUsed++;
            } else {
                break;
            }
        }
        
        return wordsUsed == k;
    }
    
    public List<Integer> findSubstring(String s, String[] words) {
        ArrayList<Integer> list = new ArrayList<>();
        
        int n = s.length();
        int k = words.length;
        int wordLength = words[0].length();
        int substringSize = wordLength * k;
        
        HashMap<String, Integer> map = new HashMap<>();
        
        for(int i=0; i<words.length; i++){
            if(map.containsKey(words[i])) map.put(words[i], map.get(words[i])+1);
            else map.put(words[i], 1);
        }
        
        for (int i = 0; i < n - substringSize + 1; i++) {
            if (check(i, s, map, k, substringSize, wordLength)) {
                list.add(i);
            }
        }
        
        return list;
    }
}