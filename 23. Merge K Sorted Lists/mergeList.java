/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null) return null;
        int k = lists.length;
        if (k < 1) return null;
        if (k == 1) return lists[0];
        return mergeDivide(lists, 0, k-1);
        /*ListNode root = null;
        for (int i = 0; i < k; i++) {
            root = merge(root, lists[i]);
        }
        return root;*/
    }
    
    public ListNode mergeDivide(ListNode[] lists, int start, int end) {
        if (start == end) return lists[start];
        
        int mid = (start + end)/2;
        ListNode left = mergeDivide(lists, start, mid);
        ListNode right = mergeDivide(lists, mid+1, end);
        return merge(left, right);
    }
    
    public ListNode merge(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        ListNode root = null, tmp = null;
        
        while (list1 != null || list2 != null) {
            if (list1 == null) {
                tmp.next = list2;
                tmp = tmp.next;
                list2 = list2.next;
            } else if (list2 == null) {
                tmp.next = list1;
                tmp = tmp.next;
                list1 = list1.next;
            } else if (list1.val < list2.val) {
                if (root == null) {
                    root = list1;
                    tmp = root;
                } else {
                    tmp.next = list1;
                    tmp = tmp.next;
                }
                list1 = list1.next;
            } else {
                if (root == null) {
                    root = list2;
                    tmp = root;
                } else {
                    tmp.next = list2;
                    tmp = tmp.next;
                }
                list2 = list2.next;
            }
        }
        
        return root;
    }
}