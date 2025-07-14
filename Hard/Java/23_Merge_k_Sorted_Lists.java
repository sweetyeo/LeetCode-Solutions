class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;

        PriorityQueue<ListNode> heap = new PriorityQueue<>(
            (a, b) -> Integer.compare(a.val, b.val)
        );

        for (ListNode node : lists) {
            if (node != null) {
                heap.offer(node);
            }
        }

        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;

        while (!heap.isEmpty()) {
            ListNode minNode = heap.poll();
            current.next = minNode;
            current = current.next;

            if (minNode.next != null) {
                heap.offer(minNode.next);
            }
        }

        return dummy.next;
    }
}
