class Solution {
public:
    vector<int> findRightInterval(vector<vector<int>>& a) {
        vector<pair<pair<int,int>,int>> v;
        for(int i=0;i<a.size();i++){
            v.push_back(make_pair(make_pair(a[i][0],a[i][1]),i));
        }
        sort(v.begin(),v.end());
        int n=a.size();
        vector<int> ans(n,0);
        for(int i=0;i<v.size();i++){
            int l=i+1,r=v.size()-1,ind=v.size();
            while(l<=r){
                int mid=(l+r)/2;
                if(v[mid].first.first>=v[i].first.second){
                    ind=v[mid].second;
                    r=mid-1;
                }else{
                    l=mid+1;
                }
            }
            if(ind==v.size()){ind=i;ans[v[i].second]=-1;}
            else{ans[v[i].second]=ind;}
            if(v[i].first.first==v[i].first.second){ans[v[i].second]=v[i].second;}
        }
        return ans;
    }
};