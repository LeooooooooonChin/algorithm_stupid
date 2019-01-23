// 解法一 4ms
public ListNode swapPairs(ListNode head) {
    if(head == null || head.next == null) {
        return head;
    }
    ListNode temp = head;
    while(temp != null && temp.next != null) {
        int k = temp.next.val;
        temp.next.val = temp.val;
        temp.val = k;
        temp = temp.next.next;
    }
    return head;
}
// 解法二 4ms
public ListNode swapPairs(ListNode head) {
    if(head == null || head.next == null) {
        return head;
    }
    ListNode pre = new ListNode(0);
    pre.next = head;
    head = pre;
    while(head.next != null && head.next.next != null){
        ListNode a = head.next;
        ListNode b = head.next.next;
        head.next = b;//2,4
        a.next = b.next;// 3,5
        b.next = a;// 1,3
        head = a;// 1,3
    }
    return pre.next;
}
两两交换链表思维方式
h   a   b
0   1   2   3   4   5
        h   a   b
0   2   1   3   4   5
                h
0   2   1   4   3   5