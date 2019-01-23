// 解法一 0ms
public ListNode reverseList(ListNode head) {
    if(head == null){
        return null;
    }
    ListNode curV = head;
    ListNode pareV = null;
    ListNode temp;
    while(curV != null){
        temp = curV.next;
        curV.next = pareV;
        pareV = curV;
        curV = temp;
    }
    return pareV;
}
思路和24差不多，利用cur，pare，temp改变指针指向，一个元素一个元素往最后挪动
pare 一开始为边界值null相当于链接结束
cur   tep                  pare
1,     2,   3,   4,    5,  null
cur   tep              pare
2,     3,   4,   5,    1
cur   tep       pare   
3,     4,   5,   2,    1