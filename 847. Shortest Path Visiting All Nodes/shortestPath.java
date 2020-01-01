class Solution {
    public int shortestPathLength(int[][] graph) {
        int N = graph.length;
        Queue<Node> Q = new LinkedList<>();
        Set<Node> set = new HashSet<>();
        
        for (int i = 0; i < N; i++) {
            int mask = (1 << i);
            Q.offer(new Node(i, mask, 1));
            set.add(new Node(i, mask, 0));
        }
        
        while (!Q.isEmpty()) {
            Node node = Q.poll();
            
            if(node.bitmask == (1 << N) - 1) {
                return node.cost - 1;
            } else {
                for (int v : graph[node.node]) {
                    int mask = node.bitmask;
                    mask |= (1 << v);
                    Node nei = new Node(v, mask, node.cost+1);
                    
                    if (!set.contains(nei)) {
                        Q.offer(nei);
                        set.add(nei);
                    }
                }
            }
        }
        
        return -1;
    }
    
    public class Node {
        int node;
        int bitmask;
        int cost;
        
        public Node(int node, int bitmask, int cost) {
            this.node = node;
            this.bitmask = bitmask;
            this.cost = cost;
        }
        
        public boolean equals(Object o){
            Node p = (Node) o;
            return bitmask == p.bitmask && node == p.node && cost == p.cost;
        }
        
        public int hashCode(){
            return 1331 * bitmask + 7193 * node + 727 * cost;
        }
    }
}