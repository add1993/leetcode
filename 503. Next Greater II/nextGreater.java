class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int[]res = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < nums.length; i++) {
            while (!stack.empty() && nums[i] > nums[stack.peek()]) {
                res[stack.pop()] = nums[i];
            }    
            stack.push(i);
        }
        
        for (int i = 0; i < nums.length; i++) {
            while (!stack.empty() && nums[i] > nums[stack.peek()]) {
                res[stack.pop()] = nums[i];
            }
            if (stack.empty()) break;
        }
        
        while (!stack.empty()) {
            res[stack.pop()] = -1;
        }
        
        return res;
    }
}