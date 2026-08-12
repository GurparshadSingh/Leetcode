/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>(
                (a, b) -> {
                    return a.val - b.val;
                });

        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        for (ListNode head : lists) {
            if (head != null) {
                pq.offer(head);
            }
        }

        while (!pq.isEmpty()) {
            ListNode small = pq.poll();
            curr.next = small;
            curr = curr.next;
            if (small.next != null) {
                pq.offer(small.next);
            }
        }
        return dummy.next;

    }
}