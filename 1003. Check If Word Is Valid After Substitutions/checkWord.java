class Solution {
    public boolean isValid(String S) {
        String prev = "";
        while (S.length() > 0 && S.equals(prev) == false) {
            prev = S;
            S = S.replace("abc", "");
        }
        if (S.length() > 0) return false;
        return true;
    }
}