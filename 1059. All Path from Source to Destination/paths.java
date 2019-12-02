class Solution {
    public boolean leadsToDestination(int n, int[][] edges, int source, int destination) {
        
        // working dfs solution
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        HashMap<Integer, Integer> indegree = new HashMap<>();
        List<Integer> adj;
        for (int[] edge : edges) {
            adj = graph.getOrDefault(edge[0], new ArrayList<>());
            adj.add(edge[1]);
            graph.put(edge[0], adj);
        }
        if (source == destination && !graph.containsKey(destination)) return true;
        if (edges.length < 1) return false;
        
        List<Integer> nei = graph.get(source);
        if (nei != null) {
            for (int i = 0; i < nei.size(); i++) {
                HashMap<Integer, Integer> visited = new HashMap<>();
                visited.put(source, 1);
                if (!dfs(graph, visited, nei.get(i), destination)) {
                    return false;
                }
            }
        } else {
            return false;
        }
        return true;
    }
    
    boolean dfs(HashMap<Integer, List<Integer>> graph, HashMap<Integer, Integer> visited, int nei, int des) {
        if (visited.containsKey(nei)) return false;
        if (graph.containsKey(nei)) {
            List<Integer> neList = graph.get(nei);
            boolean val = true;
            visited.put(nei, 1);
            for (int i = 0; i < neList.size(); i++) {
                val = dfs(graph, visited, neList.get(i), des);
                if (!val) {
                    return false;
                }
            }
            visited.remove(nei);
            return true;
        } else {
            if (nei == des) {
                return true;
            } else {
                return false;
            }
        }
            
    }
}