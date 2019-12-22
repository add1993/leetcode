class Solution {
    public String longestWordIterative(String[] words) {
        Arrays.sort(words);
        Set<String> built = new HashSet<String>();
        String res = "";
        for (String w : words) {
            if (w.length() == 1 || built.contains(w.substring(0, w.length() - 1))) {
                res = w.length() > res.length() ? w : res;
                built.add(w);
            }
        }
        return res;
    }
    
    class TrieNode {
        public boolean isWord;
        public String word;
        public char ch;
        public TrieNode children[];
        
        TrieNode(char ch) {
            ch = ch;
            children = new TrieNode[26];
        }
    }
    
    public void insertNode(String word) {
        TrieNode tmp = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (tmp == null) {
                tmp = new TrieNode(ch);
                root = tmp;
            }
            
            if (tmp.children[ch-'a'] == null) {
                tmp.children[ch-'a'] = new TrieNode(ch);
                
            }
            tmp = tmp.children[ch-'a'];
        }
        tmp.isWord = true;
        tmp.word = word;
    }
    
    public void dfs(TrieNode root) {
        for (int i = 0; i < 26; i++) {
            if (root.children[i] != null) {
                traverse(root.children[i]);   
            }
        }
    }
        
    public void traverse(TrieNode root) {
        for (int i = 0; i < 26; i++) {
            if (root.children[i] != null) {
                if (root.isWord == true) {
                    if (root.word.length() > result.length() || ((root.word.length() == result.length()) && (root.word.compareTo(result) < 0))) {
                        result = root.word;
                    }
                    
                    if (root.children[i].isWord == true) {
                        String str = root.children[i].word;
                        if (str.length() > result.length())
                            result = str;
                        else if (str.length() == result.length()) {
                            if (str.compareTo(result) < 1) {
                                result = str;
                            }
                        }
                    }
                    traverse(root.children[i]);
                }
                
            }
        }
    }
    
    public TrieNode root = null;
    public String result = "";
    public String longestWord(String[] words) {
        for (String str : words) {
            insertNode(str);
        }
        
        dfs(root);
        return result;
    }
}