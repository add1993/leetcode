class Solution {
public:
    bool reorderedPowerOf2(int N) {
        string nums = to_string(N);
        sort(nums.begin(), nums.end());
        int num = stoi(nums);
        
        if (nums[0] != '0' && ((num & (num-1)) == 0)) return true;
        
        while (nextPermutation(nums)) {
            num = stoi(nums);
            if ((num & (num-1)) == 0) return true;
        }
        return false;
    }
    
    bool nextPermutation(string &nums) {
        int index = -1;
        int N = nums.size();
        for (int i = N-1; i > 0; i--) {
            if (nums[i] > nums[i-1]) {
                index = i-1;
                break;
            }
        }
        if (index == -1) {
            return false;
        } else {
            for (int i = N-1; i > index; i--) {
                if (nums[i] > nums[index]) {
                    swap(nums[i], nums[index]);
                    break;
                }
            }
            reverse(nums.begin() + index + 1, nums.end());
        }
        return true;
    }
};