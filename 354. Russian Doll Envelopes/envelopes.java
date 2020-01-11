class Solution {
    int dp[][];
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a,b) -> (a[0] - b[0]));
        int len = envelopes.length;
        //dp = new int[len+1][len+1];
        int dp1[] = new int[len+1];
        dp1[0] = 1;
        int ret = 0;
        for (int i = 0; i < len; i++) {
            dp1[i] = 1;
            for (int j = 0; j < i; j++) {
                if (envelopes[j][0] < envelopes[i][0] && envelopes[j][1] < envelopes[i][1]) {
                    dp1[i] = Math.max(dp1[i], 1 + dp1[j]);
                }
            }
            ret = Math.max(ret, dp1[i]);
        }
        return ret;
        //return LIS(envelopes, 0, -1);
    }
    
    // Recursion with memo giving TLE
    public int LIS(int[][] arr, int idx, int prev) {
        if (idx >= arr.length) return 0;
        if (dp[idx][prev+1] != 0) return dp[idx][prev+1];
        
        int exclude = LIS(arr, idx+1, prev);
        int best = exclude;
        
        if (prev == -1 || arr[idx][0] > arr[prev][0] && arr[idx][1] > arr[prev][1]) {
            int include = 1 + LIS(arr, idx+1, idx);
            
            if (include > exclude) {
                best = include;
            }
        }
        dp[idx][prev+1] = best;
        return best;
    }
}