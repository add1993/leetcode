class Solution {
public:
    int findMaxLength(vector<int>& nums) {
        if (nums.size() < 1) return 0;
        unordered_map<int,int> M;
        int sum = 0, maxLen = 0;
        
        for (int i = 0; i < nums.size(); i++) {
            if (nums[i] == 0) sum -= 1;
            else sum += 1;
            
            if (sum == 0) maxLen = max(maxLen, i+1);
            
            if (M.find(sum) == M.end()) {
                M[sum] = i;
            } else {
                maxLen = max(maxLen, i-M[sum]);
            }
        }
        return maxLen;
    }
};