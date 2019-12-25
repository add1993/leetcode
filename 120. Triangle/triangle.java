class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int nn = triangle.get(n-1).size();
        int dp[] = new int[nn+1];
        for (int i = 0; i < nn; i++) {
            dp[i] = triangle.get(n-1).get(i);
        }
        
        for (int i = n-2; i >= 0; i--) {
            List<Integer> list = triangle.get(i);
            for (int j = 0; j < list.size(); j++) {
                dp[j] = list.get(j) + Math.min(dp[j], dp[j+1]);
            }
        }
        return dp[0];
    }
}