class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList){
        HashSet<String> set = new HashSet<>(wordList);
        if(!set.contains(endWord)) return 0;
        
        int length = 0;
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        
        while(!q.isEmpty()){
            length++;
            int currSize = q.size();
            
            while(currSize-->0){   
                String curr = q.poll();
                int len = curr.length();
                for(int i=0; i<len; i++){
                    String temp = curr;
                    for(char ch='a'; ch<='z'; ch++){
                        temp = temp.substring(0,i) + ch + temp.substring(i+1);
                        if(temp.equals(curr)) continue;
                        if(temp.equals(endWord)) return length+1;
                        else if(set.contains(temp)){
                            q.add(temp);
                            set.remove(temp);   
                        }     
                    }
                }    
            }
        }
        return 0;
    }
}