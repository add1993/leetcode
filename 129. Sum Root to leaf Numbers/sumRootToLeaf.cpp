/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    long long int result;
    int sumNumbers(TreeNode* root) {
        result = 0;
        vector<int> nums;
        return util(root, nums);
        //return result;
    }
    
    int util(TreeNode *root, vector<int> nums) {
        if (!root) return 0;
        if (root) nums.push_back(root->val);
        if (root && root->left == NULL && root->right == NULL) {
            return getNum(nums);
            //return;
        }
        
        //cout << root->val << endl;
        
        return util(root->left, nums) +  util(root->right, nums);
    }
    
    int getNum(vector<int> &nums) {
        int size = nums.size();
        long long int num = 0;
        for (int i = 0; i < size; i++) {
            num += nums[i]*pow(10, size-i-1);
        }
        //cout << "num = " << num << endl;
        return num;
    }
};