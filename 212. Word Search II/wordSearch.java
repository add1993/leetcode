class Solution {
    class TrieNode {
        boolean isWord;
        TrieNode[] children;
        
        public TrieNode() {
            children = new TrieNode[26];
        }
    }
    
    public void insertWord(TrieNode root, String word) {
        TrieNode cur = root;
        
        for (int i = 0; i < word.length(); i++) {
            int ch = word.charAt(i) - 'a';
            if (cur.children[ch] == null) 
                cur.children[ch] = new TrieNode();
            cur = cur.children[ch];
        }
        cur.isWord = true;
    }
    
    int rows[] = {1, -1, 0, 0};
    int cols[] = {0, 0, 1, -1};
    List<String> result = new ArrayList<>();
    HashSet<String> set = new HashSet<>();
    public void searchTree(TrieNode root, char[][] board, boolean[][] visited, int row, int col, String res) {
        if (visited[row][col]) return;
        TrieNode curr = root;
        int idx = board[row][col] - 'a';
        if (curr.children[idx] == null) return;
        
        res += ""+ board[row][col];
        curr = curr.children[idx];
        if (curr.isWord && !set.contains(res)) {
            result.add(res);
            set.add(res);
        }
        
        
        for (int i = 0; i < 4; i++) {
            int nrow = row + rows[i];
            int ncol = col + cols[i];
            visited[row][col] = true;
            
            if (nrow >= 0 && ncol >= 0 && nrow < board.length && ncol < board[0].length && visited[nrow][ncol] == false) {
                searchTree(curr, board, visited, nrow, ncol, res);
            }
            visited[row][col] = false;
        }
        
    }
    
    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = new TrieNode();
        
        for (String word : words) {
            insertWord(root, word);
        }
        
        int m = board.length;
        int n = board[0].length;
        
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                String res = "";
                boolean visited[][] = new boolean[m][n];
                searchTree(root, board, visited, i, j, res);
            }
        }
        
        return result;
    }
}