class Solution {
    public Node cloneGraph(Node node) {
        Map<Integer, Node> map = new HashMap();
        Queue<Node> q = new LinkedList();
        q.add(node);
        
        while(!q.isEmpty()){
            Node n = q.poll();
            Node gn = map.get(n.val);
            if(gn==null){
                gn = new Node(n.val, new LinkedList());
                map.put(n.val, gn);
            }
            for(Node nei: n.neighbors){
                
                Node gnei = map.get(nei.val);
                if(gnei==null){
                    q.add(nei);
                    gnei = new Node(nei.val, new LinkedList());
                    map.put(nei.val, gnei);
                    gn.neighbors.add(gnei);
                }
                else{
                    gn.neighbors.add(gnei);
                }
            }
        }
        return map.get(node.val);
    }
}