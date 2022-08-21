class Solution {
    private boolean check(char S[],char T[],int ind){
        for(int i=0;i<S.length;i++){
            if(T[i+ind]!='*' && S[i]!=T[i+ind]){
                return false;
            }
        } 
        return true;
    }
    
    private int  replace(char S[],char T[],int ind){
        int count=0;
        for(int i=0;i<S.length;i++){
            if(T[i+ind]!='*'){
                count++;
                T[i+ind]='*';
            }
        }
        return count;
    }
    
    public int[] movesToStamp(String stamp, String target) {
        char S[]=stamp.toCharArray();
        char T[]=target.toCharArray();
        
        ArrayList<Integer> arr=new ArrayList<>();
        boolean visited[]=new boolean[T.length-S.length+1];
        boolean change=true;
        int stars=0;
        
        while(stars<T.length){
            change=false;
            for(int i=0;i<=T.length-S.length;i++){
                if(!visited[i] && check(S,T,i)){
                    stars+=replace(S,T,i);
                    change=true;
                    visited[i]=true;
                    arr.add(i);
                }
            }
            
            if(change==false){
                return new int[0];
            }
        }
        
        int ans[]=new int[arr.size()];
        for(int i=0;i<ans.length;i++){
            ans[i]=arr.get(arr.size()-i-1);
        }
        
        return ans;
    }
}