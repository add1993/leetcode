class Solution {
public:
    
    bool dictContains(string word, vector<string>& wordDict) {
        for (int i = 0; i < wordDict.size(); i++) {
            if (word == wordDict[i]) return true;
        }
        return false;
    }
    unordered_map<string, vector<string>> m;

    vector<string> combine(string word, vector<string> prev){
        for(int i=0;i<prev.size();++i){
            prev[i]+=" "+word;
        }
        return prev;
    }
    
    vector<string> wordBreak(string s, vector<string>& wordDict) {
        unordered_set<string> dict(wordDict.begin(), wordDict.end());
        return wordBreakUtil(s, dict);
    }
    
    vector<string> wordBreakUtil(string s, unordered_set<string>& dict) {
        if(m.count(s)) return m[s]; //take from memory
        
        vector<string> result;
        if(dict.count(s)){ //a whole string is a word
            result.push_back(s);
        }
        for(int i=1;i<s.size();++i){
            string word=s.substr(i);
            if(dict.count(word)){
                string rem=s.substr(0,i);
                vector<string> prev=combine(word,wordBreakUtil(rem,dict));
                result.insert(result.end(),prev.begin(), prev.end());
            }
        }
        m[s]=result; //memorize
        return result;
    }
    
    // TLE
    vector<string> wordBreakBFS(string s, vector<string>& wordDict) {
        vector<string> result;
        ios_base::sync_with_stdio(false); 
        cin.tie(NULL);  
        
        int visited[s.size()+1] = {0};
        queue<pair<int, string>> Q;
        Q.push(make_pair(0, ""));
        
        while (!Q.empty()) {
            int N = Q.size();
            for (int k = 0; k < N; k++) {
                pair<int,string> p = Q.front();
                //cout << "got pair " << p.first << " " << p.second << endl;
                int i = p.first;
                
                Q.pop();
                string res = "";
                if (i >= s.size()) break;
                    res = p.second;
                    for (int j = i+1; j <= s.size(); j++) {
                        string str = s.substr(i, j-i);
                        //cout << "str = " << str << endl;
                        if (dictContains(str, wordDict)) {
                            //cout << "Found " << str << " at " << j << endl;
                            string put;
                            if (res != "")
                                put = res + " " + str;
                            else 
                                put = str;

                            
                            if (j == s.size()) {
                                result.push_back(put);
                            } else {
                                //cout << "Push = " <<  i + j<< " " << put << endl;
                                Q.push(make_pair(j, put));
                            }

                        }
                    }
                    //visited[i] = 1;
                
            }
        }
        
        return result;
    }
};