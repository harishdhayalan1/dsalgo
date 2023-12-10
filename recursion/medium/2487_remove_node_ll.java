class Solution {
  public ListNode removeNodes(ListNode head) {
      if(head == null) {
        return null;
      }
      ListNode next = removeNodes(head.next);
      if(next == null) {
        return head;
      }
      if(head.val >= next.val) {
        head.next = next;
        return head;
      }
      return next;
  }

}
