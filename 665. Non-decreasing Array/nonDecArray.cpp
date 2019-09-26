class Solution {
public:
    bool checkPossibility(vector<int>& nums) {
        int count = 0, index = -1;
        for (int i = 0; i < nums.size(); i++) {
            if (i+1 < nums.size() && nums[i] > nums[i+1]) {
                count++;
                index = i;
            }
            
            if (count > 1) {
                return false;
            }
        }
        int j = index;
        int n = nums.size();
        if(count==0 || (count==1 && (j==0 || j==n-2 || nums[j]<=nums[j+2] || nums[j-1]<=nums[j+1]))) 
            return true;
        
        return false;
    }
};