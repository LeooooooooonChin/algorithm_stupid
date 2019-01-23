// 解法一 14ms
public boolean hasCycle(ListNode head) {
    if(head == null){
        return false;
    }
    Set<ListNode> exists = new HashSet<>();
    while(head != null){
        if(exists.contains(head)){
            return true;
        }else{
            exists.add(head);
        }
        head = head.next;
    }
    return false;
}
// 解法二 1ms
public boolean hasCycle(ListNode head) {
    if(head == null || head.next == null){
        return false;
    }
    
    ListNode slow = head;
    ListNode fast = head.next;
    
    while(slow != fast){
        if(fast.next == null || fast.next.next == null){
            return false;
        }
        slow = slow.next;
        fast = fast.next.next;
    }
    return true;
}