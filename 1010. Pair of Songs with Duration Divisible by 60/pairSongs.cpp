class Solution {
public:
    int numPairsDivisibleBy60(vector<int>& time) {
        int count = 0;
        if (time.size() < 2) return 0;
        
        map<int, int> M;
        vector<int> vec;
        for (int i = 0; i < time.size(); i++) {
            int val = time[i] % 60;
            if (M.find(val) == M.end()) {
                M[val] = 1;
                vec.push_back(val);
            } else
                M[val]++;
        }
        
        if (M.find(0) != M.end()) {
            count += M[0]*(M[0]-1)/2;
        }
        
        if (M.find(30) != M.end()) {
            count += M[30]*(M[30]-1)/2;
        }
       
            
        for (int i = 1; i < 30; ++i) {
            count += M[i] * M[60 - i];
        }
        
        
        return count;
    }
};