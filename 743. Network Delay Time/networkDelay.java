class Solution {
    public int networkDelayTime(int[][] times, int N, int K) {
        HashMap<Integer, List<int[]>> graph = new HashMap<>();
        
        for (int[] time : times) {
            graph.putIfAbsent(time[0], new ArrayList<>());
            graph.get(time[0]).add(new int[]{time[1], time[2]});
        }
        
        int num = 0;
        PriorityQueue<int[]> Q = new PriorityQueue<>((a, b) -> (a[1]-b[1]));
        Q.offer(new int[]{K, 0});
        boolean visited[] = new boolean[N+1];
        
        int time = 0, nodes = 0;
        while (!Q.isEmpty()) {
            int n = Q.size();
            
            for (int i = 0; i < n; i++) {
                int[] node = Q.poll();
                int v = node[0];
                int val = node[1];
                
                if (visited[v] == true) continue;
                
                visited[v] = true;
                nodes++;
                time = val;
                List<int[]> list = graph.get(v);
                if (list == null) continue;
                
                for (int j = 0; j < list.size(); j++) {
                    int[] nei = list.get(j);
                    if (visited[nei[0]] == false)
                        Q.offer(new int[]{nei[0], nei[1] + val});
                }
                
            }
        }
        return (nodes == N)?time : -1;
    }
}