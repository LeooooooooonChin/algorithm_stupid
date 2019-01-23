// 解法一 1ms
public ListNode detectCycle(ListNode head) {
    if(head == null || head.next == null){
        return null;
    }
    ListNode slow = head;
    ListNode fast = head.next;
    // 判断是否有环
    while(slow != fast){
        if(fast == null || fast.next == null){
            return null;
        }
        slow = slow.next;
        fast = fast.next.next;
    }
    // 有环的情况下找到入环节点
    while (head != slow.next) {
        head = head.next;
        slow = slow.next;
    }
    return head;
}