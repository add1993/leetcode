class Solution {
public:
    void nextPermutation(vector<int>& nums) {
        int index = -1;
        int N = nums.size();
        for (int i = N-1; i > 0; i--) {
            if (nums[i] > nums[i-1]) {
                index = i-1;
                break;
            }
        }
        if (index == -1) {
            reverse(nums.begin(), nums.end());
        } else {
            for (int i = N-1; i > index; i--) {
                if (nums[i] > nums[index]) {
                    swap(nums[i], nums[index]);
                    break;
                }
            }
            reverse(nums.begin() + index + 1, nums.end());
        }
    }
};