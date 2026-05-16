class Solution {
public:
    int similarPairs(vector<string>& words) {
        map<vector<bool>,int>mp;

        for(auto it:words){
            vector<bool>arr(26,false);
            for(char c:it){
                arr[c-'a']=true;
            }
            mp[arr]++;
        }
        int s=0;
        for(auto &[k,c]:mp){
            c--;
            s+=(c*(c+1)/2);
        }
        return s;
    }
};