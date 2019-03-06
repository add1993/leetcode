class Solution {
public:
    bool isCompleteTree(TreeNode* root) {
        queue<TreeNode*> Q;
        Q.push(root);
        int flag = 0, flag2 = 0;
        while (!Q.empty()) {
            int N = Q.size();
            for (int i = 0; i < N; i++) {
                TreeNode *tmp = Q.front();
                Q.pop();
                if (!tmp) {
                    flag = 1;
                    continue;
                }
                
                if (flag == 1) return false;
                Q.push(tmp->left);
                Q.push(tmp->right);
            }
        }
        return true;
    }
};