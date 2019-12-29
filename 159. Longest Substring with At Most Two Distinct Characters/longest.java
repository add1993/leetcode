class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        char prev = ' ', curr = ' ';
        int count = 0, idx = 0, result = Integer.MIN_VALUE;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!map.containsKey(ch)) {
                count++;
                if (count > 2) {
                    idx = Math.max(idx, map.get(prev))+1;
                    count--;
                }
                map.remove(prev);
                map.put(ch, i);
            } else {
                map.put(ch, Math.max(i, map.get(ch)));
            }
            // Update the current and previous characters any time when ch != curr. This will help us in removing the correct prev character.
            if (ch != curr) {
                prev = curr;
                curr = ch;
            }
            
            result = Math.max(result, i+1 - idx);
        }
        return (result == Integer.MIN_VALUE)? 0 : result;
    }
}