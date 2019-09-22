class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int arr[][] = new int[text1.length()+2][text2.length()+2];
        int n = text1.length();
        int m = text2.length();
        
        int best, ignore, include;
        for (int currA = n; currA > 0; currA--) {
            for (int currB = m; currB > 0; currB--) {
                ignore = Math.max(arr[currA+1][currB], arr[currA][currB+1]);
                best = ignore;
                
                if (text1.charAt(currA-1) == text2.charAt(currB-1)) {
                    include = 1 + arr[currA+1][currB+1];
                    if (include > ignore) {
                        best = include;
                    }
                }
                arr[currA][currB] = best;
            }
            
        }
        return arr[1][1];
    }
}