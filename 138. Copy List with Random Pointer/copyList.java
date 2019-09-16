class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return head;
        Node nhead = new Node(head.val, head.next, head.random);
        Node temp = head.next, nh = nhead;
        
        HashMap<Node, Node> map = new HashMap<>();
        map.put(head, nhead);
        while (temp != null) {
            nh.next = new Node(temp.val, temp.next, temp.random);
            map.put(temp, nh.next);
            temp = temp.next;
            nh = nh.next;
        }
        
        temp = nhead;
        
        while (temp != null) {
            temp.random = map.get(temp.random);
            temp = temp.next;
        }
        return nhead;
    }
}