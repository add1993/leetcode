class Solution {
public:
    bool find132pattern(vector<int>& nums) {
        stack<int> stk;
        int s2 = INT_MIN;
        for (int i = nums.size() - 1; i >= 0; --i) {
            if (nums[i] < s2)
                return true;
            
            while (!stk.empty() && stk.top() < nums[i]) {
                s2 = stk.top();
                stk.pop();
            }
            stk.push(nums[i]);
        }
        return false;
    }
};