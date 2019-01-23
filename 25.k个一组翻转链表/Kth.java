// 解法一 29ms
public ListNode reverseKGroup(ListNode head, int k) {
        // 在数组第一个的前一个位置加入一个0的元素
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        
        // 循环退出条件是数组下一个元素为null
        while(true){
            head = aaa(head, k);
            if(head == null){
                break;
            }
        }
        return dummy.next;
    }
    
    private ListNode aaa(ListNode head, int k){
        ListNode nk = head;
        // 取到数组里的k个元素
        for(int i = 0; i < k; i++){
            nk = nk.next;
            // 判断是否到达数组底部
            if(nk == null){
                return null;
            }
        }
        
        /** 根据k个元素进行反转**/
        
        // 这是每次反转数组的时候的第一个元素
        ListNode node1 = head.next;
        // 这是一个截取出来的k个元素的数组的边界值
        ListNode node2 = nk.next;

        
        // 指向上一个节点的指针
        ListNode prev = null;
        // 指向当前节点的指针
        ListNode curt = node1;

        while(curt != node2){
            ListNode temp = curt.next;
            // 第一次循环：切断curt的next，方便记录curt的数据，以便后续接上链表
            // 后续所以循环：prev记录过curt，所以prev接到curt.next起到链表反转的作用
            curt.next = prev;
            // 用prev记录下curt的数据
            prev = curt;
            // 用curt记录数据后移后的链表数据，每次位移一个位置
            curt = temp;
        }
        // nk数据经过反转，但是不受curt = temp;影响，所以赋值给head.next;
        head.next = nk;
        // node1需要继续参与循环，node2记录了剩下应该参与反转的数组元素，所以把node2赋值给node1.next
        // 此操作也会把nk的链接改变，但不会改变head和head.next
        node1.next = node2;
        return node1;
    }