class Solution {
public:
    string evaluate(string s, vector<vector<string>>& knowledge) {
        unordered_map<string,string>mp;
        for(auto it:knowledge){
            mp[it[0]]=it[1];
        } 
        int n=s.size();

        string ans="";
        for(int i=0;i<n;i++){
            if(s[i]=='('){
                i++;
                string key="";
                while(i<n&&s[i]!=')'){
                    key+=s[i++];
                }
                ans+=(mp[key]=="")?"?":mp[key];
            }else ans+=s[i];
        }   
        return ans;
    }
};