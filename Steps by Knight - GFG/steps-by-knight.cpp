//{ Driver Code Starts
#include<bits/stdc++.h>
using namespace std;

// } Driver Code Ends
class Solution 
{
    public:
    //Function to find out minimum steps Knight needs to reach target position.
int minStepToReachTarget(vector<int>&KnightPos,vector<int>&TargetPos,int N)
	{
	    // Code here
	    queue<pair<pair<int,int>,int>>q;
	    q.push({{KnightPos[0]-1,KnightPos[1]-1},0});
	    
	   // int vis[N][N] = {0};
	   vector<vector<bool>> vis(N, vector<bool>(N, false));
	    int dr[] = {2,2,1,-1,-2,-2,-1,1};
	    int dc[] = {-1,1,2,2,1,-1,-2,-2};
	    int stepm =0;
	    while(!q.empty()){
	        int row = q.front().first.first;
            int col = q.front().first.second;
            int step = q.front().second;
            stepm = max(stepm,step);
            q.pop();
            
             if (row == TargetPos[0]-1 && col == TargetPos[1]-1) {
            return step;
            break;
        }
            for(int i =0;i<8;i++){
                int nr = row+dr[i];
                int nc = col+dc[i];
                
                
                if(nr>=0&&nr<N &&nc>=0 && nc<N&&!vis[nr][nc] ){
                    vis[nr][nc] = 1;
                    q.push({{nr,nc},step+1});
                }
            }
	    }
	    
	    return stepm;
	}
};

//{ Driver Code Starts.
int main(){
	int tc;
	cin >> tc;
	while(tc--){
		vector<int>KnightPos(2);
		vector<int>TargetPos(2);
		int N;
		cin >> N;
		cin >> KnightPos[0] >> KnightPos[1];
		cin >> TargetPos[0] >> TargetPos[1];
		Solution obj;
		int ans = obj.minStepToReachTarget(KnightPos, TargetPos, N);
		cout << ans <<"\n";
	}
	return 0;
}
// } Driver Code Ends