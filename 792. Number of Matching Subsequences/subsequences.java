class Solution {
    HashMap<Character, List<Integer>> index = new HashMap<>();
    public int numMatchingSubseq(String S, String[] words) {
        for (int i = 0; i < S.length(); i++) {
            index.putIfAbsent(S.charAt(i), new ArrayList<>());
            index.get(S.charAt(i)).add(i);
        }
        
        int res = 0;
        
        for (String word : words) {
            if (checkString(word)) {
                res++;
            }
        }
        return res;
    }
    
    public boolean checkString(String word) {
        int idx = -1;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (!index.containsKey(ch)) return false;
            List<Integer> list = index.get(ch);
            idx = getNext(list, idx);
            
            if (idx == -1) return false;
        }
        return true;
    }
    
    public int getNext(List<Integer> list, int val) {
        int start = 0, end = list.size();
        while (start < end) {
            int mid = (start+end)/2;
            if (list.get(mid) > val) {
                end = mid;
            } else {
                start = mid+1;
            }
        }
        if (start == list.size()) return -1;
        return list.get(start);
    }
    
}