/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    HashMap<Integer, List<Integer>> graph = new HashMap<>();
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        Queue<TreeNode> Q = new LinkedList<>();
        Q.offer(root);
        
        while (!Q.isEmpty()) {
            TreeNode node = Q.poll();
            graph.putIfAbsent(node.val, new ArrayList<>());
            if (node.left != null) {
                graph.get(node.val).add(node.left.val);
                graph.putIfAbsent(node.left.val, new ArrayList<>());
                graph.get(node.left.val).add(node.val);
                Q.offer(node.left);
            }
            
            if (node.right != null) {
                graph.get(node.val).add(node.right.val);
                graph.putIfAbsent(node.right.val, new ArrayList<>());
                graph.get(node.right.val).add(node.val);
                Q.offer(node.right);
            }
        }
        
        Queue<int[]> nQ = new LinkedList<>();
        nQ.offer(new int[]{target.val, 0});
        List<Integer> result = new ArrayList<>();
        HashMap<Integer, Integer> visited = new HashMap<>();
        while (!nQ.isEmpty()) {
            int[] node = nQ.poll();
            int v = node[0];
            if (visited.containsKey(v)) continue;
            visited.put(v, 1);
            
            int dist = node[1];
            if (dist == K) {
                result.add(v);
            }
            
            if (graph.get(v) == null) continue;
            
            for (int u : graph.get(v)) {
                nQ.offer(new int[]{u, dist+1});
            }
        }
        return result;
    }
}