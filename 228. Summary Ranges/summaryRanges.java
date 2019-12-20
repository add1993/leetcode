class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        
        int i = 0;
        while (i < nums.length) {
            String res = "";
            res += Integer.toString(nums[i++]);
            int flag = 0;
            while (i < nums.length && nums[i] - nums[i-1] == 1) {
                flag = 1;
                i++;
            }
            if (flag == 1)
                res += "->" + Integer.toString(nums[i-1]);
            result.add(res);
        }
        return result;
    }
}