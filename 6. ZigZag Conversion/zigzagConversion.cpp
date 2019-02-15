class Solution {
public:
    string convert(string s, int numRows) {
        if (numRows <= 1) return s;
        vector<string> vec(numRows);
        string res = "";
        int N = s.size();
        
        for (int i = 0; i < N; ) {
            for (int j = 0; j < numRows && i < N; j++, i++) {
                vec[j] += s[i];
            }
            for (int j = numRows-2; j > 0 && i < N; j--, i++) {
                vec[j] += s[i];
            }
        }
        
        for (int i = 0; i < numRows; i++) {
            res += vec[i];
        }
        return res;
    }
};