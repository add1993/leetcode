class Solution {
    char[] ops = new char[]{'+', '-', '*'};
    List<String> result = new ArrayList<>();
    public List<String> addOperators(String num, int target) {
        StringBuilder sb = new StringBuilder();
        dfs(sb, num, target, 0, 0, 0);
        return result;
    }
    
    public void dfs(StringBuilder sb, String num, int target, int idx, long prev, long multi) {
        if (idx == num.length()) {
            if (target == prev) {
                result.add(sb.toString());
            }
            return;
        }
        
        for (int i = idx; i < num.length(); i++) {
            if(num.charAt(idx) == '0' && i != idx) break;
            long curr = Long.parseLong(num.substring(idx, i + 1));
            int len = sb.length();
            
            if (idx == 0) {
                dfs(sb.append(curr), num, target, i+1, curr, curr);
                sb.setLength(len);
            } else {
                dfs(sb.append("+").append(curr), num, target, i + 1, prev + curr, curr); 
                sb.setLength(len);
                dfs(sb.append("-").append(curr), num, target, i + 1, prev - curr, -curr); 
                sb.setLength(len);
                dfs(sb.append("*").append(curr), num, target, i + 1, prev - multi + multi * curr, multi * curr); 
                sb.setLength(len);
            }
        }
    }
}